import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {

	public static int move(int[][] map, int[][] memoiz, int N, int x, int y) {
		int[] dx = { -1, 0, 1, 0 };
		int[] dy = { 0, 1, 0, -1 };
		int nx, ny;
		int res = 0;
		
		if(memoiz[x][y] != 0) return memoiz[x][y];

		for (int d = 0; d < dx.length; d++) {
			nx = x + dx[d];
			ny = y + dy[d];
			if (nx < 0 || nx >= N || ny < 0 || ny >= N || (map[nx][ny] - map[x][y]) != 1)
				continue;

			memoiz[x][y] += move(map, memoiz, N, nx, ny);
			break;
		}
		
		return ++memoiz[x][y];
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int T = Integer.parseInt(br.readLine());
		int[][] map, memoiz;
		boolean[][] visit;
		int ans_x, ans_y, max, res;

		for (int tc = 1; tc <= T; tc++) {
			int N = Integer.parseInt(br.readLine());
			map = new int[N][N];
			memoiz = new int[N][N];
			visit = new boolean[N][N];

			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < N; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			max = 0;
			ans_x = N*N; ans_y = N*N;
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					res = move(map, memoiz, N, i, j);
					if(res > max) {
						max = res;
						ans_x = i; ans_y = j;
					}else if(res == max && map[i][j] < map[ans_x][ans_y]) {
						ans_x = i; ans_y = j;
					}
				}
			}
			System.out.printf("#%d %d %d\n",tc, map[ans_x][ans_y], max);
		} // test-case end
	}
}