import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	static int DELTA = 1000;

	static int[] dx = { -1, 1, 0, 0 };
	static int[] dy = { 0, 0, -1, 1 };

	static int N, M;
	static int[][] arr, visited;
	static Queue<Integer> q1, q2;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		q1 = new LinkedList<Integer>();
		q2 = new LinkedList<Integer>();

		arr = new int[N][M];
		visited = new int[N][M];

		for (int i = 0; i < N; ++i) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; ++j) {
				int num = Integer.parseInt(st.nextToken());
				arr[i][j] = num;

				if (num == 1)
					q1.offer(i * DELTA + j);
				else if (num == 2)
					q2.offer(i * DELTA + j);
			}
		}

		bfs();
		int[] ans = new int[5];
		for (int i = 0; i < N; ++i) {
			for (int j = 0; j < M; ++j) {
				++ans[arr[i][j] + 1];
			}
		}

		System.out.println(ans[2] + " " + ans[3] + " " + ans[4]);
	}

	private static void bfs() {

		int t = 1;
		int qSize;
		while (!q1.isEmpty() || !q2.isEmpty()) {
			qSize = q1.size();
			while (qSize-- > 0) {
				int x = q1.peek() / DELTA;
				int y = q1.peek() % DELTA;
				q1.poll();
				if (arr[x][y] == 3)
					continue;

				for (int d = 0; d < 4; ++d) {
					int nx = x + dx[d];
					int ny = y + dy[d];

					if (!inRange(nx, ny))
						continue;
					if (arr[nx][ny] != 0)
						continue;

					arr[nx][ny] = 1;
					visited[nx][ny] = t;
					q1.offer(nx * DELTA + ny);
				}
			}

			qSize = q2.size();
			while (qSize-- > 0) {
				int x = q2.peek() / DELTA;
				int y = q2.peek() % DELTA;
				q2.poll();

				for (int d = 0; d < 4; ++d) {
					int nx = x + dx[d];
					int ny = y + dy[d];

					if (!inRange(nx, ny))
						continue;
					if (visited[nx][ny] == t) {
						arr[nx][ny] = 3;
						continue;
					}
					if (arr[nx][ny] != 0)
						continue;

					arr[nx][ny] = 2;
					q2.offer(nx * DELTA + ny);
				}
			}
			++t;
		}

	}

	private static boolean inRange(int x, int y) {

		if (x < 0 || x >= N || y < 0 || y >= M)
			return false;
		return true;
	}

}