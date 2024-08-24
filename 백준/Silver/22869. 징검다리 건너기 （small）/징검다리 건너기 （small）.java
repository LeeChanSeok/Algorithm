import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

	static int n, k;
	static int ans;
	static int[] d;
	static int[] arr;

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());
		arr = new int[n];

		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < n; ++i) {
			arr[i] = Integer.parseInt(st.nextToken());
		}

		d = new int[n];
		d[0] = 1;

		for (int i = 0; i < n - 1; ++i) {
			if (d[i] == 1) {
				for (int j = i + 1; j < n; ++j) {
					if ((j - i) * (1 + Math.abs(arr[i] - arr[j])) <= k)
						d[j] = 1;
				}
			}
		}

		if (d[n - 1] == 0)
			System.out.println("NO");
		else
			System.out.println("YES");

	}

}