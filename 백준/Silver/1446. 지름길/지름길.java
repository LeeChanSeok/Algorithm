import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

	static class Road implements Comparable<Road> {
		int x, y, d;

		public Road(int x, int y, int d) {
			super();
			this.x = x;
			this.y = y;
			this.d = d;
		}

		@Override
		public int compareTo(Road o) {
			if (this.y == o.y)
				return this.d - o.d;
			return this.y - o.y;
		}

	}

	static int ans;
	static int N, D, size;
	static List<Road> roads;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		D = Integer.parseInt(st.nextToken());

		roads = new ArrayList<>();
		for (int i = 0; i < N; ++i) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			int d = Integer.parseInt(st.nextToken());

			if (y - x <= d)
				continue;
			if (y > D)
				continue;
			roads.add(new Road(x, y, d));
		}

		Collections.sort(roads);
		size = roads.size();
		ans = D;
		for (int i = 0; i < size; ++i) {
			Road road = roads.get(i);
			recursive(i + 1, road.y, road.x + road.d);
		}

		System.out.println(ans);

	}

	private static void recursive(int idx, int pos, int total) {

		ans = Math.min(ans, total + (D - pos));
		if (idx >= size)
			return;

		for (int i = idx; i < size; ++i) {
			Road road = roads.get(i);
			if (road.x < pos)
				continue;
			recursive(i + 1, road.y, total + (road.x - pos) + road.d);
		}
	}

}