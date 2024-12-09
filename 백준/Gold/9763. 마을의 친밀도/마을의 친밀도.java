import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int N = Integer.parseInt(br.readLine());
		int[][] arr = new int[N][3];
		for (int i = 0; i < N; ++i) {
			st = new StringTokenizer(br.readLine());

			arr[i][0] = Integer.parseInt(st.nextToken());
			arr[i][1] = Integer.parseInt(st.nextToken());
			arr[i][2] = Integer.parseInt(st.nextToken());

		}

		long ans = Long.MAX_VALUE;
		for (int i = 0; i < N; ++i) {
			long min1 = Long.MAX_VALUE;
			long min2 = Long.MAX_VALUE;

			for (int j = 0; j < N; ++j) {
				if (i == j)
					continue;

				int d = Math.abs(arr[i][0] - arr[j][0]) + Math.abs(arr[i][1] - arr[j][1])
						+ Math.abs(arr[i][2] - arr[j][2]);

				if (d < min2) {
					min2 = d;
				}

				if (min1 > min2) {
					long tmp = min1;
					min1 = min2;
					min2 = tmp;
				}

			}
			ans = Math.min(ans, min1 + min2);
		}

		System.out.println(ans);

	}

}