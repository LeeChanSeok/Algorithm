import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

	static int n;
	static long k;
	static long ans;
	static long[] d;
	static int[] arr;

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		arr = new int[n];

		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < n; ++i) {
			arr[i] = Integer.parseInt(st.nextToken());
		}

		d = new long[n];
		Arrays.fill(d, Long.MAX_VALUE);
		d[0] = 0;
		d[1] = Math.abs(arr[1] - arr[0]) + 1;

		for (int i = 2; i < n; ++i) {

			for (int j = 0; j < i; ++j) {
				d[i] = Math.min(d[i], Math.max(d[j], (long) (i - j) * (1 + Math.abs(arr[i] - arr[j]))));
			}
		}

		System.out.println(d[n - 1]);

	}

}