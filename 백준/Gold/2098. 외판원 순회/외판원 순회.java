import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	
	static final int INF = 987654321;
	static int N, min;
	static int[][] graph, dp;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		N = Integer.parseInt(br.readLine());
		graph = new int[N][N];
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j =0; j < N; j++) {
				graph[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		dp = new int[N][1 << N];
		for(int i = 0; i < N; ++i) Arrays.fill(dp[i], -1);
		
		System.out.println(TSP(0, 1));
	}

	private static int TSP(int city, int flag) {

		if(flag == ((1<<N) -1)) {
			if(graph[city][0] != 0) {
				return graph[city][0];
			}
			return INF;
		}
		
		if(dp[city][flag] != -1) return dp[city][flag];
		dp[city][flag] = INF;
		
		for(int i = 0; i < N; ++i) {
			if((flag & (1 << i)) != 0 || graph[city][i] == 0) continue;
			
			dp[city][flag] = Math.min(dp[city][flag], TSP(i, flag | (1 << i)) + graph[city][i])  ;
		
		}
	
		return dp[city][flag];
	}

}