import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
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

	static int ans;
	static int[] tmp;
	static int N, K;
	static Point[] p;

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());

		p = new Point[N];
		for (int i = 0; i < N; ++i) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			p[i] = new Point(x, y);
		}

		ans = Integer.MAX_VALUE;
		tmp = new int[3];
		for (int i = 0; i < N; ++i) {
			recursive(i, 0);
		}

		System.out.println(ans);
	}

	private static void recursive(int idx, int cnt) {
		tmp[cnt] = idx;

		if (cnt + 1 == K) {
			ans = Math.min(ans, solution());
			return;
		}

		for (int i = idx + 1; i < N; ++i) {
			recursive(i, cnt + 1);
		}
	}

	private static int solution() {

		int max = 0;
		for (int i = 0; i < N; ++i) {
			int min = Integer.MAX_VALUE;
			for (int j = 0; j < K; ++j) {
				min = Math.min(min, calc_dist(i, tmp[j]));
			}
			max = Math.max(max, min);
		}

		return max;
	}

	private static int calc_dist(int u, int v) {

		return Math.abs(p[u].x - p[v].x) + Math.abs(p[u].y - p[v].y);
	}

}