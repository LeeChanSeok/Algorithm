import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int N = Integer.parseInt(br.readLine());
		int[][] pnt = new int[N][2];

		for (int i = 0; i < N; ++i) {
			st = new StringTokenizer(br.readLine());
			pnt[i][0] = Integer.parseInt(st.nextToken());
			pnt[i][1] = Integer.parseInt(st.nextToken());
		}

		long ans = Long.MAX_VALUE;

		for (int i = 0; i < N - 1; ++i) {
			for (int j = i + 1; j < N; ++j) {
				long area = 0;
				long minX = Long.MAX_VALUE;
				long maxX = Long.MIN_VALUE;
				long minY = Long.MAX_VALUE;
				long maxY = Long.MIN_VALUE;

				for (int k = 0; k < N; ++k) {
					if (k == i || k == j)
						continue;
					minX = Math.min(minX, pnt[k][0]);
					maxX = Math.max(maxX, pnt[k][0]);
					minY = Math.min(minY, pnt[k][1]);
					maxY = Math.max(maxY, pnt[k][1]);

				}
				long len = Math.max(maxX - minX, maxY - minY);
				area = (len + 2) * (len + 2);
				ans = Math.min(ans, area);

			}
		}

		System.out.println(ans);
	}

}