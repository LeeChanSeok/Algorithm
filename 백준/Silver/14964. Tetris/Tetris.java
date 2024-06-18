import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	static int[] dx = { -1, 1, 0, 0 };
	static int[] dy = { 0, 0, -1, 1 };

	static int N, M;
	static int[] ans;
	static char[][] board;
	static boolean[][] visited;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		board = new char[N][M];
		ans = new int[5];

		for (int i = 0; i < N; ++i) {
			board[i] = br.readLine().toCharArray();
		}

		solution();

		for (int i = 0; i < 5; ++i) {
			System.out.println(ans[i]);
		}

	}

	private static void solution() {

		visited = new boolean[N][M];

		for (int i = 0; i < N; ++i) {
			for (int j = 0; j < M; ++j) {

				if (board[i][j] != '.' && !visited[i][j]) {
					bfs(i, j, board[i][j]);
				}
			}
		}
	}

	private static void bfs(int x, int y, char c) {

		Queue<int[]> q = new LinkedList<>();
		ArrayList<int[]> res = new ArrayList<>();
		q.offer(new int[] { x, y });
		res.add(new int[] { x, y });

		visited[x][y] = true;

		int minX = x;
		int minY = y;
		int maxX = x;
		int maxY = y;

		while (!q.isEmpty()) {
			int[] cur = q.poll();

			int cx = cur[0];
			int cy = cur[1];

			for (int d = 0; d < 4; ++d) {
				int nx = cx + dx[d];
				int ny = cy + dy[d];

				if (nx < 0 || nx >= N || ny < 0 || ny >= M)
					continue;
				if (board[nx][ny] != c || visited[nx][ny])
					continue;

				visited[nx][ny] = true;
				q.offer(new int[] { nx, ny });
				res.add(new int[] { nx, ny });

				minX = Math.min(minX, nx);
				maxX = Math.max(maxX, nx);
				minY = Math.min(minY, ny);
				maxY = Math.max(maxY, ny);
			}

		}

		if (maxX - minX == 1 && maxY - minY == 1)
			++ans[0];
		else if (maxX - minX == 3 || maxY - minY == 3)
			++ans[1];
		else if (maxX - minX == 2) {

			int cnt = 0;
			for (int[] pos : res) {
				if ((pos[0] == minX && pos[1] == minY) || (pos[0] == maxX && pos[1] == maxY))
					++cnt;
			}
			if (cnt == 0)
				++ans[3];
			if (cnt == 1)
				++ans[4];
			if (cnt == 2)
				++ans[2];

		} else if (maxY - minY == 2) {
			int cnt = 0;
			for (int[] pos : res) {
				if ((pos[0] == minX && pos[1] == minY) || (pos[0] == maxX && pos[1] == maxY))
					++cnt;
			}
			if (cnt == 0)
				++ans[2];
			if (cnt == 1)
				++ans[4];
			if (cnt == 2)
				++ans[3];
		}

	}

}