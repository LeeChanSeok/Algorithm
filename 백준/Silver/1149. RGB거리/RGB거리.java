import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

	static int N;
	static int[][] fees, dp;
	static int INF = Integer.MAX_VALUE;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		N = Integer.parseInt(br.readLine());
		fees = new int[N][3];
		
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < 3; j++)
				fees[i][j] = Integer.parseInt(st.nextToken());
		}
		
		dp = new int[N][3];
		for(int i = 0;  i < N; i++) Arrays.fill(dp[i], INF);
		
		for(int i = 0 ; i < 3; i++) {
			dfs(0, i);
		}
		int min = INF;
		for(int i = 0; i < 3; i++)
			min = Math.min(min, dp[0][i]);
		System.out.println(min);
	}
	private static int dfs(int cnt, int color) {
		
		if(cnt == N) return 0;
		if(dp[cnt][color] != INF) return dp[cnt][color];
		
		for(int i = 0; i < 3; i++) {
			if(color == i) continue;
			
			int fee = dfs(cnt+1, i);
			if(dp[cnt][color] > fee + fees[cnt][color]) {
				dp[cnt][color] = fee + fees[cnt][color];
			}
		}
		
		return dp[cnt][color];
	}

}