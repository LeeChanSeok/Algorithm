import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		char[] str = br.readLine().toCharArray();
		int len = str.length;
		int K = Integer.parseInt(br.readLine());

		int ans = 0;
		int conf = len - K;
		for (int i = 0; i < conf; ++i) {
			int sum = 0;
			int max = 0;
			int[] cnt = new int['z' - 'a' + 1];

			for (int j = i; j < len; j += conf) {
				sum++;
				max = Math.max(max, ++cnt[str[j] - 'a']);
			}

			ans += (sum - max);
		}

		System.out.println(ans);
	}

}