import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());

		char[][] arr = new char[n][m];
		for (int i = 0; i < n; ++i) {
			arr[i] = br.readLine().toCharArray();
		}

		int[][] cnt = new int[4][m];
		for (int i = 0; i < n; ++i) {
			for (int j = 0; j < m; ++j) {

				if (arr[i][j] == 'A')
					++cnt[0][j];
				else if (arr[i][j] == 'C')
					++cnt[1][j];
				else if (arr[i][j] == 'G')
					++cnt[2][j];
				else if (arr[i][j] == 'T')
					++cnt[3][j];
			}
		}

		int ans = 0;
		String str = "";
		for (int i = 0; i < m; ++i) {
			char c = 'A';
			int max = cnt[0][i];
			for (int j = 1; j < 4; ++j) {
				if (cnt[j][i] > max) {
					max = cnt[j][i];

					if (j == 1)
						c = 'C';
					else if (j == 2)
						c = 'G';
					else if (j == 3)
						c = 'T';
				}
			}

			ans += (n - max);
			str += c;
		}

		System.out.println(str);
		System.out.println(ans);
	}

}