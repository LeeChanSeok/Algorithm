import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int N = Integer.parseInt(br.readLine());
		int[] water = new int[N];
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i < N; ++i)
			water[i] = Integer.parseInt(st.nextToken());
		
		int s = 0, e = N-1;
		long sum;
		long ans = Long.MAX_VALUE;
		int[] pnt = new int[2];
		int l, r;
		
		while(s < e) {
			l = water[s]; r = water[e];
			sum = l + r;
			
			if(sum < 0) ++s;
			else --e;
			
			sum = sum < 0? -sum : sum;
			
			if(ans > sum) {
				ans = sum;
				pnt[0] = l; pnt[1] = r; 
			}
			
		}

		System.out.println(pnt[0] + " " + pnt[1]);
	}

}