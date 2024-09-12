import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int n1 = Integer.parseInt(st.nextToken());
		int n2 = Integer.parseInt(st.nextToken());

		int total = 18 * 17 / 2;
		double ans;
		if (n1 == n2) {
			int lose = 10 - n1;
			ans = (1 - (double) lose / total);
		} else {
			int digit = (n1 + n2) % 10;
			int win = 0;

			for (int i = 1; i <= 9; ++i) {
				for (int j = i + 1; j <= 10; ++j) {
					if ((i + j) % 10 < digit) {
						if (n1 != i && n1 != j && n2 != i && n2 != j)
							win += 4;
						else
							win += 2;
					}
				}
			}
			ans = (double) win / total;

		}
		System.out.printf("%.3f", ans);

	}

}