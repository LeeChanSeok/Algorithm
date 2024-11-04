import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();

		int T = Integer.parseInt(br.readLine());
		while (T-- > 0) {

			int N = Integer.parseInt(br.readLine());
			int[] arr = new int[N];
			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < N; ++i) {
				arr[i] = Integer.parseInt(st.nextToken());
			}

			int cnt = 0;
			for (int i = N - 1; i > 0; --i) {
				for (int j = 0; j < i; ++j) {
					if (arr[j] > arr[j + 1]) {
						int tmp = arr[j];
						arr[j] = arr[j + 1];
						arr[j + 1] = tmp;
						++cnt;
					}
				}
			}
			sb.append(cnt).append('\n');
		}

		System.out.println(sb);

	}

}