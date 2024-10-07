import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int N = Integer.parseInt(br.readLine());

		int[][] arr = new int[N + 1][6];
		for (int i = 1; i <= N; ++i) {
			st = new StringTokenizer(br.readLine());
			for (int j = 1; j <= 5; ++j) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		Set<Integer>[] set = new Set[N + 1];
		for (int i = 1; i <= N; ++i) {
			set[i] = new HashSet<>();
		}

		for (int i = 1; i <= N; ++i) {

			for (int j = 1; j <= 5; ++j) {
				int num = arr[i][j];
				for (int k = i; k <= N; ++k) {
					if (arr[k][j] == num) {
						set[i].add(k);
						set[k].add(i);
					}
				}
			}
		}

		int max = 0;
		int ans = 0;
		for (int i = 1; i <= N; ++i) {
			int size = set[i].size();
			if (size > max) {
				max = size;
				ans = i;
			}
		}

		System.out.println(ans);

	}

}