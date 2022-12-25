import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int N = Integer.parseInt(br.readLine());
		int[] numbers = new int[N];
		
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; ++i)
			numbers[i] = Integer.parseInt(st.nextToken());
		
		int K = Integer.parseInt(br.readLine());
		
		long ans = 0;
		int s, e, sum;
		s = e = 0;
		sum = numbers[0];
		while(e < N) {
			
			if(sum > K) {
				ans += (N - e);
				sum -= numbers[s++];
			}else {
				if(e == N-1) break;
				sum += numbers[++e];
			}
			if(e < s) e = s;
		}
		
		System.out.println(ans);
	}

}