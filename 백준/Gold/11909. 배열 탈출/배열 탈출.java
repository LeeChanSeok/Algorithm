import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	static int N;
	static int[][] arr;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		N = Integer.parseInt(br.readLine());
		arr = new int[N + 1][N + 1];

		for (int i = 1; i <= N; ++i) {
			st = new StringTokenizer(br.readLine());
			for (int j = 1; j <= N; ++j) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		int[][] D = new int[N + 1][N + 1];

		for (int i = 2; i <= N; ++i) {
			D[i][1] = D[i - 1][1] + Math.max(0, arr[i][1] - arr[i - 1][1] + 1);
		}
		for (int j = 2; j <= N; ++j) {
			D[1][j] = D[1][j - 1] + Math.max(0, arr[1][j] - arr[1][j - 1] + 1);
		}

		for (int i = 2; i <= N; ++i) {
			for (int j = 2; j <= N; ++j) {
				D[i][j] = Math.min(D[i - 1][j] + Math.max(0, arr[i][j] - arr[i - 1][j] + 1),
						D[i][j - 1] + Math.max(0, arr[i][j] - arr[i][j - 1] + 1));
			}
		}

		System.out.println(D[N][N]);
	}

}