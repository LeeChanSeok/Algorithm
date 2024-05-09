import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(br.readLine());

		int r = Integer.parseInt(st.nextToken());
		int c = Integer.parseInt(st.nextToken());
		int q = Integer.parseInt(st.nextToken());

		int[][] arr = new int[r + 1][c + 1];
		for (int i = 1; i <= r; ++i) {
			st = new StringTokenizer(br.readLine());
			for (int j = 1; j <= c; ++j) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		for (int i = 1; i <= r; ++i) {
			for (int j = 1; j <= c; ++j) {
				arr[i][j] = arr[i][j] + arr[i - 1][j] + arr[i][j - 1] - arr[i - 1][j - 1];
			}
		}

		for (int i = 0; i < q; ++i) {
			st = new StringTokenizer(br.readLine());
			int r1 = Integer.parseInt(st.nextToken());
			int c1 = Integer.parseInt(st.nextToken());
			int r2 = Integer.parseInt(st.nextToken());
			int c2 = Integer.parseInt(st.nextToken());

			int ans = arr[r2][c2] - arr[r1-1][c2] - arr[r2][c1-1] + arr[r1 - 1][c1 - 1];
			int cnt = (r2 - r1 + 1) * (c2 - c1 + 1);
			sb.append(ans/cnt).append('\n');
		}

		System.out.println(sb);
	}

}