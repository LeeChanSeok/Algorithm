import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());
		int S = Integer.parseInt(st.nextToken());

		int[] arr = new int[N];
		for (int i = 0; i < N; ++i) {
			arr[i] = Integer.parseInt(br.readLine());
		}

		Arrays.sort(arr);

		int ans = 0;
		int l = 0, r = N - 1;
		while (l < r) {

			if (arr[l] + arr[r] > S)
				--r;
			else {

				ans += (r - l);
				++l;
			}

		}

		System.out.println(ans);

	}

}