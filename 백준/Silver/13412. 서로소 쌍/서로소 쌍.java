import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int T = Integer.parseInt(br.readLine());
		while (T-- > 0) {
			int N = Integer.parseInt(br.readLine());

			int cnt = solution(N);
			System.out.println(cnt);
		}

	}

	private static int solution(int n) {

		int res = 0;
		for (int i = 1; i <= Math.sqrt(n); ++i) {
			if (n % i != 0)
				continue;
			int a = i;
			int b = n / a;
			int gcd = GCD(a, b);
			if (gcd == 1)
				++res;
		}
		return res;
	}

	private static int GCD(int a, int b) {

		while (b != 0) {
			int tmp = a;
			a = b;
			b = tmp % b;

		}

		return a;
	}

}