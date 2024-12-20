import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	static int N, K;
	static int[] A;
	static int[][] R, M;
	static int rang, marry, ans;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());

		A = new int[N];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; ++i) {
			A[i] = Integer.parseInt(st.nextToken());
		}

		R = new int[K][N];
		for (int i = 0; i < K; ++i) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; ++j) {
				R[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		M = new int[K][N];
		for (int i = 0; i < K; ++i) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; ++j) {
				M[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		recursive(0);
		System.out.println(ans);

	}

	private static void recursive(int day) {
		if (day == K) {
			ans = Math.max(ans, rang + marry);
			return;
		}

		for (int i = 0; i < N; ++i) {
			if (A[i] == 0)
				continue;

			--A[i];
			rang += R[day][i];
			for (int j = 0; j < N; ++j) {
				if (A[j] == 0)
					continue;
				--A[j];
				marry += M[day][j];
				recursive(day + 1);
				++A[j];
				marry -= M[day][j];
			}

			++A[i];
			rang -= R[day][i];
		}

	}

}