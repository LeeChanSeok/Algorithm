import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Main {
	
	static class Point{
		int x, y;

		public Point(int x, int y) {
			super();
			this.x = x;
			this.y = y;
		}
		
	}
	
	static int[] dx = {-1, 1, 0, 0};
	static int[] dy = {0, 0, -1, 1};

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = 12, M = 6;
		char[][] board = new char[N][M];
		for(int i = 0; i < N; ++i)
			board[i] = br.readLine().toCharArray();
		
		
		int answer = 0;
		boolean isDo =true;
		boolean[][] visit;
		while(isDo) {
			isDo = false;
			
			// 1. 터트리기
			visit = new boolean[N][M];
			for(int i = 0; i < N; ++i) {
				for(int j = 0; j < M; ++j) {
					if(board[i][j] == '.' || visit[i][j]) continue;
					if(bfs(i, j, N, M, board, visit)) isDo = true;
				}
			}
			
			if(!isDo) break;
			
			// 2. 중력
			gravity(N, M, board);
			++answer;
			
		}
		
		System.out.println(answer);
		
	}

	private static void gravity(int N, int M, char[][] board) {

		int i , k;
		for(int j = 0; j < M; ++j) {
			
			i = k = N - 1;
			
			while(i > 0 && k >= 0) {
				while(i > 0 && board[i][j] !='.') --i;
				if(i <= 0) break;
				
				k = Math.min(i, k) - 1;
				
				while(k >= 0 && board[k][j] == '.' ) --k;
				if(k < 0) break;
				
				board[i][j] = board[k][j];
				board[k][j] = '.';
				--i;
			}
		}
		
	}

	private static boolean bfs(int i, int j, int N, int M, char[][] board, boolean[][] visit) {

		Queue<Point> q = new LinkedList<>();
		List<Point> block = new LinkedList<>();
		char color = board[i][j];
		
		int cnt = 1;
		visit[i][j] = true;
		Point cur, next;
		cur = new Point(i, j);
		q.offer(cur);
		block.add(cur);
		
		q.offer(cur);
		q.offer(cur);
		int nx, ny;
		while(!q.isEmpty()) {
			
			cur = q.poll();
			
			for(int d = 0; d < 4; ++d) {
				nx = cur.x + dx[d];
				ny = cur.y + dy[d];
				
				if(nx < 0 || nx >= N || ny < 0 || ny >= M || visit[nx][ny] || board[nx][ny] != color) continue;
				
				next = new Point(nx, ny);
				q.offer(next);
				block.add(next);
				++cnt;
				visit[nx][ny] = true;
			}
		}
		
		if(cnt >= 4) {
			for(Point pnt : block) {
				board[pnt.x][pnt.y] = '.';
			}
			return true;
		}
		
		return false;
	}

}