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
		int[][] fees = new int[N][3];
		int[][] dp = new int[N][3];
		
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < 3; j++)
				fees[i][j] = Integer.parseInt(st.nextToken());
		}

		dp[0][0] = fees[0][0];
		dp[0][1] = fees[0][1];
		dp[0][2] = fees[0][2];
		
		for(int i = 1; i < N; i++) {
			dp[i][0] = Math.min(dp[i-1][1], dp[i-1][2]) + fees[i][0];
			dp[i][1] = Math.min(dp[i-1][0], dp[i-1][2]) + fees[i][1];
			dp[i][2] = Math.min(dp[i-1][0], dp[i-1][1]) + fees[i][2];
		}
		
		int min = Integer.MAX_VALUE;
		for(int i = 0; i < 3; i++)
			min = Math.min(min, dp[N-1][i]);
		
		System.out.println(min);
	}

}