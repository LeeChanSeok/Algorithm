import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Solution {
	static int N, max;
	static int map[][];
	static boolean[] visit;

	static int sx, sy;
	static int[] dx = { 1, 1, -1, -1 };
	static int[] dy = { 1, -1, -1, 1 };

	static int test;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuffer sb = new StringBuffer();
		StringTokenizer st;

		int T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= T; tc++) {
			N = Integer.parseInt(br.readLine());

			map = new int[N][N];
			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < N; j++)
					map[i][j] = Integer.parseInt(st.nextToken());
			}

			test = tc;
			max = -1;
			visit = new boolean[101];
			for (int i = 0; i < N - 1; i++) {
				for (int j = 1; j < N - 1; j++) {
					if (i == 0 && j == 0)	continue;

					sx = i;
					sy = j;
					dfs(i, j, 1, 0);
				}
			}

			sb.append("#" + tc + " " + max + "\n");

		} // test-case 종료

		bw.write(sb.toString());
		bw.close();

	}

	private static void dfs(int x, int y, int level, int d) {
		visit[map[x][y]] = true;

		int nx, ny;
		// 직진 판단
		nx = x + dx[d];
		ny = y + dy[d];
		if (nx < 0 || nx >= N || ny < 0 || ny >= N);
		else {
			if (d == 3) {
				if (level >=4 && nx == sx && ny == sy) {
					max = Math.max(max, level);
					visit[map[x][y]] = false;
					return;
				}
			}

			if (!visit[map[nx][ny]])
				dfs(nx, ny, level + 1, d);
		}

		// 회전 판단
		if(d < 3)
			dfs(x, y, level, d + 1);
		
		visit[map[x][y]] = false;
	}

}