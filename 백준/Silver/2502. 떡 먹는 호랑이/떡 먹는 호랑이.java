import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int D = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());

		int MAX_D = 30;
		int[] A = new int[MAX_D + 1];
		int[] B = new int[MAX_D + 1];

		A[1] = 1;
		A[2] = 0;
		B[1] = 0;
		B[2] = 1;

		for (int d = 3; d <= MAX_D; ++d) {
			A[d] = A[d - 1] + A[d - 2];
			B[d] = B[d - 1] + B[d - 2];
		}

		for (int i = 1; i <= K; ++i) {
			if ((K - A[D] * i) % B[D] == 0) {
				System.out.println(i);
				System.out.println((K - A[D] * i) / B[D]);
				break;
			}
		}

	}

}