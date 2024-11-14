import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	static int N;
	static long[] A, B;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;

		N = Integer.parseInt(br.readLine());
		A = new long[N];
		B = new long[N];

		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; ++i) {
			A[i] = Long.parseLong(st.nextToken());
		}

		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; ++i) {
			B[i] = Long.parseLong(st.nextToken());
		}

		for (int i = 0; i < N; ++i) {
			int res = binarySearch(i);
			sb.append(res + " ");
		}

		System.out.println(sb);
	}

	private static int binarySearch(int idx) {

		int l = idx + 1, r = N - 1;

		while (l <= r) {
			int mid = (l + r) / 2;

			if (A[idx] >= B[mid]) {
				l = mid + 1;
			} else {
				r = mid - 1;
			}
		}

		return r - idx;
	}

}