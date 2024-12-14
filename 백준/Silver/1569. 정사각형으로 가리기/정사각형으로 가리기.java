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

	static Point[] arr;
	static int minX, maxX, minY, maxY;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int N = Integer.parseInt(br.readLine());
		arr = new Point[N];

		for (int i = 0; i < N; ++i) {
			st = new StringTokenizer(br.readLine());

			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());

			arr[i] = new Point(x, y);
		}

		minX = minY = 1000;
		maxX = maxY = -1000;

		for (Point pnt : arr) {
			minX = Math.min(minX, pnt.x);
			maxX = Math.max(maxX, pnt.x);
			minY = Math.min(minY, pnt.y);
			maxY = Math.max(maxY, pnt.y);
		}

		int ans = -1;
		if (isOnline())
			ans = Math.max(maxX - minX, maxY - minY);

		System.out.println(ans);

	}

	private static boolean isOnline() {

		int[] cnt = new int[4];
		for (Point pnt : arr) {


			if (pnt.x == maxX && pnt.y == maxY) {
				continue;
			} else if (pnt.x == maxX && pnt.y == minY) {
				continue;
			} else if (pnt.x == minX && pnt.y == maxY) {
				continue;
			} else if (pnt.x == minX && pnt.y == minY) {
				continue;
			}

			if (pnt.y == maxY && minX <= pnt.x && pnt.x <= maxX) {
				++cnt[0];
				continue;
			} else if (pnt.y == minY && minX <= pnt.x && pnt.x <= maxX) {
				++cnt[1];
				continue;
			} else if (pnt.x == maxX && minY <= pnt.y && pnt.y <= maxY) {
				++cnt[2];
				continue;
			} else if (pnt.x == minX && minY <= pnt.y && pnt.y <= maxY) {
				++cnt[3];
				continue;
			}

			return false;
		}

		int lenX = maxX - minX;
		int lenY = maxY - minY;

		if (lenX == lenY)
			return true;
		if (lenX > lenY) {
			if (cnt[0] == 0 || cnt[1] == 0)
				return true;
			else
				return false;
		} else if (lenX < lenY) {
			if (cnt[2] == 0 || cnt[3] == 0)
				return true;
			else
				return false;
		}

		return false;
	}

}