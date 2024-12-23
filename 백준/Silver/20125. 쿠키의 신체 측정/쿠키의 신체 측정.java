import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {

	static class Pos {
		int x, y;

		public Pos(int x, int y) {
			super();
			this.x = x;
			this.y = y;
		}

		@Override
		public String toString() {
			return "Pos [x=" + x + ", y=" + y + "]";
		}

	}

	static int[] dx = { 0, 0, 1 };
	static int[] dy = { -1, 1, 0 };
	static int N;
	static char[][] arr;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		N = Integer.parseInt(br.readLine());

		arr = new char[N][N];

		for (int i = 0; i < N; ++i) {
			arr[i] = br.readLine().toCharArray();
		}

		Pos head = find_head();
		Pos heart = new Pos(head.x + 1, head.y);
		Pos la = get_Pos(0, new Pos(heart.x, heart.y - 1));
		Pos ra = get_Pos(1, new Pos(heart.x, heart.y + 1));
		Pos w = get_Pos(2, new Pos(heart.x + 1, heart.y));
		Pos ll = get_Pos(2, new Pos(w.x + 1, w.y - 1));
		Pos rl = get_Pos(2, new Pos(w.x + 1, w.y + 1));

		System.out.println((heart.x + 1) + " " + (heart.y + 1));
		System.out.println(get_Length(heart, la) + " " + get_Length(heart, ra) + " " + get_Length(heart, w) + " "
				+ get_Length(new Pos(w.x, w.y - 1), ll) + " " + get_Length(new Pos(w.x, w.y + 1), rl));
	}

	private static int get_Length(Pos a, Pos b) {

		return Math.abs(a.x - b.x) + Math.abs(a.y - b.y);
	}

	private static Pos get_Pos(int d, Pos pos) {

		int x = pos.x, y = pos.y;
		while (inRange(x, y) && arr[x][y] == '*') {
			x += dx[d];
			y += dy[d];

		}
		x -= dx[d];
		y -= dy[d];
		return new Pos(x, y);
	}

	private static boolean inRange(int x, int y) {
		if (x < 0 || x >= N || y < 0 || y >= N)
			return false;
		return true;
	}

	private static Pos find_head() {

		for (int i = 0; i < N; ++i) {
			for (int j = 0; j < N; ++j) {
				if (arr[i][j] == '*')
					return new Pos(i, j);
			}
		}
		return null;
	}

}