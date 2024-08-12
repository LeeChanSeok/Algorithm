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

	private static long binarySearch() {

		long l = 0, r = 100000;
		long res = r;
		while (l <= r) {
			long mid = (l + r) / 2;

			long avil = mid;
			long score = 0;
			for (int i = 0; i < M; ++i) {
				int v = shooting(avil);
				avil += v;
				score += v;
			}

			if (score >= A) {
				res = Math.min(res, mid);
				r = mid - 1;
			} else {
				l = mid + 1;
			}
		}

		return res;

	}

	private static int shooting(long target) {

		int l = 0, r = N - 1;
		int score = 0;
		while (l <= r) {
			int mid = (l + r) / 2;

			if (arr[mid] <= target) {
				score = Math.max(score, arr[mid]);
				l = mid + 1;
			} else {
				r = mid - 1;
			}
		}
		return score;
	}

}