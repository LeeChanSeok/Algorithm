import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	static final int[] dx = {-1, 1, 0, 0};
	static final int[] dy = {0, 0, -1, 1};
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		boolean[][] board = new boolean[N][M];
		boolean[][] visit = new boolean[N][M];
		
		for(int i = 0; i < N; ++i) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < M; ++j) {
				board[i][j] = (st.nextToken().charAt(0) == '1') ? true : false;
			}
		}
		
		int cnt = 0, max = 0;
		for(int i = 0; i < N; ++i) {
			for(int j = 0; j < M; ++j) {
				if(!board[i][j] || visit[i][j]) continue;
				
				++cnt;
				max = Math.max(max, bfs(i, j, N, M, board, visit));
			}
		}
		System.out.println(cnt);
		System.out.println(max);
	}

	private static int bfs(int i, int j, int N, int M, boolean[][] board, boolean[][] visit) {

		Queue<int[]> q = new LinkedList<>();
		q.offer(new int[] {i, j});
		visit[i][j] = true;
		
		int cnt = 1;
		int[] cur;
		int x, y, nx, ny;
		while(!q.isEmpty()) {
			cur = q.poll();
			x = cur[0]; y = cur[1];
			
			for(int d = 0; d < 4; ++d) {
				nx = x + dx[d];
				ny = y + dy[d];
				
				if(nx < 0 || nx >= N || ny < 0 || ny >=M || visit[nx][ny] || !board[nx][ny]) continue;
				q.offer(new int[] {nx, ny});
				visit[nx][ny] = true;
				++cnt;
			}
		}
		return cnt;
	}

}