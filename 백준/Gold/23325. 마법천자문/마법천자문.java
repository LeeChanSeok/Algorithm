import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Main {

	static String str;
	static int N;
	static int[] dp;
	static Map<Character, Integer> map;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		str = br.readLine();
		N = str.length();

		map = new HashMap<>();
		map.put('+', 10);
		map.put('-', 1);

		dp = new int[N];
		Arrays.fill(dp, -(int)1e9);

		dp[0] = (str.charAt(0) == '+') ? 10 : 1;
		if (N > 1) {
			if (str.charAt(0) == '+' && str.charAt(1) == '-') {
				dp[1] = 11;
			}
		}

		if (N > 2) {
			int num1 = map.get(str.charAt(0));
			int num2 = map.get(str.charAt(2));
			if (str.charAt(1) == '+')
				dp[2] = num1 + num2;
			else
				dp[2] = num1 - num2;
		}

		for (int i = 3; i < N; ++i) {
			dp[i] = calc(dp[i - 2], str.charAt(i - 1), map.get(str.charAt(i)));
			if (str.charAt(i - 1) == '+' && str.charAt(i) == '-')
				dp[i] = Math.max(dp[i], calc(dp[i - 3], str.charAt(i - 2), 11));

		}

		System.out.println(dp[N - 1]);
	}

	private static int calc(int n1, char c, int n2) {
		if (c == '+')
			return n1 + n2;
		return n1 - n2;
	}

}