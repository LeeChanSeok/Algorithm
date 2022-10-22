import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int N = Integer.parseInt(br.readLine());
		
		int[][] dp = new int[N+1][2];
		int t, p;
		for(int i = 0; i < N; ++i) {
			st = new StringTokenizer(br.readLine());
			
			t = Integer.parseInt(st.nextToken());
			p = Integer.parseInt(st.nextToken());
			
			dp[i][0] = t;
			dp[i][1] = p;
		}

		for(int i = N - 1; i >= 0; --i) {
			t = dp[i][0];
			p = dp[i][1];
			
			if(i + t > N) dp[i][1] = dp[i+1][1];
			else{
				dp[i][1] = Math.max(dp[i+1][1], dp[i][1] + dp[i+t][1]);
			}
		}

		System.out.println(dp[0][1]);
	}

}