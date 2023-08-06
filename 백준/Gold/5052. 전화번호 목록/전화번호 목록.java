import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
	static int N;
	static String[] num;

	public static void main(String[] args) throws Exception {
		int T = Integer.parseInt(br.readLine());
		while (T-- > 0) {
			input();
			pro();
		}
		System.out.println(sb);
	}

	private static void pro() {

		Arrays.sort(num);
		String prev = num[0];
		for (int i = 1; i < N; ++i) {
			String now = num[i];

			if (now.startsWith(prev)) {
				sb.append("NO\n");
				return;
			}
			prev = now;
		}

		sb.append("YES\n");

	}

	private static void input() throws Exception {

		N = Integer.parseInt(br.readLine());

		num = new String[N];

		for (int i = 0; i < N; ++i)
			num[i] = br.readLine();

	}

}