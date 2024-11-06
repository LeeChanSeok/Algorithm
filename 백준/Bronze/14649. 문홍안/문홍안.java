import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int P = Integer.parseInt(br.readLine());
		int N = Integer.parseInt(br.readLine());
		int[] cnt = new int[101];
		for (int i = 0; i < N; ++i) {
			st = new StringTokenizer(br.readLine());
			int pos = Integer.parseInt(st.nextToken());
			char c = st.nextToken().charAt(0);

			if (c == 'R') {
				for (pos = pos + 1; pos <= 100; ++pos)
					++cnt[pos];
			} else {
				for (pos = pos - 1; pos > 0; --pos)
					++cnt[pos];
			}

		}

		int[] abc = new int[3];
		for (int i = 1; i <= 100; ++i) {
			++abc[cnt[i] % 3];
		}

		System.out.printf("%.2f\n", P * abc[0] / 100.);
		System.out.printf("%.2f\n", P * abc[1] / 100.);
		System.out.printf("%.2f\n", P * abc[2] / 100.);

	}

}