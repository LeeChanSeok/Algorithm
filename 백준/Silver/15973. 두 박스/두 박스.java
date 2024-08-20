import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	static class Pnt {
		int x, y;

		public Pnt(int x, int y) {
			super();
			this.x = x;
			this.y = y;
		}

	}

	static class Rec {
		int x1, y1, x2, y2;
		Pnt lu, ru, ld, rd;

		public Rec(int x1, int y1, int x2, int y2) {
			super();
			this.x1 = x1;
			this.y1 = y1;
			this.x2 = x2;
			this.y2 = y2;

			lu = new Pnt(x1, y2);
			ru = new Pnt(x2, y2);
			ld = new Pnt(x1, y1);
			rd = new Pnt(x2, y1);
		}

	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		Rec p, q;
		int x1, y1, x2, y2;

		st = new StringTokenizer(br.readLine());
		x1 = Integer.parseInt(st.nextToken());
		y1 = Integer.parseInt(st.nextToken());
		x2 = Integer.parseInt(st.nextToken());
		y2 = Integer.parseInt(st.nextToken());
		p = new Rec(x1, y1, x2, y2);

		st = new StringTokenizer(br.readLine());
		x1 = Integer.parseInt(st.nextToken());
		y1 = Integer.parseInt(st.nextToken());
		x2 = Integer.parseInt(st.nextToken());
		y2 = Integer.parseInt(st.nextToken());
		q = new Rec(x1, y1, x2, y2);

		String ans = "FACE";

		if (POINT(p, q) || POINT(q, p))
			ans = "POINT";
		if (LINE(p, q) || LINE(q, p))
			ans = "LINE";
		if (NULL(p, q) || NULL(q, p))
			ans = "NULL";
		System.out.println(ans);
	}

	private static boolean NULL(Rec p, Rec q) {

		if (p.lu.y < q.ld.y || p.ld.y > q.lu.y || p.lu.x > q.ru.x || p.ru.x < q.lu.x)
			return true;

		return false;
	}

	private static boolean LINE(Rec p, Rec q) {

		if (isLine(p.lu.x, p.ru.x, q.ld.x, q.rd.x, p.lu.y, q.ld.y)
				|| isLine(p.ld.x, p.rd.x, q.lu.x, q.ru.x, p.lu.y, q.ld.y)
				|| isLine(p.ld.y, p.lu.y, q.rd.y, q.ru.y, p.lu.x, q.ru.x)
				|| isLine(p.rd.y, p.ru.y, q.ld.y, q.ru.y, p.ru.x, q.lu.x))
			return true;

		return false;
	}

	private static boolean isLine(int p1, int p2, int q1, int q2, int p, int q) {

		if (p != q)
			return false;

		if ((p1 < q2 && q2 < p2) || (p1 < q1 && q1 < p2) || (q1 <= p1 && p2 <= q2))
			return true;

		return false;
	}

	private static boolean POINT(Rec p, Rec q) {

		if (isSame(p.lu, q.rd) || isSame(p.ru, q.ld) || isSame(p.ld, q.ru) || isSame(p.rd, q.lu))
			return true;
		return false;
	}

	private static boolean isSame(Pnt p1, Pnt p2) {
		if (p1.x == p2.x && p1.y == p2.y)
			return true;
		return false;
	}

}