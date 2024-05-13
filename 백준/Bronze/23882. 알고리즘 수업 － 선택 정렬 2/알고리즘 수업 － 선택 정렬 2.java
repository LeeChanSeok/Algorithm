import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	static int n, k;
	static int[] arr;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		n = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());

		arr = new int[n];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < n; ++i) {
			arr[i] = Integer.parseInt(st.nextToken());
		}

		selection_sort();
	}

	private static void selection_sort() {
		StringBuilder sb = new StringBuilder();
		int change = 0;
		for (int last = n - 1; last >= 1; --last) {

			int idx = 0;
			int max = arr[idx];

			for (int j = 1; j <= last; ++j) {
				if (arr[j] > max) {
					idx = j;
					max = arr[j];
				}
			}

			if (last != idx) {
				++change;
				int temp = arr[last];
				arr[last] = max;
				arr[idx] = temp;

				if (change == k) {
					for (int num : arr) {
						sb.append(num + " ");
					}
					System.out.println(sb);
					return;
				}
			}

		}

		System.out.println(-1);
	}

}