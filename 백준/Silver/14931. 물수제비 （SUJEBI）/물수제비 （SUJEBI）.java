import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int L = Integer.parseInt(br.readLine());

		int[] arr = new int[L + 1];
		st = new StringTokenizer(br.readLine());
		for (int i = 1; i <= L; ++i) {
			arr[i] = Integer.parseInt(st.nextToken());
		}

		long[] ans = new long[2];
		for (int d = 1; d <= L; ++d) {

			long v = 0;
			for (int k = d; k <= L; k += d) {
				v += arr[k];
			}

			if (v > ans[1])
				ans = new long[] { d, v };

		}

		System.out.println(ans[0] + " " + ans[1]);

	}

}