import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int n = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());

		int[] arr = new int[n];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < n; ++i) {
			arr[i] = Integer.parseInt(st.nextToken());
		}

		int[] cnt = new int[100001];
		int max = 1;

		int len = 1;
		int l = 0, r = 0;
		while (l <= r) {
			if (r >= n)
				break;

			if (cnt[arr[r]] >= k) {

				while (arr[l] != arr[r]) {
					--len;
					--cnt[arr[l]];
					++l;
				}
				--len;
				--cnt[arr[l]];
				++l;

			} else {
				max = Math.max(max, len);
				cnt[arr[r++]]++;
				++len;
			}

		}

		System.out.println(max);

	}

}