import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());

		int[] A = new int[N + 1];
		int[] D = new int[N + 1];
		for (int i = 1; i <= N; ++i) {
			D[i] = A[i] = Integer.parseInt(br.readLine());
		}

		int max = 0;
		for (int i = 1; i <= N; ++i) {
			for (int j = i; j > 0; --j) {
				if (A[i] > A[j]) {
					D[i] = Math.max(D[i], D[j] + A[i]);
					max = Math.max(max, D[i]);
				}

			}
		}

		System.out.println(max);
	}

}