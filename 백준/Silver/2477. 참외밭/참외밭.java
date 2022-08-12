import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.StringTokenizer;

class Point {
	int x, y;

	public Point(int x, int y) {
		this.x = x;
		this.y = y;
	}

	public boolean equal(Point p) {
		if (this.x == p.x && this.y == p.y)
			return true;
		else
			return false;
	}
}

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int[] dx = { 0, 0, 1, -1 };
		int[] dy = { 1, -1, 0, 0 };

		int[] dx2 = { 0, 0, 2, 2 };
		int[] dy2 = { 0, 2, 0, 2 };

		int cnt = Integer.parseInt(br.readLine());
		int N = 6;

		int x = 0, y = 0;
		int i = 0;
		int dir, len;

		Set<Integer> xs = new HashSet<>();
		Set<Integer> ys = new HashSet<>();
		List<Point> pnt = new ArrayList<>();

		do {
			xs.add(x);
			ys.add(y);
			pnt.add(new Point(x, y));
			st = new StringTokenizer(br.readLine());
			dir = Integer.parseInt(st.nextToken())-1;
			len = Integer.parseInt(st.nextToken());

			x += dx[dir] * len;
			y += dy[dir] * len;
		} while (++i < 6);

		List<Integer> xList = new ArrayList<>(xs);
		List<Integer> yList = new ArrayList<>(ys);
		Collections.sort(xList);
		Collections.sort(yList);

		int total_area = Math.abs(xList.get(0) - xList.get(2)) * Math.abs(yList.get(0) - yList.get(2));

		int idx = 0;
		boolean isFind = true;
		while (isFind) {
			isFind = false;
			for (Point p : pnt) {
				if (p.equal(new Point(xList.get(dx2[idx]), yList.get(dy2[idx])))) {
					isFind = true;
					break;
				}
			}
			idx++;
		}
		idx--;
		total_area -= Math.abs(xList.get(dx2[idx]) - xList.get(1)) * Math.abs(yList.get(dy2[idx]) - yList.get(1)); 
		System.out.println(total_area*cnt);
	}

}