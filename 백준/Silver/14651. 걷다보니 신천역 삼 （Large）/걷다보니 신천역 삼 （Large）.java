import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int MOD = (int) (1e9) + 9;

		int n = Integer.parseInt(br.readLine());

		long ans = 0;
		if (n != 1) {
			ans = 2;

			for (int i = 3; i <= n; ++i) {
				ans = (ans * 3) % MOD;
			}

		}

		System.out.println(ans);

	}

}