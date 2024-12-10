import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;

		int N = Integer.parseInt(br.readLine());

		int[][] A = new int[N + 1][N + 1];
		for (int i = 1; i <= N; ++i) {
			st = new StringTokenizer(br.readLine());
			for (int j = 1; j <= N; ++j) {
				A[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		int MAX = 10;
		int[][][] arr = new int[N + 1][N + 1][MAX + 1];
		for (int i = 1; i <= N; ++i) {
			for (int j = 1; j <= N; ++j) {

				for (int k = 1; k <= MAX; ++k) {
					arr[i][j][k] = arr[i - 1][j][k] + arr[i][j - 1][k] - arr[i - 1][j - 1][k];
				}
				++arr[i][j][A[i][j]];
			}
		}

		int Q = Integer.parseInt(br.readLine());
		while (Q-- > 0) {
			st = new StringTokenizer(br.readLine());

			int x1 = Integer.parseInt(st.nextToken());
			int y1 = Integer.parseInt(st.nextToken());
			int x2 = Integer.parseInt(st.nextToken());
			int y2 = Integer.parseInt(st.nextToken());

			int res = 0;
			for (int k = 1; k <= MAX; ++k) {
				if (arr[x2][y2][k] - arr[x1 - 1][y2][k] - arr[x2][y1 - 1][k] + arr[x1 - 1][y1 - 1][k] > 0)
					++res;
			}
			bw.write(res + "\n");
		}

		bw.flush();
	}

}