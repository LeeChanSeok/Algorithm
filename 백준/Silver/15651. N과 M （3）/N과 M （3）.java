import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static void permutation(int N, int M, int[] pick, int cnt, StringBuffer sb) {
		if (cnt == M) {
			for (int i = 0; i < M; i++) sb.append(pick[i]).append(" ");
			sb.append("\n");
			return;
		}

		for (int i = 1; i <= N; i++) {
			pick[cnt] = i;
			permutation(N, M, pick, cnt + 1, sb);
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuffer sb = new StringBuffer();

		String[] input = br.readLine().toString().split(" ");
		int N = Integer.parseInt(input[0]);
		int M = Integer.parseInt(input[1]);

		int[] pick = new int[M];
		boolean[] flag = new boolean[N + 1];
		permutation(N, M, pick, 0, sb);
		System.out.println(sb.toString());
	}
}
