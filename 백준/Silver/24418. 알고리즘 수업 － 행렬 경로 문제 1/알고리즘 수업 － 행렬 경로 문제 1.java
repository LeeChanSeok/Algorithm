import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	static int n;
	static int[] res;
	static int[][] m;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		n = Integer.parseInt(br.readLine());

		m = new int[n + 1][n + 1];
		for (int i = 1; i <= n; ++i) {
			st = new StringTokenizer(br.readLine());
			for (int j = 1; j <= n; ++j) {
				m[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		res = new int[] { 1, 0 };

		matrix_path1(m, n);
		matrix_path2(m, n);

		System.out.println(res[0] + " " + res[1]);
	}

	private static int matrix_path1(int[][] m, int n) {
		return matrix_path1_rec(m, n, n);

	}

	private static int matrix_path1_rec(int[][] m, int i, int j) {
		if (i == 0 || j == 0)
			return 0;

		++res[0];
		return (m[i][j] + Math.max(matrix_path1_rec(m, i - 1, j), matrix_path1_rec(m, i, j - 1)));
	}

	private static void matrix_path2(int[][] m, int n) {
		int[][] d = new int[n + 1][n + 1];
		for (int i = 1; i <= n; ++i) {
			for (int j = 1; j <= n; ++j) {
				++res[1];
				d[i][j] = m[i][j] + Math.max(d[i - 1][j], d[i][j - 1]);
			}
		}

	}
}