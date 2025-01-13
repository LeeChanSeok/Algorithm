import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

	static class Team implements Comparable<Team> {
		int id, s, c, t;

		public Team(int id) {
			super();
			this.id = id;
		}

		@Override
		public int compareTo(Team o) {
			if (this.s == o.s) {
				if (this.c == o.c) {
					return this.t - o.t;
				}
				return this.c - o.c;
			}
			return o.s - this.s;
		}

	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;

		int T = Integer.parseInt(br.readLine());
		while (T-- > 0) {
			st = new StringTokenizer(br.readLine());

			int n = Integer.parseInt(st.nextToken());
			int k = Integer.parseInt(st.nextToken());
			int id = Integer.parseInt(st.nextToken()) - 1;
			int m = Integer.parseInt(st.nextToken());

			Team[] teams = new Team[n];
			for (int i = 0; i < n; ++i) {
				teams[i] = new Team(i);
			}

			int[][] A = new int[n][k];
			for (int idx = 1; idx <= m; ++idx) {
				st = new StringTokenizer(br.readLine());

				int i = Integer.parseInt(st.nextToken()) - 1;
				int j = Integer.parseInt(st.nextToken()) - 1;
				int s = Integer.parseInt(st.nextToken());

				++teams[i].c;
				teams[i].t = idx;
				if (A[i][j] < s) {
					teams[i].s = teams[i].s - A[i][j] + s;
					A[i][j] = s;
				}

			}
			Arrays.sort(teams);

			int ans = 0;
			for (int i = 0; i < n; ++i) {
				if (teams[i].id == id) {
					ans = i + 1;
					break;
				}
			}
			bw.write(ans + "\n");

		}
		bw.flush();

	}

}