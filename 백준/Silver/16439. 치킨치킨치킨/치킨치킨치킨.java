import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	static int[][] score;
	static int[] pick;
	static int n, m;
	static int ans;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());

		score = new int[n][m];
		for (int i = 0; i < n; ++i) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < m; ++j) {
				score[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		pick = new int[3];
		recursive(0, 0);
		System.out.println(ans);

	}

	private static void recursive(int idx, int cnt) {

		if (cnt == 3) {
			int total = 0;

			for (int i = 0; i < n; ++i) {
				int max = 0;
				for (int j = 0; j < 3; ++j) {
					max = Math.max(max, score[i][pick[j]]);
				}

				total += max;
			}

			ans = Math.max(ans, total);
			return;
		}

		for (int i = idx; i < m; ++i) {
			pick[cnt] = i;
			recursive(i + 1, cnt + 1);
		}

	}

}