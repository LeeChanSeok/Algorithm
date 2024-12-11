import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());
		int[] A = new int[N + 1];
		for (int i = 1; i <= N; ++i) {
			A[i] = Integer.parseInt(br.readLine());
		}

		int M = Integer.parseInt(br.readLine());
		int sum = 0;
		for (int i = 0; i < M; ++i) {
			int idx = Integer.parseInt(br.readLine());
			sum += A[idx];
		}

		System.out.println(sum);

	}

}