import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	static class Pos {

		int x, y;

		public Pos(int x, int y) {
			super();
			this.x = x;
			this.y = y;
		}

	}

	static int[] dx = { -1, 1, 0, 0 };
	static int[] dy = { 0, 0, -1, 1 };

	static int N;
	static int[][] board;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		N = 5;
		board = new int[N][N];
		for (int i = 0; i < N; ++i) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; ++j) {
				board[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		st = new StringTokenizer(br.readLine());
		int r = Integer.parseInt(st.nextToken());
		int c = Integer.parseInt(st.nextToken());

		int res = bfs(r, c);

		System.out.println(res);

	}

	private static int bfs(int sr, int sc) {

		boolean[][] visited = new boolean[N][N];
		visited[sr][sc] = true;

		Queue<Pos> q = new LinkedList<>();
		q.offer(new Pos(sr, sc));
		
		int move = 0;
		while (!q.isEmpty()) {
			int qSize = q.size();

			while (qSize-- > 0) {
				Pos cur = q.poll();
				if(board[cur.x][cur.y] == 1) return move;
				for (int d = 0; d < 4; ++d) {
					int nx = cur.x + dx[d];
					int ny = cur.y + dy[d];

					if (nx < 0 || nx >= N || ny < 0 || ny >= N)
						continue;
					if (visited[nx][ny])
						continue;
					if(board[nx][ny] == -1) continue;

					visited[nx][ny] = true;
					q.offer(new Pos(nx, ny));

				}

			}

			++move;
		}

		return -1;
	}
}