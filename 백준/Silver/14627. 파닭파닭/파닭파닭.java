import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	static int S, C;
	static int[] A;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		S = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());

		A = new int[S];
		for (int i = 0; i < S; ++i) {
			A[i] = Integer.parseInt(br.readLine());
		}

		long res = 1;
		long l = 1, r = 1000000000;
		while (l <= r) {
			long mid = (l + r) / 2;
			if (solution(mid)) {
				res = mid;
				l = mid + 1;
			} else
				r = mid - 1;
		}

		long cnt = 0;
		long ans = 0;
		for (int i = 0; i < S; ++i) {
			long mok = A[i] / res;
			if (cnt + mok > C) {
				mok = C - cnt;
			}
			cnt += mok;
			ans += (A[i] - res * mok);
		}

		System.out.println(ans);
	}

	private static boolean solution(long target) {

		int cnt = 0;
		for (int i = 0; i < S; ++i) {
			cnt += A[i] / target;
		}

		if (cnt >= C)
			return true;
		return false;
	}

}