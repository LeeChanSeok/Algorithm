import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int N = Integer.parseInt(br.readLine());
		Integer[] arr = new Integer[N];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; ++i) {
			arr[i] = Integer.parseInt(st.nextToken());
		}

		Arrays.sort(arr, (a, b) -> b - a);

		int max = 0;
		for (int i = 0; i < N; ++i) {
			max = Math.max(max, arr[i] + i + 2);
		}

		System.out.println(max);

	}

}