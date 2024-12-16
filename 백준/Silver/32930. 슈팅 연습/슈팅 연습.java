import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	static class Point {
		int x, y;

		public Point(int x, int y) {
			super();
			this.x = x;
			this.y = y;
		}

	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());

		Point[] A = new Point[N + M];
		for (int i = 0; i < N + M; ++i) {
			st = new StringTokenizer(br.readLine());

			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());

			A[i] = new Point(x, y);
		}

		boolean[] visited = new boolean[N + M];

		int ans = 0;
		Point cur = new Point(0, 0);
		for (int i = 0; i < M; ++i) {
			int dist = 0;
			int max = 0;
			int idx = 0;
			for (int j = 0; j < i + N; ++j) {
				if (visited[j])
					continue;

				dist = calc_dist(cur, A[j]);
				if (dist > max) {
					idx = j;
					max = dist;
				}
			}

			ans += max;
			cur = A[idx];
			visited[idx] = true;

		}

		System.out.println(ans);
	}

	private static int calc_dist(Point cur, Point pnt) {
		// TODO Auto-generated method stub
		return (int) Math.pow(cur.x - pnt.x, 2) + (int) Math.pow(cur.y - pnt.y, 2);
	}

}