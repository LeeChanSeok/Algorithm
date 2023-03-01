import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	static boolean[][][] visit;
	static char[][] board;
	static int N, M;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		board = new char[N][M];
		for (int i = 0; i < N; ++i) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; ++j)
				board[i][j] = st.nextToken().charAt(0);
		}

		st = new StringTokenizer(br.readLine());
		int[] S = { Integer.parseInt(st.nextToken()) - 1, Integer.parseInt(st.nextToken()) - 1,
				Integer.parseInt(st.nextToken()) - 1 };
		st = new StringTokenizer(br.readLine());
		int[] E = { Integer.parseInt(st.nextToken()) - 1, Integer.parseInt(st.nextToken()) - 1,
				Integer.parseInt(st.nextToken()) - 1 };

		visit = new boolean[N][M][4];
		int answer = bfs(S, E);
		System.out.println(answer);

	}

	private static int bfs(int[] S, int[] E) {
		final int[] dx = { 0, 1, 0, -1 };
		final int[] dy = { 1, 0, -1, 0 };

		if (S[2] == 1) S[2] = 2;
		else if (S[2] == 2) S[2] = 1;

		if (E[2] == 1) E[2] = 2;
		else if (E[2] == 2)	E[2] = 1;

		Queue<int[]> q = new LinkedList<>();
		visit[S[0]][S[1]][S[2]] = true;
		q.offer(S);

		int move = 0;
		while (!q.isEmpty()) {

			int qSize = q.size();
			while (qSize-- > 0) {
				int[] cur = q.poll();
				if (cur[0] == E[0] && cur[1] == E[1] && cur[2] == E[2])
					return move;

				int x = cur[0];	int y = cur[1];	int d = cur[2];
				// 명령 1. Go 1, 2, 3
				for (int i = 1; i <= 3; ++i) {
					int nx = x + dx[d] * i;
					int ny = y + dy[d] * i;

					if (nx < 0 || nx >= N || ny < 0 || ny >= M || board[nx][ny] == '1')	break;
					if (visit[nx][ny][d]) continue;

					visit[nx][ny][d] = true;
					q.offer(new int[] { nx, ny, d });
				}

				// 명령 2. turn L, R;
				int nd = turn(d, 1);
				if (board[x][y] != '1' && !visit[x][y][nd]) {
					visit[x][y][nd] = true;
					q.offer(new int[] { x, y, nd });
				}

				nd = turn(d, -1);
				if (board[x][y] != '1' && !visit[x][y][nd]) {
					visit[x][y][nd] = true;
					q.offer(new int[] { x, y, nd });
				}

			}
			++move;
		}

		return 0;
	}

	private static int turn(int d, int i) {
		return (d + 4 + i) % 4;
	}

}
