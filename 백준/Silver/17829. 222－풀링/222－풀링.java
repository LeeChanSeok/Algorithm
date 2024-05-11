import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

	static int[][] arr;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int n = Integer.parseInt(br.readLine());

		arr = new int[n][n];
		for (int i = 0; i < n; ++i) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < n; ++j) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		System.out.println(recursive(0, 0, n / 2));
	}

	private static int recursive(int i, int j, int n) {

		if (n == 0)
			return arr[i][j];

		int[] num = new int[4];
		num[0] = recursive(i, j, n / 2);
		num[1] = recursive(i, j + n, n / 2);
		num[2] = recursive(i + n, j, n / 2);
		num[3] = recursive(i + n, j + n, n / 2);

		Arrays.sort(num);

		return num[2];

	}

}