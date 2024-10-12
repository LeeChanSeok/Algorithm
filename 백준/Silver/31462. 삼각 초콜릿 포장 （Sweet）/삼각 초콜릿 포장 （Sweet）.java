import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {

	static int[][] dx = { { 1, 1 }, { 0, 1 } };
	static int[][] dy = { { 0, 1 }, { 1, 1 } };

	static int N;
	static char[][] arr;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		N = Integer.parseInt(br.readLine());

		arr = new char[N][N];
		for (int i = 0; i < N; ++i) {
			arr[i] = br.readLine().toCharArray();
		}

		if (solution())
			System.out.println(1);
		else
			System.out.println(0);
	}

	private static boolean solution() {

		boolean[][] check = new boolean[N][N];

		for (int i = 0; i < N; ++i) {
			for (int j = 0; j <= i; ++j) {
				if (check[i][j])
					continue;

				char c = (arr[i][j]);
				check[i][j] = true;

				int d = (c == 'R') ? 0 : 1;

				for (int k = 0; k < 2; ++k) {
					int nx = i + dx[d][k];
					int ny = j + dy[d][k];
					if (nx >= N || ny > (i + dx[d][k]))
						return false;
					if (arr[nx][ny] != c)
						return false;
					if (check[nx][ny])
						return false;

					check[nx][ny] = true;
				}

			}
		}

		return true;
	}

}