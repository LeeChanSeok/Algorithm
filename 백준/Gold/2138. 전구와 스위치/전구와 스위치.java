import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
	static int MAX = (int) 1e9;
	static int N;
	static int min;
	static char[] A, B, C;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		N = Integer.parseInt(br.readLine());

		A = br.readLine().toCharArray();
		B = Arrays.copyOf(A, A.length);
		C = br.readLine().toCharArray();

		B[0] = change(B[0]);
		B[1] = change(B[1]);

		min = Math.min(solution(A), solution(B) + 1);
		if (min == MAX)
			min = -1;
		System.out.println(min);

	}

	private static char change(char c) {
		return (c == '0') ? '1' : '0';
	}

	private static int solution(char[] A) {

		int cnt = 0;

		for (int i = 1; i < N - 1; ++i) {
			if (A[i - 1] != C[i - 1]) {
				A[i] = change(A[i]);
				A[i + 1] = change(A[i + 1]);
				++cnt;
			}
		}

		if (A[N - 2] != C[N - 2]) {
			A[N - 1] = change(A[N - 1]);
			++cnt;
		}

		if (A[N - 1] == C[N - 1])
			return cnt;
		return MAX;
	}

}