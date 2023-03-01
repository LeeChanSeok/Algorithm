import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	static int[][] dp;
	static int N, M, max;
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		char[] A = br.readLine().toCharArray();
		char[] B = br.readLine().toCharArray();
		
		N = A.length;
		M = B.length;
		
		dp = new int[N+1][M+1];
		for(int i = 1; i <= N; ++i) dp[i][0] = i;
		for(int j = 1; j <= M; ++j) dp[0][j] = j;
		
		for(int i = 1; i <= N; ++i) {
			for(int j = 1; j <= M; ++j) {
				
				if(A[i-1] == B[j-1]) dp[i][j] = dp[i-1][j-1];
				else {
					dp[i][j] = Math.min(dp[i-1][j-1], Math.min(dp[i-1][j], dp[i][j-1]))+1;
				}
			}
		}

		System.out.println(dp[N][M]);
	}
	
}