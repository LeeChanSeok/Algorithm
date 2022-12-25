import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	
	static class Point{
		int x, y;

		public Point(int x, int y) {
			super();
			this.x = x;
			this.y = y;
		}
		
	}
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		Point sang, king;
		
		st = new StringTokenizer(br.readLine());
		sang = new Point(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
		
		st = new StringTokenizer(br.readLine());
		king = new Point(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
		
		System.out.println(bfs(sang, king));
		
	}

	private static int bfs(Point sang, Point king) {
		int[] dx = {-1, 1, 0, 0};
		int[] dy = {0, 0, -1, 1};
		
		final int R = 10, C = 9;
		
		int move = 0;
		
		boolean[][] visit = new boolean[R][C];
		visit[sang.x][sang.y] = true;
		
		Queue<Point> q = new LinkedList<>();
		q.offer(sang);
		
		Point cur;
		int qSize, x, y, nx, ny;
		while(!q.isEmpty()) {
			qSize = q.size();
			while(qSize-- > 0) {
				
				cur = q.poll();
				
				x = cur.x; y = cur.y;
				
				if(x == king.x && y == king.y) return move;
				
				for(int d = 0; d < 4; ++d) {
					// 1. 
					nx = x + dx[d];
					ny = y + dy[d];
					
					if(nx < 0 || nx >= R || ny < 0 || ny >= C || (nx == king.x && ny == king.y)) continue;
					
					// 2 - 1.
					boolean isPut = true;
					nx = nx + dx[d] + dy[d];
					ny = ny + dx[d] + dy[d];
					if(nx < 0 || nx >= R || ny < 0 || ny >= C  || (nx == king.x && ny == king.y)) isPut = false;
					
					nx = nx + dx[d] + dy[d];
					ny = ny + dx[d] + dy[d];
					if(nx < 0 || nx >= R || ny < 0 || ny >= C) isPut = false;
					
					if(isPut && !visit[nx][ny]) {
						if(nx == king.x && ny == king.y) return move+1;
						visit[nx][ny] = true;
						q.offer(new Point(nx, ny));
					}
					
					// 2 - 2.
					nx = x + dx[d];
					ny = y + dy[d];
					
					isPut = true;
					nx = nx + dx[d] - dy[d];
					ny = ny - dx[d] + dy[d];
					if(nx < 0 || nx >= R || ny < 0 || ny >= C  || (nx == king.x && ny == king.y)) isPut = false;
					
					nx = nx + dx[d] - dy[d];
					ny = ny - dx[d] + dy[d];
					if(nx < 0 || nx >= R || ny < 0 || ny >= C) isPut = false;
					
					if(isPut && !visit[nx][ny]) {
						if(nx == king.x && ny == king.y) return move+1;
						visit[nx][ny] = true;
						q.offer(new Point(nx, ny));
					}
					
				}
				
			}
			
			++move;
		}
		return -1;
	}
	
}