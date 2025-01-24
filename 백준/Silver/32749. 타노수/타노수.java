import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	static String x, ans;
	static int N, T;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		T = Integer.parseInt(st.nextToken());

		ans = "0";
		x = br.readLine();

		recursive(0, (int) Math.pow(2, N) - 1, T);
		System.out.println(ans);
	}

	private static void recursive(int l, int r, int t) {

		if (t == 0) {
			String tmp = x.substring(l, r + 1);
			if (ans.compareTo(tmp) < 0)
				ans = tmp;
			return;
		}

		int mid = (l + r) / 2;
		recursive(l, mid, t - 1);
		recursive(mid + 1, r, t - 1);

	}

}