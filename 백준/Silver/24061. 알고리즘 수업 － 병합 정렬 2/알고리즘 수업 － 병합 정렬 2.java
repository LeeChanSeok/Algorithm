import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	static int n, k, change;
	static int[] temp;
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		n = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());

		int[] arr = new int[n];
		temp = new int[n];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < n; ++i) {
			arr[i] = Integer.parseInt(st.nextToken());
		}

		merge_sort(arr, 0, n - 1);
		if (change < k)
			System.out.println("-1");
		else
			System.out.println(sb);
	}

	private static void merge_sort(int[] A, int p, int r) {
		if (p < r) {
			int q = (p + r) / 2;
			merge_sort(A, p, q);
			merge_sort(A, q + 1, r);
			merge(A, p, q, r);
		}

	}

	private static void merge(int[] A, int p, int q, int r) {

		int i = p, j = q + 1, t = 0;
		while (i <= q && j <= r) {
			if (A[i] <= A[j]) {
				temp[t++] = A[i++];
			} else {
				temp[t++] = A[j++];
			}
		}

		while (i <= q) {
			temp[t++] = A[i++];
		}

		while (j <= r) {
			temp[t++] = A[j++];
		}

		i = p;
		t = 0;

		while (i <= r) {
			++change;
			A[i++] = temp[t++];
			if (change == k) {
				for (int num : A) {
					sb.append(num + " ");
				}
				return;
			}
		}
	}

}