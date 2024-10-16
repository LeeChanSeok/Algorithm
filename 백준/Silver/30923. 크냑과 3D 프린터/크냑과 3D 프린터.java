import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int N = Integer.parseInt(br.readLine());
		int[] arr = new int[N + 2];

		st = new StringTokenizer(br.readLine());
		for (int i = 1; i <= N; ++i) {
			arr[i] = Integer.parseInt(st.nextToken());
		}

		long ans = N * 2;
		for (int i = 1; i <= N; ++i) {
			ans += arr[i] * 2;
			ans += Math.max(0, arr[i] - arr[i - 1]);
			ans += Math.max(0, arr[i] - arr[i + 1]);
		}

		System.out.println(ans);

	}

}