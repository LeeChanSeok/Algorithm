import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int N = Integer.parseInt(br.readLine());
		
		int[][] dp = new int[2][3];
		
		for(int i = 0; i < N; ++i) {
			st = new StringTokenizer(br.readLine());
			
			int[] num = {Integer.parseInt(st.nextToken()),
					Integer.parseInt(st.nextToken()),
					Integer.parseInt(st.nextToken())};
			
			int[][] new_dp = new int[2][3];
			// max
			new_dp[0][0] = Math.max(dp[0][0], dp[0][1]) + num[0];
			new_dp[0][1] = Math.max(dp[0][0], Math.max(dp[0][1], dp[0][2])) + num[1];
			new_dp[0][2] = Math.max(dp[0][1], dp[0][2]) + num[2];

			// min
			new_dp[1][0] = Math.min(dp[1][0], dp[1][1]) + num[0];
			new_dp[1][1] = Math.min(dp[1][0], Math.min(dp[1][1], dp[1][2])) + num[1];
			new_dp[1][2] = Math.min(dp[1][1], dp[1][2]) + num[2];
			
			for(int j = 0; j < 2; ++j) {
				for(int k = 0; k < 3; ++k)
					dp[j][k] = new_dp[j][k];
			}
		}
		
		int max = Math.max(dp[0][0], Math.max(dp[0][1], dp[0][2]));
		int min = Math.min(dp[1][0], Math.min(dp[1][1], dp[1][2]));
		
		System.out.println(max + " " + min);
		
	}

}