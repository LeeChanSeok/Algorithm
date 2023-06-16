import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String str1 = br.readLine();
		String str2 = br.readLine();
		
		int N = str1.length();
		int M = str2.length();
		
		int[][] dp = new int[N+1][M+1];
		
		for(int i = 1; i <= N; ++i) {
			for(int j = 1; j <= M; ++j) {
				if(str1.charAt(i-1) == str2.charAt(j-1)) dp[i][j] = dp[i-1][j-1] + 1;
				else dp[i][j] = Math.max(dp[i-1][j-1], Math.max(dp[i-1][j], dp[i][j-1]));
			}
		}
		
		System.out.println(dp[N][M]);
		if(dp[N][M] != 0) {
			StringBuilder sb = new StringBuilder();
			int i = N, j = M;
			while(i > 0 && j > 0) {
				if(dp[i][j] == dp[i][j-1]) --j;
				else if(dp[i][j] == dp[i-1][j]) --i;
				else{
					sb.append(str1.charAt(i-1));
					--i; --j;
				}
			}
			System.out.println(sb.reverse().toString());
		}
	}

}