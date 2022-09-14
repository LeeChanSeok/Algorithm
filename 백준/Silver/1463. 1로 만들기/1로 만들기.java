import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
	static int[] dp;
	static final int INF = Integer.MAX_VALUE;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		dp = new int[N+1];
		Arrays.fill(dp, INF);

		dp[1] = 0;
		System.out.println(dfs(N));

	}

	private static int dfs(int n) {
		
		if(dp[n] != INF) return dp[n];
		
		if(n % 3 == 0) 
			dp[n] = Math.min(dp[n], dfs(n/3)+1);
		if(n % 2 == 0)
			dp[n] = Math.min(dp[n], dfs(n/2)+1);
		if(n - 1 >0)
			dp[n] = Math.min(dp[n], dfs(n-1)+1);
		
		return dp[n];
	}

}