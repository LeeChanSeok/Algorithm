import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());

		char[] arr = br.readLine().toCharArray();
		boolean[] visited = new boolean[N];

		int cnt = 0;
		for (int i = 0; i < N; ++i) {
			if (arr[i] != 'P')
				continue;
			for (int j = Math.max(0, i - K); j <= Math.min(N - 1, i + K); ++j) {
				if (arr[j] == 'H' && !visited[j]) {
					visited[j] = true;
					++cnt;
					break;
				}
			}
		}

		System.out.println(cnt);

	}

}