import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	static int[] dx = { 0, 1, 1, -1 };
	static int[] dy = { 1, 0, 1, 1 };

	static int MAX = 19;
	static int[][] board = new int[MAX + 1][MAX + 1];
	static boolean[][] visited;

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int N = Integer.parseInt(br.readLine());

		int ans = -1;
		for (int i = 0; i < N; ++i) {
			st = new StringTokenizer(br.readLine());

			int turn = (i % 2 + 1);
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());

			board[x][y] = turn;
			if (check(turn, x, y)) {
				ans = i + 1;
				break;
			}

		}

		System.out.println(ans);
	}

	private static boolean check(int turn, int x, int y) {

		for (int d = 0; d < 4; ++d) {
			int cnt = 0;
			int nx = x;
			int ny = y;

			while (inRange(nx, ny) && board[nx][ny] == turn) {
				nx += dx[d];
				ny += dy[d];
				++cnt;
			}

			nx = x;
			ny = y;

			while (inRange(nx, ny) && board[nx][ny] == turn) {
				nx -= dx[d];
				ny -= dy[d];
				++cnt;
			}

			if (cnt == 6)
				return true;

		}

		return false;
	}

	private static boolean inRange(int nx, int ny) {
		if (nx < 1 || nx > MAX || ny < 1 || ny > MAX)
			return false;
		return true;
	}

}