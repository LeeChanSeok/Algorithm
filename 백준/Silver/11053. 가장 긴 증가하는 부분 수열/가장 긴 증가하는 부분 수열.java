import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int max, N;
	static int[] set, dp;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		N = Integer.parseInt(br.readLine());
		set = new int[N];
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i < N; i++)
			set[i] = Integer.parseInt(st.nextToken());
		
		dp = new int[N];
		for(int i = 0; i < N; i++) {
			dfs(i, set[i], 1);
		}
		int max = 0;
		for(int i : dp) {
			max = Math.max(max, i);
		}
		System.out.println(max);
	}
	private static int dfs(int idx, int num, int cnt) {
		
		if(dp[idx] != 0) return dp[idx];
		
		for(int i = idx + 1; i < N; i++) {
			if (set[i] > num) {
				int length = dfs(i, set[i], cnt+1) + 1;
				if(length > dp[idx]) {
					dp[idx] = length;
				}
			}
		}
		
		return dp[idx] = Math.max(dp[idx], 1);
	}

}