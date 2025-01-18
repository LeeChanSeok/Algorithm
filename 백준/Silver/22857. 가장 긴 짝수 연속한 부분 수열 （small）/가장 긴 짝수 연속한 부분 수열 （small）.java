import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());

		int[] A = new int[N + 1];
		st = new StringTokenizer(br.readLine());
		for (int i = 1; i <= N; ++i) {
			A[i] = Integer.parseInt(st.nextToken());
		}

		int[][] D = new int[N + 1][K + 1];
		for (int i = 1; i <= N; ++i) {
			for (int j = 0; j <= K; ++j) {
				if (A[i] % 2 == 0)
					D[i][j] = D[i - 1][j] + 1;
				else if (j != 0 && (A[i] % 2 == 1))
					D[i][j] = D[i - 1][j - 1];
			}
		}

		int max = 0;
		for (int i = 1; i <= N; ++i) {
			max = Math.max(max, D[i][K]);
		}
		System.out.println(max);
	}

}