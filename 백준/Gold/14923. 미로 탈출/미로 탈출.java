import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	static class Info {
		int x, y;
		int chance;

		public Info(int x, int y, int chance) {
			super();
			this.x = x;
			this.y = y;
			this.chance = chance;
		}

	}

	static int[] dx = { -1, 1, 0, 0 };
	static int[] dy = { 0, 0, -1, 1 };

	static int n, m;
	static int hx, hy, ex, ey;
	static boolean[][] board;

	public static void main(String[] args) throws Exception {

		input();
		pro();
	}

	private static void pro() {

		int ans = bfs();
		System.out.println(ans);

	}

	private static int bfs() {
		int INF = 987654321;

		Queue<Info> q = new LinkedList<>();
		q.offer(new Info(hx, hy, 1));

		boolean[][][] visited = new boolean[n][m][2];

		visited[hx][hy][1] = true;

		int move = 0;
		while (!q.isEmpty()) {
			int qSize = q.size();

			while (qSize-- > 0) {
				Info cur = q.poll();
				if (cur.x == ex && cur.y == ey)
					return move;

				for (int d = 0; d < 4; ++d) {
					int nx = cur.x + dx[d];
					int ny = cur.y + dy[d];

					if (nx < 0 || nx >= n || ny < 0 || ny >= m)	continue;
					if (visited[nx][ny][cur.chance]) continue;

					if (!board[nx][ny]) {
						visited[nx][ny][cur.chance] = true;
						q.offer(new Info(nx, ny, cur.chance));
					}else if(cur.chance == 1) {
						visited[nx][ny][0] = true;
						q.offer(new Info(nx, ny, 0));
					}

				}
			}
			++move;
		}

		return -1;
	}

	private static void input() throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());

		st = new StringTokenizer(br.readLine());
		hx = Integer.parseInt(st.nextToken()) - 1;
		hy = Integer.parseInt(st.nextToken()) - 1;

		st = new StringTokenizer(br.readLine());
		ex = Integer.parseInt(st.nextToken()) - 1;
		ey = Integer.parseInt(st.nextToken()) - 1;

		board = new boolean[n][m];
		for (int i = 0; i < n; ++i) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < m; ++j) {
				if (st.nextToken().charAt(0) == '1')
					board[i][j] = true;
			}

		}
	}

}