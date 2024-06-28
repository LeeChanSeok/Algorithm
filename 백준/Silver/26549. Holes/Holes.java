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

	static int R, C;
	static char[][] board;
	static boolean[][] visited;
	static int section, space;

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;

		int T = Integer.parseInt(br.readLine());
		while (T-- > 0) {
			st = new StringTokenizer(br.readLine());
			R = Integer.parseInt(st.nextToken());
			C = Integer.parseInt(st.nextToken());

			board = new char[R][C];
			visited = new boolean[R][C];

			for (int i = 0; i < R; ++i) {
				board[i] = br.readLine().toCharArray();
			}

			section = space = 0;

			for (int i = 0; i < R; ++i) {
				for (int j = 0; j < C; ++j) {
					if (board[i][j] == '.' && !visited[i][j]) {
						++section;
						bfs(i, j);
					}
				}
			}

			sb.append(print(section, space)).append('\n');
		}

		System.out.println(sb);

	}

	private static Object print(int section, int space) {

		String str1 = section + " section";
		if (section != 1)
			str1 += "s";

		String str2 = ", " + space + " space";
		if (space != 1)
			str2 += "s";

		return str1 + str2;
	}

	private static void bfs(int sr, int sc) {

		Queue<Pos> q = new LinkedList<>();
		q.offer(new Pos(sr, sc));

		visited[sr][sc] = true;

		while (!q.isEmpty()) {
			Pos cur = q.poll();
			++space;

			for (int d = 0; d < 4; ++d) {
				int nx = cur.x + dx[d];
				int ny = cur.y + dy[d];

				if (nx < 0 || nx >= R || ny < 0 || ny >= C)
					continue;
				if (board[nx][ny] == '#')
					continue;
				if (visited[nx][ny])
					continue;

				q.offer(new Pos(nx, ny));
				visited[nx][ny] = true;

			}
		}

	}

}