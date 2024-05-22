import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
	
	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		
		int[] dp = new int[2];
		dp[0] = dp[1] = 1;
		
		int mod = 1000000007;
		for(int i = 2; i < n; ++i) {
			int temp = dp[1];
			dp[1] = (dp[0] + dp[1]) % mod;
			dp[0] = temp;
		}
		
		int ans1 = dp[1];
		int ans2 = (n - 2) % mod;
		System.out.println(ans1 + " " + ans2);
	}

}