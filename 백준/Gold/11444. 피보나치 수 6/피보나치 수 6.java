import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	static int MOD = 1000000007;
	static long[][] origin = { { 1, 1 }, { 1, 0 } };

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		long n = Long.parseLong(br.readLine());
		long[][] A = { { 1, 1 }, { 1, 0 } };
		System.out.println(pow(A, n - 1)[0][0]);

	}

	private static long[][] pow(long[][] a, long n) {

		if (n == 1 || n == 0)
			return a;

		long[][] ret = pow(a, n / 2);
		ret = multiply(ret, ret);
		if ((n & 1) != 0l) {
			ret = multiply(ret, origin);
		}

		return ret;
	}

	private static long[][] multiply(long[][] o1, long[][] o2) {

		long[][] ret = new long[2][2];

		ret[0][0] = ((o1[0][0] * o2[0][0]) + (o1[0][1] * o2[1][0])) % MOD;
		ret[0][1] = ((o1[0][0] * o2[0][1]) + (o1[0][1] * o2[1][1])) % MOD;
		ret[1][0] = ((o1[1][0] * o2[0][0]) + (o1[1][1] * o2[1][0])) % MOD;
		ret[1][1] = ((o1[1][0] * o2[0][1]) + (o1[1][1] * o2[1][1])) % MOD;

		return ret;
	}

}
