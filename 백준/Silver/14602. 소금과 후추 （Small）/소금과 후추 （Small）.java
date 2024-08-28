import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

	static int[] dx = { 0, -1, -1, -1, 0, 1, 1, 1, 0 };
	static int[] dy = { 0, -1, 0, 1, 1, 1, 0, -1, -1 };

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int M = Integer.parseInt(st.nextToken());
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		int W = Integer.parseInt(st.nextToken());

		int[][] A = new int[M][N];

		int m = M - W + 1;
		int n = N - W + 1;

		int[][] B = new int[m][n];

		for (int i = 0; i < M; ++i) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; ++j) {
				A[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		for (int i = 0; i < m; ++i) {
			for (int j = 0; j < n; ++j) {
				int[] arr = new int[W * W];

				int idx = 0;
				for (int x = 0; x < W; ++x) {
					for (int y = 0; y < W; ++y) {
						arr[idx++] = A[i + x][j + y];
					}
				}
				Arrays.sort(arr);
				B[i][j] = arr[W * W / 2];

			}
		}

		for (int i = 0; i < m; ++i) {
			for (int j = 0; j < n; ++j) {
				System.out.print(B[i][j] + " ");
			}
			System.out.println();
		}

	}

}