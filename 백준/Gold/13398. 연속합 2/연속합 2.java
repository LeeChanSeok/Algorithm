import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int N = Integer.parseInt(br.readLine());
		int[] A = new int[N + 1];
		st = new StringTokenizer(br.readLine());
		for (int i = 1; i <= N; ++i) {
			A[i] = Integer.parseInt(st.nextToken());
		}

		int max = Integer.MIN_VALUE;
		int[] D1 = new int[N + 1];
		for (int i = 1; i <= N; ++i) {
			D1[i] = Math.max(A[i], D1[i - 1] + A[i]);
			max = Math.max(max, D1[i]);
		}

		int[] D2 = new int[N + 1];
		D2[N] = A[N];
		for (int i = N - 1; i > 0; --i) {
			D2[i] = Math.max(A[i], D2[i + 1] + A[i]);
		}

		for (int i = 2; i < N; ++i) {
			max = Math.max(max, D1[i - 1] + D2[i + 1]);
		}

		System.out.println(max);
	}

}