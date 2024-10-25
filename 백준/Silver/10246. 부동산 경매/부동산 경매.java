import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		int MAX = 1000000;
		long[] cnt = new long[MAX + 1];
		Arrays.fill(cnt, 1);
		cnt[0] = cnt[1] = 0;

		for (int i = 2; i <= 500000; ++i) {
			for (int j = i - 1; j > 0; --j) {
				long money = calc(j, i);
				if (money > MAX)
					break;
				++cnt[(int) money];
			}
		}

		int N;
		while ((N = Integer.parseInt(br.readLine())) != 0) {

			sb.append(cnt[N]).append('\n');
		}

		System.out.println(sb);

	}

	private static long calc(int l, int r) {

		long a = (long) (r + 1) * (r + 2) / 2;
		long b = (long) (l + 1) * (l + 2) / 2;

		return a - b + l + 1;
	}

}