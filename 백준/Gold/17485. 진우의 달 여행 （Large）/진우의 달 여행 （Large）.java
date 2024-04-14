import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());

		int INF = (int) 1e9;
		int[][][] D = new int[2][m + 2][3];
		for (int i = 0; i < 2; ++i) {
			for (int k = 0; k < 3; ++k) {
				D[i][0][k] = D[i][m + 1][k] = INF;
			}
		}

		for (int i = 0; i < n; ++i) {
			st = new StringTokenizer(br.readLine());

			int[] arr = new int[m + 2];
			arr[0] = arr[m + 1] = INF;
			for (int j = 1; j <= m; ++j) {
				arr[j] = Integer.parseInt(st.nextToken());
			}

			int prev = (i + 1) % 2;
			int turn = i % 2;
			for (int j = 1; j <= m; ++j) {

				D[turn][j][0] = Math.min(D[prev][j + 1][1], D[prev][j + 1][2]) + arr[j];
				D[turn][j][1] = Math.min(D[prev][j][0], D[prev][j][2]) + arr[j];
				D[turn][j][2] = Math.min(D[prev][j - 1][0], D[prev][j - 1][1]) + arr[j];

			}
		}

		int turn = (n + 1) % 2;
		int ans = Integer.MAX_VALUE;
		for (int j = 1; j <= m; ++j) {
			for (int k = 0; k < 3; ++k) {
				ans = Math.min(ans, D[turn][j][k]);
			}
		}

		System.out.println(ans);
	}

}