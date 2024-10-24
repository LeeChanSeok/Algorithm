import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {

	static int N;
	static int[] subsum;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String str = br.readLine();
		N = str.length();

		subsum = new int[N + 1];
		for (int i = 0; i < N; ++i) {
			subsum[i + 1] = subsum[i] + (str.charAt(i) - '0');
		}

		int ans = solution();
		System.out.println(ans);

	}

	private static int solution() {

		for (int i = N - (N & 1); i > 0; i -= 2) {
			for (int j = i; j <= N; j++) {

				int right = subsum[j] - subsum[j - (i / 2)];
				int left = subsum[j - (i / 2)] - subsum[j - i];

				if (right == left)
					return i;

			}
		}

		return 0;
	}

}