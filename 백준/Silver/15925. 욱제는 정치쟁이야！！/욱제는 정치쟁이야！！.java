import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	static int N, M;
	static int[][] arr;
	static int[] row, col;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		row = new int[N];
		col = new int[N];

		arr = new int[N][N];

		for (int i = 0; i < N; ++i) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; ++j) {
				arr[i][j] = Integer.parseInt(st.nextToken());
				if (arr[i][j] == M) {
					++row[i];
					++col[j];
				}
			}
		}

		boolean isChange = true;
		while (isChange) {
			isChange = false;

			for (int i = 0; i < N; ++i) {
				if (row[i] != N && row[i] > N / 2) {
					isChange = true;
					row_change(i);
				}
			}

			for (int j = 0; j < N; ++j) {
				if (col[j] != N && col[j] > N / 2) {
					isChange = true;
					col_change(j);
				}
			}
		}

		if (all_change())
			System.out.println(1);
		else
			System.out.println(0);

	}

	private static boolean all_change() {

		for (int i = 0; i < N; ++i) {
			for (int j = 0; j < N; ++j) {
				if (arr[i][j] != M)
					return false;
			}
		}
		return true;
	}

	private static void row_change(int r) {
		row[r] = N;
		for (int j = 0; j < N; ++j) {
			if (arr[r][j] != M) {
				arr[r][j] = M;
				++col[j];
			}
		}
	}

	private static void col_change(int c) {
		col[c] = N;
		for (int i = 0; i < N; ++i) {
			if (arr[i][c] != M) {
				arr[i][c] = M;
				++row[i];
			}
		}
	}

}