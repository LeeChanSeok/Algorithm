import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

	static int N, K;
	static int[][] arr;
	static int[] A;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());

		arr = new int[N][2];
		A = new int[N];
		for (int i = 0; i < N; ++i) {
			st = new StringTokenizer(br.readLine());
			arr[i][0] = Integer.parseInt(st.nextToken());
			arr[i][1] = Integer.parseInt(st.nextToken());

			A[i] = arr[i][1] - arr[i][0];
		}

		Arrays.sort(A);
		long ans = binarySearch();
		System.out.println(ans);
	}

	private static long binarySearch() {

		long l = 0, r = (int) 1e9;
		long res = 0;
		while (l <= r) {
			long mid = (l + r) / 2;

			int k = binarySearch(mid);
			if (k >= K) {
				res = mid;
				r = mid - 1;
			} else {
				l = mid + 1;
			}
		}

		return res;
	}

	private static int binarySearch(long target) {

		int l = 0, r = N - 1;
		int res = 0;

		while (l <= r) {
			int mid = (l + r) / 2;

			if (A[mid] <= target) {
				res = mid + 1;
				l = mid + 1;
			} else {
				r = mid - 1;
			}

		}

		return res;
	}

}