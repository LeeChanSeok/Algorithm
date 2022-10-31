import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	static class Ice{
		int x, y;

		public Ice(int x, int y) {
			super();
			this.x = x;
			this.y = y;
		}
		
	}
	
	static int[] dx = {-1, 1, 0 ,0};
	static int[] dy = {0 ,0, -1, 1};
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		List<Ice> ices = new LinkedList<>();
		
		int[][] board = new int[N][M];
		int[][] nextBoard = new int[N][M];
		
		int h, iceCnt=0;
		for(int i = 0; i < N; ++i) {
			st = new StringTokenizer(br.readLine());
			
			for(int j = 0; j < M; ++j) {
				h = Integer.parseInt(st.nextToken());
				board[i][j] = h;
				
				if(h != 0) ++iceCnt;
			}
		}
		
		int time = 0;
		int group;
		
		boolean isDivide = false;
		while(true) {
			if(iceCnt == 0) break;
			
			// 분리되었는지 확인한다.
			group = makeGroup(N, M, board);
			
			if(group != iceCnt) {
				isDivide = true;
				break;
			}
			
			// 빙산 주변 얼음 수 찾기
			iceCnt -= meltIce(N, M, board, nextBoard);
			
			++time;
		}
		
		if(!isDivide) time = 0;
		System.out.println(time);
		
	}

	private static int meltIce(int N, int M, int[][] board, int[][] nextBoard) {

		for(int i = 0; i < N; ++i)
			nextBoard[i] = board[i].clone();
		
		int melt = 0;
		int water, nx, ny;
		for(int i = 0; i < N; ++i) {
			for(int j = 0; j < M; ++j) {
				if(board[i][j] == 0) continue;
				
				water = 0;
				for(int d = 0; d < 4; ++d) {
					nx = i + dx[d];
					ny = j + dy[d];
					if(nx < 0 || nx >= N || ny < 0 || ny >= M || board[nx][ny] != 0) continue;
					++water;
				}
				nextBoard[i][j] = Math.max(nextBoard[i][j] - water, 0);
				if(nextBoard[i][j] == 0) ++melt;
			}
		}
		
		for(int i = 0; i < N; ++i)
			board[i] = nextBoard[i].clone();
		
		return melt;
	}

	private static int makeGroup(int N, int M, int[][] board) {
		for(int i = 0; i < N; ++i) {
			for(int j = 0; j < M; ++j) {
				if(board[i][j] != 0) return bfs(i, j, N, M, board);
			}
		}
		return 0;
	}

	private static int bfs(int x, int y, int N, int M, int[][] board) {
		
		Queue<Ice> q = new LinkedList<>();
		boolean[][] visit = new boolean[N][M];
		Ice cur;
		int nx, ny;
		q.offer(new Ice(x, y));
		visit[x][y] = true;
		
		int cnt = 1;
		
		while(!q.isEmpty()) {
			cur = q.poll();
			
			for(int d = 0; d < 4; ++d) {
				nx = cur.x + dx[d];
				ny = cur.y + dy[d];
				
				if(nx < 0 || nx >= N || ny < 0 || ny >= M || visit[nx][ny] || board[nx][ny] == 0) continue;
				
				q.offer(new Ice(nx, ny));
				visit[nx][ny] = true;
				++cnt;
			}
		}
		
		return cnt;
	}

}