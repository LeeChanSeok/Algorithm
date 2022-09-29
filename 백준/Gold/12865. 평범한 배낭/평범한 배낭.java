import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		
		int[] dp = new int[K+1];
		
		int[] w = new int[N];
		int[] v = new int[N];
		for(int i = 0; i < N; ++i) {
			st = new StringTokenizer(br.readLine());
			w[i] = Integer.parseInt(st.nextToken());
			v[i] = Integer.parseInt(st.nextToken());
		}

		for(int i = 0; i < N; i++) {
			
			for(int j = K; j >0; --j) {
				if(w[i] > j) break;
				dp[j] = Math.max(dp[j], dp[j-w[i]] + v[i]);
			}
		}
		System.out.println(dp[K]);
		
	}

}