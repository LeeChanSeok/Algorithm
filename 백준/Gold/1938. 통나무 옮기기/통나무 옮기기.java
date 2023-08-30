import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class Main {

	static int[] dx = { -1, 1, 0, 0, -1, -1, 1, 1 };
	static int[] dy = { 0, 0, -1, 1, -1, 1, -1, 1 };

	static int n;
	static char[][] board;
	static int[] bPos, ePos;

	public static void main(String[] args) throws Exception {
		input();
		pro();

	}

	private static void pro() {

		System.out.println(bfs());

	}

	private static int bfs() {

		Queue<int[]> q = new LinkedList<>();
		q.offer(bPos);

		boolean[][][] visited = new boolean[n + 2][n + 2][2];
		visited[bPos[0]][bPos[1]][bPos[2]] = true;

		int move = 0;
		while (!q.isEmpty()) {

			int qSize = q.size();
			while (qSize-- > 0) {
				int[] cur = q.poll();
				int x = cur[0];
				int y = cur[1];
				int dir = cur[2];

				if (x == ePos[0] && y == ePos[1] && dir == ePos[2])
					return move;

				// U
				if (!visited[x - 1][y][dir] && moveU(x, y, dir)) {
					visited[x - 1][y][dir] = true;
					q.offer(new int[] { x - 1, y, dir });
				}
				// D
				if (!visited[x + 1][y][dir] && moveD(x, y, dir)) {
					visited[x + 1][y][dir] = true;
					q.offer(new int[] { x + 1, y, dir });
				}
				// L
				if (!visited[x][y - 1][dir] && moveL(x, y, dir)) {
					visited[x][y - 1][dir] = true;
					q.offer(new int[] { x, y - 1, dir });
				}
				// R
				if (!visited[x][y + 1][dir] && moveR(x, y, dir)) {
					visited[x][y + 1][dir] = true;
					q.offer(new int[] { x, y + 1, dir });
				}
				// turn
				if (!visited[x][y][dir ^ 1] && turn(x, y, dir)) {
					visited[x][y][dir ^ 1] = true;
					q.offer(new int[] { x, y, dir ^ 1 });
				}
			}
			++move;
		}

		return 0;
	}

	private static boolean moveU(int x, int y, int dir) {

		if (dir == 0) {
			int nx = x - 1;
			for (int i = -1; i <= 1; ++i) {
				int ny = y + i;
				if (board[nx][ny] == '1')
					return false;
			}
		} else {
			int nx = x - 2;
			int ny = y;
			if (board[nx][ny] == '1')
				return false;
		}

		return true;
	}

	private static boolean moveD(int x, int y, int dir) {

		if (dir == 0) {
			int nx = x + 1;
			for (int i = -1; i <= 1; ++i) {
				int ny = y + i;
				if (board[nx][ny] == '1')
					return false;
			}
		} else {
			int nx = x + 2;
			int ny = y;
			if (board[nx][ny] == '1')
				return false;
		}

		return true;
	}

	private static boolean moveL(int x, int y, int dir) {

		if (dir == 1) {
			int ny = y - 1;
			for (int i = -1; i <= 1; ++i) {
				int nx = x + i;
				if (board[nx][ny] == '1')
					return false;
			}
		} else {
			int nx = x;
			int ny = y - 2;
			if (board[nx][ny] == '1')
				return false;
		}

		return true;
	}

	private static boolean moveR(int x, int y, int dir) {

		if (dir == 1) {
			int ny = y + 1;
			for (int i = -1; i <= 1; ++i) {
				int nx = x + i;
				if (board[nx][ny] == '1')
					return false;
			}
		} else {
			int nx = x;
			int ny = y + 2;
			if (board[nx][ny] == '1')
				return false;
		}

		return true;
	}

	private static boolean turn(int x, int y, int dir) {

		for (int d = 0; d < 8; ++d) {
			int nx = x + dx[d];
			int ny = y + dy[d];
			if (board[nx][ny] == '1')
				return false;
		}

		return true;
	}

	private static void input() throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		n = Integer.parseInt(br.readLine());
		board = new char[n + 2][n + 2];

		Arrays.fill(board[0], '1');
		Arrays.fill(board[n + 1], '1');
		for (int i = 1; i <= n; ++i) {
			String str = br.readLine();
			board[i][0] = board[i][n + 1] = '1';
			for (int j = 1; j <= n; ++j) {
				board[i][j] = str.charAt(j - 1);
			}
		}

		bPos = findPos('B');
		ePos = findPos('E');

	}

	private static int[] findPos(char c) {

		for (int i = 1; i <= n; ++i) {
			for (int j = 1; j <= n; ++j) {
				if (board[i][j] == c) {
					board[i][j] = '0';
					if (board[i][j + 1] == c) return new int[] { i, j + 1, 0 };
					else return new int[] { i + 1, j, 1 };
				}
			}
		}

		return null;
	}

}