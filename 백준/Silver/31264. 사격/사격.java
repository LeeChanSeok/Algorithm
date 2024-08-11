import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

	static int N, M, ans;
	static long A;
	static int[] arr;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		A = Long.parseLong(st.nextToken());

		arr = new int[N];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; ++i) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(arr);

		System.out.println(binarySearch());

	}

	private static int binarySearch() {

		int l = 1, r = 100000;
		int res = r;
		while (l <= r) {
			int mid = (l + r) / 2;

			if (shooting(mid)) {
				res = mid;
				r = mid - 1;
			} else {
				l = mid + 1;
			}
		}

		return res;

	}

	private static boolean shooting(int target) {
		
		int score = 0;
		int avil = target;
		for (int i = 0; i < M; ++i) {
			int l = 0, r = N-1;
			int idx = N;
			while (l <= r) {
				int mid = (l + r) / 2;

				if (arr[mid] > avil) {
					idx = Math.min(idx, mid);
					r = mid - 1;
				} else {
					l = mid + 1;
				}
			}
			if(idx == 0) return false;
			score += arr[idx - 1];
			avil += arr[idx - 1];
		}
		
		if (score >= A)
			return true;
		return false;
	}

}