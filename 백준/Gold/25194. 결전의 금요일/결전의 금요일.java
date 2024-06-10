import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	static int[] cnt = new int[7];

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int n = Integer.parseInt(br.readLine());

		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < n; ++i) {
			int num = Integer.parseInt(st.nextToken());
			++cnt[num % 7];
		}

		String ans = "NO";
		if (recursive(0))
			ans = "YES";

		System.out.println(ans);
	}

	private static boolean recursive(int v) {

		if (cnt[(11 - v) % 7] != 0)
			return true;

		for (int i = 1; i < 7; ++i) {
			if (cnt[i] != 0) {
				--cnt[i];
				if (recursive((v + i) % 7))
					return true;
				++cnt[i];
			}
		}

		return false;
	}

}