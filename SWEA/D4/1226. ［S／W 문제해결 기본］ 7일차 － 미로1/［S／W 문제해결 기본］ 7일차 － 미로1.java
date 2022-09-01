import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;

public class Solution {
	static class Point{
		int x, y;

		public Point(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}
	
	static final int N = 16;
	static char[][] maze = new char[N][N];
	static final int[] dx = {0, 1, 0, -1};
	static final int[] dy = {1, 0, -1, 0};
	static Queue<Point> q;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
				
		int T = 10;
		for(int tc = 1; tc<=T; tc++) {
			br.readLine();
			for(int i = 0; i< N; i++)
				maze[i] = br.readLine().toCharArray();

			q = new ArrayDeque<>();
			for(int i = 0; i < N; i++) {
				for(int j = 0; j < N; j++) {
					if(maze[i][j] == '2') {
						q.offer(new Point(i, j));
						break;
					}
				}
			}
			System.out.println("#" + tc + " " + solution());
		}
	}
	private static int solution() {

		while(!q.isEmpty()) {
			Point cur = q.poll();
			
			for(int d = 0; d < 4; d++) {
				int nx = cur.x + dx[d];
				int ny = cur.y + dy[d];
				
				if(maze[nx][ny] == '3') {
					return 1;
				}else if(maze[nx][ny] == '0') {
					q.offer(new Point(nx, ny));
					maze[nx][ny] = '1';
				}
			}
		}
		
		return 0;
		
	}

}