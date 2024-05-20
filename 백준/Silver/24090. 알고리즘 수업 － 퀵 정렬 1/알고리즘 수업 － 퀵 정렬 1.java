import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	static int n, k, change;
	static int[] A;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		n = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());

		A = new int[n];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < n; ++i) {
			A[i] = Integer.parseInt(st.nextToken());
		}

		quick_sort(A, 0, n - 1);
		if (change < k) {
			System.out.println("-1");
		}

	}

	private static void quick_sort(int[] A, int p, int r) {

		if (p < r) {
			int q = partition(A, p, r);
			if(q == -1) return;
			quick_sort(A, p, q - 1);
			quick_sort(A, q + 1, r);
		}

	}

	private static int partition(int[] A, int p, int r) {

		int x = A[r];
		int i = p - 1;

		for (int j = p; j < r; ++j) {
			if (A[j] <= x) {
				int temp = A[++i];
				A[i] = A[j];
				A[j] = temp;

				++change;
				if (change == k) {
					System.out.println(A[i] + " " + A[j]);
					return -1;
				}

			}
		}

		if (i + 1 != r) {
			int temp = A[i + 1];
			A[i + 1] = A[r];
			A[r] = temp;

			++change;
			if (change == k) {
				System.out.println(A[i + 1] + " " + A[r]);
				return -1;
			}
		}

		return i + 1;
	}

}