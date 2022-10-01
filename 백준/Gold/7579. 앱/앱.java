import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());

		int[][] apps = new int[N][2];


		for (int j = 0; j < 2; ++j) {
			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < N; ++i) {
				apps[i][j] = Integer.parseInt(st.nextToken()); 
			}
		}
		int totalM = 0;
		for (int i = 0; i < N; ++i) {
			totalM += apps[i][0]; 
		}

		int[] dp = new int[totalM + 1];
		int INF = Integer.MAX_VALUE;
		Arrays.fill(dp, INF);
		int mIdx = 0;
		for(int i = 0; i < N; ++i) {
			mIdx += apps[i][0];
			for(int j = mIdx; j > 0; --j) {
				if(j-apps[i][0] <= 0) dp[j] = Math.min(dp[j], apps[i][1]);
				else dp[j] = Math.min(dp[j-apps[i][0]] + apps[i][1],dp[j]);
			}
		}
		
		System.out.println(dp[M]);
	}

}