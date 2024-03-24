import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;

		int n = Integer.parseInt(br.readLine());
		int[] cnt = new int[n + 1];

		for (int i = 1; i < n; ++i) {
			st = new StringTokenizer(br.readLine());

			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());

			++cnt[a];
			++cnt[b];
		}

		int m = Integer.parseInt(br.readLine());
		for (int i = 0; i < m; ++i) {
			st = new StringTokenizer(br.readLine());

			int t = Integer.parseInt(st.nextToken());
			int k = Integer.parseInt(st.nextToken());

			if (t == 2)
				sb.append("yes\n");
			else {
				if (cnt[k] >= 2)
					sb.append("yes\n");
				else
					sb.append("no\n");
			}

		}

		System.out.println(sb);
	}

}