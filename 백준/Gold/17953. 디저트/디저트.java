import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());

		int[][] arr = new int[M][N];
		int[][] D = new int[M][N];

		for (int i = 0; i < M; ++i) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; ++j) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		for (int i = 0; i < M; i++) {
			D[i][0] = arr[i][0];
		}

		for (int i = 1; i < N; ++i) {
			for (int j = 0; j < M; ++j) {
				for (int k = 0; k < M; ++k) {
					if (j == k)
						D[j][i] = Math.max(arr[j][i] / 2 + D[k][i - 1], D[j][i]);
					else
						D[j][i] = Math.max(arr[j][i] + D[k][i - 1], D[j][i]);
				}
			}
		}

		int max = 0;
		for (int i = 0; i < M; ++i) {
			max = Math.max(D[i][N - 1], max);
		}
		System.out.println(max);

	}

}