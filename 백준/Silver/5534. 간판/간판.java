import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {

	static char[] A, B;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());
		A = br.readLine().toCharArray();

		int ans = 0;
		for (int i = 0; i < N; ++i) {
			B = br.readLine().toCharArray();

			for (int j = 0; j < B.length; ++j) {
				if (A[0] == B[j]) {
					if (solution(j)) {
						++ans;
						break;
					}
				}
			}
		}

		System.out.println(ans);
	}

	private static boolean solution(int idx) {

		for (int k = 1; k < B.length; ++k) {
			int i = 0;
			if (idx + (A.length - 1) * k > B.length)
				return false;

			for (; i < A.length; ++i) {
				int bIdx = idx + i * k;
				if (bIdx >= B.length)
					break;
				if (A[i] != B[bIdx])
					break;
			}

			if (i == A.length)
				return true;
		}

		return true;
	}

}