import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;

		int K = Integer.parseInt(br.readLine());
		for (int i = 1; i <= K; ++i) {
			st = new StringTokenizer(br.readLine());

			int N = Integer.parseInt(st.nextToken());
			int[] arr = new int[N];
			for (int j = 0; j < N; ++j) {
				arr[j] = Integer.parseInt(st.nextToken());
			}

			Arrays.sort(arr);

			int max = arr[N - 1];
			int min = arr[0];
			int diff = 0;
			for (int j = 1; j < N; ++j) {
				diff = Math.max(diff, arr[j] - arr[j - 1]);
			}

			sb.append(String.format("Class %d\nMax %d, Min %d, Largest gap %d\n", i, max, min, diff));

		}

		System.out.println(sb);

	}

}