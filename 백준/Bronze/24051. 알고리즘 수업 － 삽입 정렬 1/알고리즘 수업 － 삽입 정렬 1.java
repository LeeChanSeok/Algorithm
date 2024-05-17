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

		System.out.println(insertion_sort());
	}

	private static int insertion_sort() {

		int change = 0;
		for (int i = 1; i < n; ++i) {
			int loc = i - 1;
			int newItem = arr[i];

			while (loc >= 0 && newItem < arr[loc]) {
				++change;
				arr[loc + 1] = arr[loc];
				--loc;

				if (change == k) {
					return arr[loc + 1];
				}
			}

			if (loc + 1 != i) {
				++change;
				arr[loc + 1] = newItem;
				if (change == k) {
					return arr[loc + 1];
				}

			}

		}

		return -1;
	}

}