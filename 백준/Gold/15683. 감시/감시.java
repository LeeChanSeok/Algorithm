import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

	static class CCTV {
		int num;
		int x, y;

		public CCTV(int num, int x, int y) {
			this.num = num;
			this.x = x;
			this.y = y;
		}
	}

	public static int N, M;
	public static int[][] map;
	public static int totalCnt, max;
	public static int[][][] cctvDir2;

	public static List<CCTV> cctvs;
	public static int[] dx = { 0, 1, 0, -1 };
	public static int[] dy = { 1, 0, -1, 0 };
	public static int[] command = { 4, 2, 4, 4, 1 };

	public static void init() {
		cctvDir2 = new int[][][] { { { 0 }, { 1 }, { 2 }, { 3 } }, { { 0, 2 }, { 1, 3 } },
				{ { 0, 1 }, { 1, 2 }, { 2, 3 }, { 3, 0 } }, { { 0, 1, 2 }, { 1, 2, 3 }, { 2, 3, 0 }, { 3, 0, 1 } },
				{ { 0, 1, 2, 3 } } };
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		init();
		cctvs = new ArrayList<>();

		map = new int[N][M];
		int input;
		totalCnt = N * M;
		for (int i = 0; i < N; i++) {

			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				input = Integer.parseInt(st.nextToken());
				map[i][j] = input;
				if (input == 6)
					totalCnt--;
				else if (input != 0) {
					cctvs.add(new CCTV(input - 1, i, j));
					map[i][j] = 0;
				}
			}

		}

		max = 0;
		dfs(0, 0, map);
		System.out.println(totalCnt - max);

	}

	public static void dfs(int cnt, int res, int[][] map) {
		if (cnt == cctvs.size()) {
			max = Math.max(max, res);
			return;
		}

		int cctvN = cctvs.get(cnt).num;
		int[][] new_map;
		for (int i = 0; i < command[cctvN]; i++) {
			new_map = new int[N][M];
			arrCopy(map, new_map);
			dfs(cnt + 1, res + watch(new_map, cnt, i), new_map);
		}

	}

	public static void arrCopy(int[][] map, int[][] new_map) {
		for (int i = 0; i < N; i++)
			new_map[i] = Arrays.copyOf(map[i], map[i].length);
	}

	public static int watch(int[][] map, int cnt, int dirIdx) {
		int res = 0;

		CCTV cctv = cctvs.get(cnt);
		int[] arr = cctvDir2[cctv.num][dirIdx];
		for (int j = 0, aSize = arr.length; j < aSize; j++) {
			int dir = arr[j];

			int nx = cctv.x, ny = cctv.y;
			do {

				if (nx < 0 || nx >= N || ny < 0 || ny >= M || map[nx][ny] == 6)
					break;

				if (map[nx][ny] == 0) {
					res++;
					map[nx][ny] = -1;
				}

				nx += dx[dir];
				ny += dy[dir];

			} while (true);

		}

		return res;
	}
}