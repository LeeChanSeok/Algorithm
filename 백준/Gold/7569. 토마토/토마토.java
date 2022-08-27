import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int N, M, H;
	static int min, tomato, totalTomato;
	static int[][][] map;
	static final int[] dx = { 0, 1, 0, -1 };
	static final int[] dy = { 1, 0, -1, 0 };
	static final int[] dh = { 1, -1 };
	static Queue<Point> q;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		M = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());
		H = Integer.parseInt(st.nextToken());

		map = new int[H][N][M];

		for (int k = 0; k < H; k++) {
			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < M; j++)
					map[k][i][j] = Integer.parseInt(st.nextToken());
			}
		}

		totalTomato = H * N * M;
		q = new ArrayDeque<>();

		for (int k = 0; k < H; k++) {
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < M; j++) {

					if (map[k][i][j] == -1)
						totalTomato--;
					else if (map[k][i][j] == 1) {
						q.offer(new Point(i, j, k));
						tomato++;
					}
				}
			}
		}

		min = solution();
		System.out.println(min);

	}

	private static int solution() {

		int time = 0;

		while (!q.isEmpty()) {
			if (tomato == totalTomato)
				return time;

			int qSize = q.size();

			while (qSize-- > 0) {
				Point cur = q.poll();
				int nx, ny, nh;
				// 상하좌우
				for (int d = 0; d < 4; d++) {
					nx = cur.x + dx[d];
					ny = cur.y + dy[d];
					nh = cur.h;

					if (nx < 0 || nx >= N || ny < 0 || ny >= M || map[nh][nx][ny] != 0)
						continue;

					map[nh][nx][ny] = 1;
					tomato++;
					q.offer(new Point(nx, ny, nh));
				}

				for (int d = 0; d < 2; d++) {
					nx = cur.x;
					ny = cur.y;
					nh = cur.h + dh[d];
					
					if (nh < 0 || nh >= H || map[nh][nx][ny] != 0)
						continue;
					
					map[nh][nx][ny] = 1;
					tomato++;
					q.offer(new Point(nx, ny, nh));

				}

			}
			time++;
		}

		return -1;
	}

	static class Point {
		int x, y, h;

		public Point(int x, int y, int h) {
			super();
			this.x = x;
			this.y = y;
			this.h = h;
		}

	}

}