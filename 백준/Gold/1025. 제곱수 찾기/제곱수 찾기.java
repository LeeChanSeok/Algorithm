import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Set;
import java.util.StringTokenizer;
import java.util.TreeSet;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());

		char[][] arr = new char[N][M];
		for (int i = 0; i < N; ++i) {
			arr[i] = br.readLine().toCharArray();
		}

		Set<Integer> set = new TreeSet<>((s1, s2) -> {
			return s2 - s1;
		});

		for (int i = 0; i < N; ++i) {
			for (int j = 0; j < M; ++j) {

				for (int ii = -N; ii < N; ++ii) {
					for (int jj = -M; jj < M; ++jj) {
						if (ii == 0 && jj == 0)
							continue;

						StringBuilder sb = new StringBuilder();
						int iii = i;
						int jjj = j;

						while (iii >= 0 && iii < N && jjj >= 0 && jjj < M) {
							sb.append((arr[iii][jjj] - '0'));
							set.add(Integer.parseInt(sb.toString()));
							iii += ii;
							jjj += jj;
						}
					}
				}

			}
		}

		int ans = -1;
		for (int n : set) {

			double squareRoot = Math.sqrt(n);
			int tst = (int) (squareRoot + 0.5);

			if (n == tst * tst) {
				ans = n;
				break;
			}
		}

		System.out.println(ans);

	}

}