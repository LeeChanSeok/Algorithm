import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	static int ans;
	static int all;
	static int N, K;
	static int[] A, B, C;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());

		A = new int[N];
		B = new int[N];
		C = new int[N];

		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; ++i) {
			A[i] = Integer.parseInt(st.nextToken());
		}

		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; ++i) {
			B[i] = Integer.parseInt(st.nextToken());
		}

		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; ++i) {
			C[i] = Integer.parseInt(st.nextToken());
		}

		ans = -1;
		all = (1 << N) - 1;
		for (int i = 0; i < N; ++i) {
			recursive(i, 1 << i, 0);
		}

		System.out.println(ans);
	}

	private static void recursive(int prev, int flag, int total) {

		if (flag == all) {
			ans = Math.max(ans, total);
			return;
		}

		for (int i = 0; i < N; ++i) {
			if ((flag & (1 << i)) != 0)
				continue;
			if (C[prev] * C[i] > K)
				continue;

			recursive(i, flag | (1 << i), total + A[prev] * B[i]);
		}
	}

}