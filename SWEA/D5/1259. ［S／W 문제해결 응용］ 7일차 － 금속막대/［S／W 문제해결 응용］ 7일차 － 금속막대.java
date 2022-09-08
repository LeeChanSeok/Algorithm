import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
	static int N;
	static int[][] screws;
	static int[] dp;
	static boolean[] visit;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb;
		
		int T = Integer.parseInt(br.readLine());
		for(int tc = 1; tc <= T; tc++) {
			N = Integer.parseInt(br.readLine());
			st = new StringTokenizer(br.readLine());
			screws = new int[N][2];
			for(int i = 0; i < N; i++) {
				screws[i][0] = Integer.parseInt(st.nextToken());
				screws[i][1] = Integer.parseInt(st.nextToken());
			}
			
			dp = new int[N];
			visit = new boolean[N];
			for(int i = 0; i < N; i++)
				dfs(i, 0);
			sb = new StringBuilder();
			sb.append("#" + tc + " ");
			for(int i = N; i > 0; i--) {
				for(int j = 0; j<N; j++) {
					if(dp[j] == i) {
						sb.append(screws[j][0] + " " + screws[j][1] + " ");
						break;
					}
				}
			}			
			System.out.println(sb.toString());
			
		}//tc종료
	}
	private static int dfs(int idx, int cnt) {

		if(dp[idx] != 0) return dp[idx];
		
		for(int i = 0; i < N; i++) {
			if(!visit[i] && screws[idx][1] == screws[i][0]) {
				visit[i] = true;
				int length = dfs(i, cnt+1) + 1;
				visit[i] = false;
				
				if(dp[idx] < length) dp[idx] = length;
			}
		}
		
		return dp[idx] = Math.max(dp[idx], 1);
	}

}
