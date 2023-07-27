import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

	static int n;
	static int[][] arr;
	static int[] A, B;

	public static void main(String[] args) throws NumberFormatException, IOException {
		input();
		pro();

	}

	private static void pro() {

		for (int i = 0; i < n; ++i) {
			for (int j = 0; j < n; ++j) {
				A[n * i + j] = arr[i][0] + arr[j][1];
			}
		}

		for (int i = 0; i < n; ++i) {
			for (int j = 0; j < n; ++j) {
				B[n * i + j] = arr[i][2] + arr[j][3];
			}
		}

		Arrays.sort(A);
		Arrays.sort(B);

		long ans = 0;
		for (int i = 0, end = n * n; i <end; ++i){

			int target = -A[i];
			int upper = upperBound(target);
			int lower = lowerBound(target);
			ans += upper - lower;
		}

		System.out.println(ans);
	}

	private static int upperBound(int target) {
		int l = 0, r = n * n;
		while (l < r) {
			int mid = (l + r) / 2;

			if (B[mid] <= target) {
				l = mid + 1;
			}
			else {
				r = mid;
			}

		}

		return r;
	}

	private static int lowerBound(int target) {

		int l = 0, r = n * n;
		while (l < r) {
			int mid = (l + r) / 2;

			if (B[mid] >= target) {
				r = mid;
			}
			else {
				l = mid + 1;
			}

		}

		return r;
	}
	
	private static void input() throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		n = Integer.parseInt(br.readLine());

		arr = new int[n][4];
		for (int i = 0; i < n; ++i) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < 4; ++j) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		A = new int[n * n];
		B = new int[n * n];

	}

}