import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	static int[] dx = { -1, 1, 0, 0 };
	static int[] dy = { 0, 0, -1, 1 };

	static int OFFSET = 500;
	static int MAX = 1000;
	static boolean[][] board, visited;
	static int X, Y;

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		X = Integer.parseInt(st.nextToken()) + OFFSET;
		Y = Integer.parseInt(st.nextToken()) + OFFSET;
		int N = Integer.parseInt(st.nextToken());

		board = new boolean[MAX + 1][MAX + 1];
		visited = new boolean[MAX + 1][MAX + 1];

		for (int i = 0; i < N; ++i) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken()) + OFFSET;
			int y = Integer.parseInt(st.nextToken()) + OFFSET;

			board[x][y] = true;

		}

		int ans = bfs();
		System.out.println(ans);
	}

	private static int bfs() {

		int x = OFFSET;
		int y = OFFSET;

		Queue<Integer> q = new LinkedList<>();
		q.offer(x * MAX + y);

		visited[x][y] = true;

		int move = 0;
		while (!q.isEmpty()) {
			int qSize = q.size();

			while (qSize-- > 0) {
				int pos = q.poll();
				x = pos / MAX;
				y = pos % MAX;

				if (x == X && y == Y) {
					return move;
				}

				for (int d = 0; d < 4; ++d) {
					int nx = x + dx[d];
					int ny = y + dy[d];

					if (nx < 0 || nx > MAX || ny < 0 || ny > MAX)
						continue;
					if (board[nx][ny] || visited[nx][ny])
						continue;

					q.offer(nx * MAX + ny);
					visited[nx][ny] = true;

				}

			}

			++move;
		}

		return -1;
	}

}