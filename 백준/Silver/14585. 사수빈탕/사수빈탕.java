import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	static final int MAX = 300;

	static int N, M;
	static boolean[][] candy;
	static long[][] D;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		candy = new boolean[MAX + 1][MAX + 1];
		D = new long[MAX + 1][MAX + 1];

		for (int i = 0; i < N; ++i) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());

			candy[x][y] = true;
		}

		for (int i = 0; i <= MAX; ++i) {
			for (int j = 0; j <= MAX; ++j) {
				D[i][j] = Math.max((i > 0) ? D[i - 1][j] : 0, (j > 0) ? D[i][j - 1] : 0);
				if (candy[i][j]) {
					D[i][j] += Math.max(0, M - (i + j));
				}
			}
		}
		System.out.println(D[MAX][MAX]);
	}

}