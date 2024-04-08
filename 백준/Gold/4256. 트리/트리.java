import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	static StringBuilder sb;
	static int[] pre, in;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		sb = new StringBuilder();
		int t = Integer.parseInt(br.readLine());

		while (t-- > 0) {
			int n = Integer.parseInt(br.readLine());

			pre = new int[n];
			in = new int[n];

			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < n; ++i) {
				pre[i] = Integer.parseInt(st.nextToken());
			}

			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < n; ++i) {
				in[i] = Integer.parseInt(st.nextToken());
			}

			post(0, n, 0);
			sb.append('\n');
		}

		System.out.println(sb);
	}

	private static void post(int s, int e, int pos) {

		for (int i = s; i < e; ++i) {
			if (pre[pos] == in[i]) {
				post(s, i, pos + 1);
				post(i + 1, e, pos + 1 + i - s);

				sb.append(pre[pos] + " ");
			}
		}

	}

}