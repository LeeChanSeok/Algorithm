import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {

	static int MOD = 1000000007;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		int T = Integer.parseInt(br.readLine());
		while (T-- > 0) {
			int N = Integer.parseInt(br.readLine());

			if (N <= 2)
				sb.append("1\n");
			else {
				long res = recursive(N - 2);
				sb.append(res).append("\n");
			}
		}

		System.out.println(sb);
	}

	private static long recursive(int a) {

		if (a == 0)
			return 1;
		if (a == 1)
			return 2;

		long mul;

		mul = recursive(a / 2);
		mul = (mul * mul) % MOD;
		if (a % 2 != 0) {
			mul = (mul * 2) % MOD;
		}

		return mul;
	}

}