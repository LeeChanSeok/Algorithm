import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

	static int[][] dQ = { { -1, 0 }, { -1, 1 }, { 0, 1 }, { 1, 1 }, { 1, 0 }, { 1, -1 }, { 0, -1 }, { -1, -1 } };
	static int[][] dK = { { -2, 1 }, { -1, 2 }, { 1, 2 }, { 2, 1 }, { 2, -1 }, { 1, -2 }, { -1, -2 }, { -2, -1 } };

	static int n, m;
	static boolean[][] board;
	static boolean[][] visited;

	static List<int[]> q, k;

	public static void main(String[] args) throws Exception {
		input();
		pro();
	}

	private static void pro() {

		qMove();
		kMove();
		calc();
	}

	private static void calc() {

		int ans = 0;
		for(int i = 1; i <= n; ++i) {
			for(int j = 1; j <= m; ++j) {
				if(!visited[i][j]) ++ ans;
			}
		}
		
		System.out.println(ans);
	}

	private static void qMove() {

		for (int[] qPos : q) {
			int x = qPos[0];
			int y = qPos[1];

			for (int d = 0; d < 8; ++d) {
				int nx = x;
				int ny = y;
				while (true) {
					nx += dQ[d][0];
					ny += dQ[d][1];
					if (nx <= 0 || nx > n || ny <= 0 || ny > m) break;		
					if(board[nx][ny]) break;
					visited[nx][ny] = true;
				}
			}
		}
	}

	private static void kMove() {

		for (int[] kPos : k) {
			int x = kPos[0];
			int y = kPos[1];
			
			for (int d = 0; d < 8; ++d) {
				int nx = x + dK[d][0];
				int ny = y + dK[d][1];
				if (nx <= 0 || nx > n || ny <= 0 || ny > m) continue;
				if(board[nx][ny]) continue;
				visited[nx][ny] = true;
			}
		}
	}

	private static void input() throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());

		board = new boolean[n + 1][m + 1];
		visited = new boolean[n + 1][m + 1];

		q = new LinkedList<>();

		st = new StringTokenizer(br.readLine());
		int cnt = Integer.parseInt(st.nextToken());
		for (int j = 1; j <= cnt; ++j) {
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			q.add(new int[] { x, y });
			board[x][y] = visited[x][y] = true;
		}

		k = new LinkedList<>();

		st = new StringTokenizer(br.readLine());
		cnt = Integer.parseInt(st.nextToken());
		for (int j = 1; j <= cnt; ++j) {
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			k.add(new int[] { x, y });
			board[x][y] = visited[x][y] = true;
		}

		st = new StringTokenizer(br.readLine());
		cnt = Integer.parseInt(st.nextToken());
		for (int j = 1; j <= cnt; ++j) {
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			board[x][y] = visited[x][y] = true;
		}

	}

}