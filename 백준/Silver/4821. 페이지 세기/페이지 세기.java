import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int N;
		int low, high;
		while ((N = Integer.parseInt(br.readLine())) != 0) {

			int[] arr = new int[N + 2];
			String[] pages = br.readLine().split(",");
			for (String page : pages) {
				String[] p = page.split("-");
				low = Integer.parseInt(p[0]);
				if (p.length == 1)
					high = low;
				else
					high = Integer.parseInt(p[1]);

				if (low > high)
					continue;
				if (low > N || high < 1)
					continue;

				low = Math.max(low, 1);
				high = Math.min(high, N);

				++arr[low];
				--arr[high + 1];

			}

			for (int i = 1; i <= N; ++i) {
				arr[i] += arr[i - 1];
			}

			int cnt = 0;
			for (int i = 1; i <= N; ++i) {
				if (arr[i] > 0)
					++cnt;
			}

			System.out.println(cnt);
		}

	}

}