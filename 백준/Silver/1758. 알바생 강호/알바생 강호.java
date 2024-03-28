import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int n = Integer.parseInt(br.readLine());
		Integer[] arr = new Integer[n];

		for (int i = 0; i < n; ++i) {
			arr[i] = Integer.parseInt(br.readLine());
		}

		Arrays.sort(arr, (a1, a2) -> a2 - a1);

		long sum = 0;
		for (int i = 0; i < n; ++i) {
			int res = arr[i] - i;
			if (res <= 0)
				break;

			sum += res;
		}

		System.out.println(sum);

	}

}