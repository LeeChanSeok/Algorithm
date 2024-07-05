import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());

		int[] arr = new int[N + 1];
		long A = 0, B = 0;

		for (int i = 1; i <= N; ++i) {
			arr[i] = Integer.parseInt(br.readLine());
			A += arr[i];
		}

		long min = A;
		int idx = 0;

		for (int i = 1; i <= N; ++i) {
			A -= arr[i];
			B += arr[i];

			long diff = (long) Math.abs(A - B);
			if (diff < min) {
				min = diff;
				idx = i;				
			}

		}

		System.out.println(idx);

	}

}