import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	static class Region {
		int x, y;

		public Region(int x, int y) {
			super();
			this.x = x;
			this.y = y;
		}

	}

	static int N;
	static Region[] regions;
	static int cnt, min;

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		N = Integer.parseInt(br.readLine());
		regions = new Region[10];

		Region Nouzen = null;
		boolean even = false, odd = false;
		for (int i = 0; i < N; ++i) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; ++j) {
				char c = st.nextToken().charAt(0);

				if (c == '1') {
					regions[cnt++] = new Region(i, j);

					if ((i + j) % 2 == 0)
						even = true;
					else
						odd = true;
				} else if (c == '2') {
					Nouzen = new Region(i, j);
				}
			}
		}

		boolean nouEven = ((Nouzen.x + Nouzen.y) % 2 == 0) ? true : false;
		if ((nouEven && odd) || (!nouEven && even)) {
			System.out.println("Shorei");
		} else {
			System.out.println("Undertaker");
			min = Integer.MAX_VALUE;
			solution(Nouzen, 0, 0, cnt);
			System.out.println(min);
		}
	}

	private static void solution(Region pos, int flag, int move, int kill) {

		if (move >= min)
			return;

		if (kill == 0) {
			min = Math.min(min, move);
			return;
		}

		for (int i = 0; i < cnt; ++i) {

			if (((1 << i) & flag) != 0)
				continue;

			solution(regions[i], flag | (1 << i),
					move + Math.max(Math.abs(pos.x - regions[i].x), Math.abs(pos.y - regions[i].y)), kill - 1);

		}

	}

}