import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	static int N, F;
	static int[][] A;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		F = Integer.parseInt(st.nextToken());

		A = new int[N][N];
		recursive(0, 0);

		for (int i = 0; i < N; ++i)
			sb.append(A[0][i] + " ");

		System.out.println(sb);

	}

	private static boolean recursive(int depth, int flag) {

		if (depth == N) {
			if (simulation())
				return true;

		}

		for (int i = 1; i <= N; ++i) {
			if ((flag & (1 << i)) != 0)
				continue;
			A[0][depth] = i;
			if(recursive(depth + 1, flag | (1 << i))) return true;

		}

		return false;
	}

	private static boolean simulation() {

		for (int i = 1; i < N; ++i) {
			for (int j = i; j < N; ++j) {
				A[i][j] = A[i - 1][j - 1] + A[i - 1][j];
			}
		}

		if (A[N - 1][N - 1] == F)
			return true;

		return false;
	}

}