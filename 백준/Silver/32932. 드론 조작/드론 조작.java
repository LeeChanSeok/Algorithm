import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());

		int ALPHA = 500;
		int DELTA = 10000;
		Set<Integer> set = new HashSet<>();
		for (int i = 0; i < N; ++i) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken()) + ALPHA;
			int y = Integer.parseInt(st.nextToken()) + ALPHA;

			set.add(x * DELTA + y);
		}

		int x = 0, y = 0;

		char[] cmd = br.readLine().toCharArray();
		for (char c : cmd) {
			if (c == 'L') {
				int nx = x - 1;
				int ny = y;

				if (set.contains((nx + ALPHA) * DELTA + (ny + ALPHA)))
					continue;
				x = nx;
				y = ny;
			} else if (c == 'R') {
				int nx = x + 1;
				int ny = y;

				if (set.contains((nx + ALPHA) * DELTA + (ny + ALPHA)))
					continue;
				x = nx;
				y = ny;
			} else if (c == 'U') {
				int nx = x;
				int ny = y + 1;

				if (set.contains((nx + ALPHA) * DELTA + (ny + ALPHA)))
					continue;
				x = nx;
				y = ny;
			} else if (c == 'D') {
				int nx = x;
				int ny = y - 1;

				if (set.contains((nx + ALPHA) * DELTA + (ny + ALPHA)))
					continue;
				x = nx;
				y = ny;
			}
		}

		System.out.println(x + " " + y);

	}

}