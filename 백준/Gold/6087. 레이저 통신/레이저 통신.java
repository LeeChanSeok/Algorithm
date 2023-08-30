import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {

	static class Info {
		int pos, dir, turn;

		public Info(int pos, int dir, int turn) {
			super();
			this.pos = pos;
			this.dir = dir;
			this.turn = turn;
		}
	}

	static int INF = 987654321;
	static int[] dx = { -1, 0, 1, 0 };
	static int[] dy = { 0, 1, 0, -1 };

	static int w, h;
	static int DELTA = 100;
	static char[][] board;
	static int[] c_pos = new int[2];

	public static void main(String[] args) throws Exception {
		input();
		pro();
	}

	private static void pro() {
		System.out.println(bfs());
	}

	private static int bfs() {

		int sx = c_pos[0] / DELTA;
		int sy = c_pos[0] % DELTA;
		int ex = c_pos[1] / DELTA;
		int ey = c_pos[1] % DELTA;

		PriorityQueue<Info> pq = new PriorityQueue<>((p1, p2) -> p1.turn - p2.turn);
		for (int d = 0; d < 4; ++d) {
			pq.offer(new Info(sx * DELTA + sy, d, 0));
		}

		int[][][] visited = new int[h][w][4];
		for (int i = 0; i < h; ++i) {
			for (int j = 0; j < w; ++j) {
				Arrays.fill(visited[i][j], INF);

			}
		}

		while (!pq.isEmpty()) {
			Info cur = pq.poll();

			int x = cur.pos / DELTA;
			int y = cur.pos % DELTA;
			int dir = cur.dir;
			int turn = cur.turn;

			if (x == ex && y == ey)
				return turn;

			for (int d = -1; d <= 1; ++d) {
				int ndir = (dir + 4 + d) % 4;
				int nx = x + dx[ndir];
				int ny = y + dy[ndir];

				if (nx < 0 || nx >= h || ny < 0 || ny >= w)	continue;
				if (board[nx][ny] == '*') continue;

				int nturn = turn + Math.abs(d);
				if (visited[nx][ny][ndir] <= nturn)	continue;

				visited[nx][ny][dir] = nturn;
				pq.offer(new Info(nx * DELTA + ny, ndir, nturn));

			}

		}

		return -1;
	}

	private static void input() throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		w = Integer.parseInt(st.nextToken());
		h = Integer.parseInt(st.nextToken());

		board = new char[h][w];
		for (int i = 0; i < h; ++i) {
			board[i] = br.readLine().toCharArray();
		}

		int cnt = 0;
		for (int i = 0; i < h; ++i) {
			for (int j = 0; j < w; ++j) {
				if (board[i][j] == 'C')
					c_pos[cnt++] = i * DELTA + j;
			}
		}
	}

}