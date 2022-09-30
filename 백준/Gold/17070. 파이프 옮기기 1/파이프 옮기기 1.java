import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int N = Integer.parseInt(br.readLine());

		int[][] map = new int[N][N];

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		int[][][] dp = new int[N][N][3];
		
		for(int j = 1; j < N; j++) {
			if(map[0][j] == 1) break;
			dp[0][j][0] = 1;
		}
		
		for(int i = 1; i < N; i++) {
			for(int j = 2; j < N; j++) {
				if(map[i][j] == 1) continue;
				if(map[i][j-1] != 1) dp[i][j][0] = dp[i][j-1][0] + dp[i][j-1][1];
				if(map[i-1][j-1] != 1 && map[i-1][j] != 1 && map[i][j-1] != 1) dp[i][j][1] = dp[i-1][j-1][0] + dp[i-1][j-1][1] + dp[i-1][j-1][2];
				if(map[i-1][j] != 1) dp[i][j][2] = dp[i-1][j][2] + dp[i-1][j][1];
			}
		}
		
		int sum = 0;
		for(int d = 0; d < 3; d++) sum += dp[N-1][N-1][d];
			
		System.out.println(sum);
	}

}