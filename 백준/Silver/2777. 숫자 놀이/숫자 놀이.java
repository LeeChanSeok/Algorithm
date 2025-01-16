import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int T = Integer.parseInt(br.readLine());
		while (T-- > 0) {
			int ans;
			int N = Integer.parseInt(br.readLine());
			if (N == 1)
				ans = 1;
			else
				ans = recursive(N, 0);

			bw.write(ans + "\n");

		}

		bw.flush();

	}

	private static int recursive(int n, int len) {

		if (n == 1) {
			return len;
		}

		for (int i = 9; i >= 2; --i) {
			if (n % i == 0)
				return recursive(n / i, len + 1);
		}

		return -1;

	}

}