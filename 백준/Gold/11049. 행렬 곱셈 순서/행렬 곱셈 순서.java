import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	
	static final int INF = Integer.MAX_VALUE;
	static int N;
	static int[][] matrix, dp;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		N = Integer.parseInt(br.readLine());
		matrix = new int[N][2];
		
		for(int i = 0; i < N; ++i) {
			st = new StringTokenizer(br.readLine());
			
			matrix[i][0] = Integer.parseInt(st.nextToken());
			matrix[i][1] = Integer.parseInt(st.nextToken());
			
		}
		
		dp = new int[N][N];
		for(int i = 0; i < N; ++i) Arrays.fill(dp[i], INF);
		dp[0][N-1] = recursive(0, N-1);
		System.out.println(dp[0][N-1]);
		
	}

	private static int recursive(int s, int e) {
		if(s == e) return 0;
		if(dp[s][e] != INF) return dp[s][e];
		
		int val;
		for(int i = s; i < e; ++i) {
			val = recursive(s, i) + recursive(i+1, e) + (matrix[s][0] * matrix[i][1] * matrix[e][1]);
			dp[s][e] = Math.min(dp[s][e], val);
		}
		
		return dp[s][e];
		
	}

}