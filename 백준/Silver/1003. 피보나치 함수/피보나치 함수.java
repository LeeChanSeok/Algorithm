import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		
		int maxN = 40;
		int[][] dp = new int[maxN+1][2];
		initDP(dp, maxN);
		
		int T = Integer.parseInt(br.readLine());
		for(int tc = 1; tc<= T; tc++) {
			int N = Integer.parseInt(br.readLine());
			sb.append(dp[N][0] + " " + dp[N][1] + "\n");
		}
		bw.write(sb.toString());
		bw.close();
	}

	private static void initDP(int[][] dp, int maxN) {
		dp[0][0] = 1; dp[0][1] = 0;
		dp[1][0] = 0; dp[1][1] = 1;
		for(int i = 2; i <= maxN; i++) {
			dp[i][0] = dp[i-1][0] + dp[i-2][0];
			dp[i][1] = dp[i-1][1] + dp[i-2][1];
		}
		
	}

}