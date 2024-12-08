import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

	static int N, L, R;
	static int[] A;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		L = Integer.parseInt(st.nextToken());
		R = Integer.parseInt(st.nextToken());

		A = new int[N + 1];
		st = new StringTokenizer(br.readLine());
		for (int i = 1; i <= N; ++i) {
			A[i] = Integer.parseInt(st.nextToken());
		}

		Arrays.sort(A, L, R + 1);
		if (isSequence())
			System.out.println('1');
		else
			System.out.println('0');

	}

	private static boolean isSequence() {

		if (L != 1 && A[L - 1] > A[L])
			return false;
		if (R != N && A[R] > A[R + 1])
			return false;

		return true;
	}

}