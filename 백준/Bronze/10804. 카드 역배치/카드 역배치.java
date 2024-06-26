import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	static int[] arr;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;

		int n = 20;
		int m = 10;
		
		arr = new int[n + 1];
		for (int i = 1; i <= n; ++i) {
			arr[i] = i;
		}

		for (int i = 0; i < m; ++i) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());

			reverse(a, b);
		}

		for (int i = 1; i <= n; ++i) {
			sb.append(arr[i] + " ");
		}

		System.out.println(sb);

	}

	private static void reverse(int l, int r) {

		while (l < r) {
			int temp = arr[l];
			arr[l] = arr[r];
			arr[r] = temp;

			l++;
			r--;

		}

	}

}