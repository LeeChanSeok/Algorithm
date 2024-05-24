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

		res = new int[] { matrix_path_rec(m), n * n };

		System.out.println(res[0] + " " + res[1]);
	}

	private static int matrix_path_rec(int[][] m) {
		int mod = 1000000007;

		int[][] d = new int[n + 1][n + 1];
		d[1][1] = 1;

		int total = 0;
		for (int i = 1; i <= n; ++i) {

			for (int j = 1; j <= n; ++j) {
				d[i][j] = (d[i][j] + d[i - 1][j] + d[i][j - 1]) % mod;
				total = (total + d[i][j]) % mod;
			}
		}

		return (total + 1) % mod;
	}

}