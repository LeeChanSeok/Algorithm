import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	static int[] dx = { -1, 1, 0, 0 };
	static int[] dy = { 0, 0, -1, 1 };

	static int N, M;
	static char[][] board;
	static int x1, y1, x2, y2;

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		st = new StringTokenizer(br.readLine());
		x1 = Integer.parseInt(st.nextToken()) - 1;
		y1 = Integer.parseInt(st.nextToken()) - 1;
		x2 = Integer.parseInt(st.nextToken()) - 1;
		y2 = Integer.parseInt(st.nextToken()) - 1;

		board = new char[N][M];
		for (int i = 0; i < N; ++i) {
			board[i] = br.readLine().toCharArray();
		}
		board[x1][y1] = '0';
		board[x2][y2] = '1';

		int ans = simulation();
		System.out.println(ans);
	}

	private static int simulation() {

		Queue<int[]> q = new LinkedList<>();
		q.offer(new int[] { x1, y1 });

		boolean[][] visited = new boolean[N][M];
		visited[x1][y1] = true;

		Queue<int[]> person;

		int move = 0;
		while (true) {
			person = new LinkedList<>();
			while (!q.isEmpty()) {
				int[] cur = q.poll();
				int x = cur[0];
				int y = cur[1];

				for (int d = 0; d < 4; ++d) {
					int nx = x + dx[d];
					int ny = y + dy[d];

					if (nx < 0 || nx >= N || ny < 0 || ny >= M)
						continue;
					if (visited[nx][ny])
						continue;

					if (board[nx][ny] == '0')
						q.offer(new int[] { nx, ny });
					else if (board[nx][ny] == '1')
						person.offer(new int[] { nx, ny });
					visited[nx][ny] = true;
				}
			}

			++move;
			for (int[] p : person) {
				int x = p[0];
				int y = p[1];

				if (x == x2 && y == y2)
					return move;

				q.offer(new int[] { x, y });
				board[x][y] = '0';

			}

		}

	}

}