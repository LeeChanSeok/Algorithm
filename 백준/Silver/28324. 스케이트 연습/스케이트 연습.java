import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int N = Integer.parseInt(br.readLine());

		int[] arr = new int[N];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; ++i) {
			arr[i] = Integer.parseInt(st.nextToken());
		}

		long ans = 0;
		int h = 0;
		for (int j = N - 1; j >= 0; --j) {
			int min = Math.min(h + 1, arr[j]);
			ans += min;
			h = min;
		}

		System.out.println(ans);

	}

}