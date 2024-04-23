import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int MOD = 1000000;
		char[] arr = br.readLine().toCharArray();

		if (arr[0] == '0') {
			System.out.println(0);
			return;
		}

		int len = arr.length;
		int[] dp = new int[len + 1];
		dp[0] = dp[1] = 1;

		for (int i = 2; i <= len; ++i) {
			if (arr[i - 1] != '0') {
				dp[i] += dp[i - 1] % MOD;
			}

			int temp = ((arr[i - 2] - '0') * 10) + (arr[i - 1] - '0');
			if (temp >= 10 && temp <= 26)
				dp[i] += dp[i - 2] % 1000000;
		}

		System.out.println(dp[len] % MOD);

	}

}