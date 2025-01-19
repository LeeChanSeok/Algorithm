import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	static int[] dx = { -1, 1, 0, 0 };
	static int[] dy = { 0, 0, -1, 1 };

	static final int N = 5;
	static int ans;
	static int[][] map;
	static boolean[][] visited;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		map = new int[N][N];
		for (int i = 0; i < N; ++i) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; ++j) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		st = new StringTokenizer(br.readLine());
		int r = Integer.parseInt(st.nextToken());
		int c = Integer.parseInt(st.nextToken());
		ans = Integer.MAX_VALUE;

		visited = new boolean[N][N];
		visited[r][c] = true;
		DFS(r, c, 0, (map[r][c] == 1 ? 1 : 0));
		if (ans == Integer.MAX_VALUE)
			ans = -1;
		System.out.println(ans);
	}

	private static void DFS(int r, int c, int move, int eat) {
		if (move >= ans)
			return;

		if (eat == 3) {
			ans = move;
			return;
		}

		for (int d = 0; d < 4; ++d) {
			int x = r + dx[d];
			int y = c + dy[d];

			if (x < 0 || x >= N || y < 0 || y >= N)
				continue;
			if (map[x][y] == -1)
				continue;
			if (visited[x][y])
				continue;

			visited[r][c] = true;
			DFS(x, y, move + 1, (map[x][y] == 1 ? 1 : 0) + eat);
			visited[r][c] = false;

		}

	}

}