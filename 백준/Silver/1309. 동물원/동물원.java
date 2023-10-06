import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int n = Integer.parseInt(br.readLine());
		int mod = 9901;

		int[] D = new int[n + 1];
		D[0] = 1; D[1] = 3;

		for (int i = 2; i <= n; ++i) {
			D[i] = (D[i - 1] * 2 + D[i - 2]) % mod;
		}

		System.out.println(D[n]);

	}

}