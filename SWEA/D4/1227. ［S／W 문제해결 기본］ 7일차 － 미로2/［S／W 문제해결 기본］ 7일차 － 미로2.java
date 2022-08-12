import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

class Point {
	int x, y;

	public Point(int x, int y) {
		super();
		this.x = x;
		this.y = y;
	}

	public Point(Point p) {
		super();
		this.x = p.x;
		this.y = p.y;
	}
}

public class Solution {

	public static int bfs(char[][] map, int x, int y) {
		int[] dx = { -1, 0, 1, 0 };
		int[] dy = { 0, 1, 0, -1 };

		Queue<Point> q = new LinkedList<>();
		q.add(new Point(x, y));
		map[x][y] = '1';
		int nx, ny;
		int cnt = 0;
		while (!q.isEmpty()) {
			int size = q.size();
			Point cur = q.poll();

			for (int d = 0; d < 4; d++) {
				nx = cur.x + dx[d];
				ny = cur.y + dy[d];
				if (map[nx][ny] == '1')
					continue;
				if (map[nx][ny] == '3')
					return 1;

				map[nx][ny] = '1';
				q.add(new Point(nx, ny));
			}
		}

		return 0;
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = 10;
		int N = 100;
		int ans;
		char[][] map;
		for (int tc = 1; tc <= T; tc++) {
			br.readLine();
			map = new char[N][N];

			for (int i = 0; i < N; i++) {
				map[i] = br.readLine().toCharArray();
			}

			ans = bfs(map, 1, 1);
			System.out.printf("#%d %d\n", tc, ans);

		}
	}

}
