import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	static class Info {
		int pos1;
		int pos2;

		public Info(int pos1, int pos2) {
			super();
			this.pos1 = pos1;
			this.pos2 = pos2;
		}

	}

	static final int DELTA = 20;

	static final int[] dx = { -1, 1, 0, 0 };
	static final int[] dy = { 0, 0, -1, 1 };

	static int N, M;
	static char[][] board;
	static boolean[][] visited;

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		board = new char[N][M];
		visited = new boolean[DELTA*DELTA][DELTA*DELTA];

		for (int i = 0; i < N; ++i) {
			board[i] = br.readLine().toCharArray();
		}

		List<Integer> oPos = new ArrayList<>(2);
		for (int i = 0; i < N; ++i) {
			for (int j = 0; j < M; ++j) {
				if (board[i][j] == 'o') {
					board[i][j] = '.';
					oPos.add(i * DELTA + j);
				}
			}
		}

		Info info = new Info(oPos.get(0), oPos.get(1));
		System.out.println(solution(info));

	}

	private static int solution(Info info) {

		Queue<Info> q = new LinkedList<>();
		q.offer(info);
		
		int pos1 = info.pos1;
		int pos2 = info.pos2;

		visited[pos1][pos2] = true;

		int qSize;
		int move = 0;
		Info cur;
		int x1, y1, x2, y2;
		int nx1, ny1, nx2, ny2;
		boolean isFall1 = false, isFall2 = false;
		int nPos1, nPos2;

		while (!q.isEmpty()) {
			if(move == 10) break;
			
			qSize = q.size();
			
			while (qSize-- > 0) {
				cur = q.poll();
				pos1 = cur.pos1;
				pos2 = cur.pos2;

				x1 = pos1 / DELTA;
				y1 = pos1 % DELTA;
				x2 = pos2 / DELTA;
				y2 = pos2 % DELTA;

				for (int d = 0; d < 4; ++d) {
					isFall1 = false;
					isFall2 = false;
					
					nx1 = x1 + dx[d];
					ny1 = y1 + dy[d];
					nx2 = x2 + dx[d];
					ny2 = y2 + dy[d];

					if (nx1 < 0 || nx1 >= N || ny1 < 0 || ny1 >= M) isFall1 = true;
					if (nx2 < 0 || nx2 >= N || ny2 < 0 || ny2 >= M)	isFall2 = true;

					if (isFall1 ^ isFall2) return move + 1;
					else if (isFall1 & isFall2)	continue;

					
					if(board[nx1][ny1] == '#'){
						nx1 = x1; ny1 = y1;
					}
					if(board[nx2][ny2] == '#'){
						nx2 = x2; ny2 = y2;
					}
					nPos1 = nx1 * DELTA + ny1;
					nPos2 = nx2 * DELTA + ny2;
					if (visited[nPos1][nPos2]) continue;
					
					visited[nPos1][nPos2] = true;
					q.offer(new Info(nPos1, nPos2));

				}

			}

			++move;

		}

		return -1;
	}

}