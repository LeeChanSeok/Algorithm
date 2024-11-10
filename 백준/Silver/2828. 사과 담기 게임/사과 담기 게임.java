import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());

		int K = Integer.parseInt(br.readLine());

		int ans = 0;
		int idx = 1;
		int move = 0;
		for (int i = 0; i < K; ++i) {
			int pos = Integer.parseInt(br.readLine());

			if (pos < idx) {
				move = idx - pos;
				ans += move;
				idx = pos;
			} else if (pos > idx + M - 1) {
				move = pos - (idx + M - 1);
				ans += move;
				idx += move;
			}
		}

		System.out.println(ans);

	}

}