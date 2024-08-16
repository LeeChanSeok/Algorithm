import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	static class Rec {
		int x1, y1, x2, y2;

		public Rec(int x1, int y1, int x2, int y2) {
			super();
			this.x1 = x1;
			this.y1 = y1;
			this.x2 = x2;
			this.y2 = y2;
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

		String ans = "NULL";
		if (p.x1 == q.x2 || p.x2 == q.x1) {
			if (p.y1 == q.y2 || p.y2 == q.y1)
				ans = "POINT";
			else if ((p.y2 - p.y1) + (q.y2 - q.y1) > Math.max(q.y2 - p.y1, p.y2 - q.y1))
				ans = "LINE";
			else
				ans = "NULL";
		} else if ((p.x2 - p.x1) + (q.x2 - q.x1) > Math.max(q.x2 - p.x1, p.x2 - q.x1)) {
			if (p.y1 == q.y2 || p.y2 == q.y1)
				ans = "LINE";
			else if ((p.y2 - p.y1) + (q.y2 - q.y1) > Math.max(q.y2 - p.y1, p.y2 - q.y1))
				ans = "FACE";
			else
				ans = "NULL";
		}

		System.out.println(ans);
	}

}