import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int N = Integer.parseInt(br.readLine());
		int[] waters = new int[N];
		
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i < N; ++i) {
			waters[i] = Integer.parseInt(st.nextToken());
		}
		
		Arrays.sort(waters);
		int[] water = new int[3];
		long ans = Long.MAX_VALUE;
		long sum;
		
		int s, e;
		int l, m, r;
		
		for(int k = 0; k < N - 2; ++k) {
			s = k+1; e = N - 1;
			
			m = waters[k];
			while(s < e) {
				l = waters[s]; r = waters[e];
				
				sum = (long)m + (long)l + (long)r;
				
				if(sum < 0) ++s;
				else --e;
				
				sum = sum < 0 ? -sum : sum;
				if(ans > sum) {
					ans = sum;
					water[0] = m; water[1] = l; water[2] = r;
				}
				
			}
			
		}
		
		System.out.printf("%d %d %d", water[0], water[1], water[2]);
		
	}
}

