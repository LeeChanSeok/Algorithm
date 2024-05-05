import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int n = Integer.parseInt(st.nextToken());
		int d = Integer.parseInt(st.nextToken());

		int ans = 0;
		for (int i = 1; i <= n; ++i) {
			int num = i;
			while (num != 0) {
				if (num % 10 == d)
					++ans;
				num /= 10;
			}
		}

		System.out.println(ans);

	}

}