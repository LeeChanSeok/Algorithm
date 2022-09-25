import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

public class Main {
	static int[] dp;
	static int[] path;
	static int min;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		
		int N = Integer.parseInt(br.readLine());
		int INF = Integer.MAX_VALUE;
		
		dp = new int[N+1];
		Arrays.fill(dp, INF);
		dp[N] = 0;
		
		for(int i = N; i > 1; --i) {
			if(i%3 == 0) dp[i/3] = Math.min(dp[i/3], dp[i] + 1);
			if(i%2 == 0) dp[i/2] = Math.min(dp[i/2], dp[i] + 1);
			dp[i-1] = Math.min(dp[i-1], dp[i] + 1);
		}
		
		int n = N;
		min = dp[1];
		path = new int[min+1];
		
		path[0] = N;
		dfs(N, 1);
		path[min] = 1;

		sb.append(min + "\n");
		for(int i : path)
			sb.append(i + " ");
		
		bw.write(sb.toString());
		bw.close();
		
		
	}
	private static boolean dfs(int idx, int cnt) {

		if(idx < 1) return false;
		
		if(cnt == min+1) {		
			if(idx == 1)
				return true;
			return false;
		}
		
		if(idx%3 == 0 && dp[idx/3] == cnt) {
			path[cnt] = idx/3;
			if(dfs(idx/3, cnt+1)) return true;
		}
		
		if(idx%2 == 0 && dp[idx/2] == cnt) {
			path[cnt] = idx/2;
			if(dfs(idx/2, cnt+1)) return true;
		}
		
		if(dp[idx-1] == cnt) {
			path[cnt] = idx-1;
			if(dfs(idx-1, cnt+1)) return true; 
		}
		
		return false;
	}

}