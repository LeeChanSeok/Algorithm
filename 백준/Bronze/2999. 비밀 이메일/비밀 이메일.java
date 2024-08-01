import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		String str = br.readLine();
		int N = str.length();

		int R = 0, C = N - 1;
		for (int i = 1; i <= Math.sqrt(N); ++i) {
			if (N % i != 0)
				continue;
			R = i;
			C = N / R;
		}

		int idx = 0;
		char[][] arr = new char[R][C];
		for (int j = 0; j < C; ++j) {
			for (int i = 0; i < R; ++i) {
				arr[i][j] = str.charAt(idx++);
			}
		}

		for (int i = 0; i < R; ++i) {
			for (int j = 0; j < C; ++j) {
				sb.append(arr[i][j]);
			}
		}

		System.out.println(sb);
	}

}