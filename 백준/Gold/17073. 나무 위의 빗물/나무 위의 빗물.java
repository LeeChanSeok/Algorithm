import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int n = Integer.parseInt(st.nextToken());
		int w = Integer.parseInt(st.nextToken());

		int[] cnt = new int[n + 1];
		for (int i = 0; i < n - 1; ++i) {
			st = new StringTokenizer(br.readLine());

			int u = Integer.parseInt(st.nextToken());
			int v = Integer.parseInt(st.nextToken());

			++cnt[u];
			++cnt[v];
		}

		int leaf = 0;
		for (int i = 2; i <= n; ++i) {
			if (cnt[i] == 1)
				++leaf;
		}

		System.out.println((double) w / leaf);

	}

}