import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());

		int[] arr = new int[N];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; ++i) {
			arr[i] = Integer.parseInt(st.nextToken());
		}

		Arrays.sort(arr);

		int[] diff = new int[N];
		int prev = 0;
		for (int i = 0; i < N; ++i) {
			diff[i] = arr[i] - prev;
			prev = arr[i];
		}

		Arrays.sort(diff);

		int sum = 0;
		for (int j = N - K - 1; j >= 0; --j) {
			sum += diff[j];
		}

		System.out.println(sum);

	}

}