import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	static int N;
	static int[][] A, B;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		N = Integer.parseInt(br.readLine());

		A = new int[N][N];
		for (int i = 0; i < N; ++i) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; ++j) {
				A[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		B = new int[N][N];
		B[0][0] = A[0][0];

		for (int i = 1; i < N; ++i) {
			B[0][i] = (B[0][i - 1] << 1) + A[0][i];
			B[i][0] = (B[i - 1][0] << 1) + A[i][0];
		}

		for (int i = 1; i < N; ++i) {
			for (int j = 1; j < N; ++j) {
				B[i][j] = Math.max(B[i - 1][j] << 1, B[i][j - 1] << 1) + A[i][j];
			}
		}

		System.out.println(B[N - 1][N - 1]);

	}

}