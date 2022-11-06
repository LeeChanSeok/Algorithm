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
				
		int N = Integer.parseInt(br.readLine());
		
		st = new StringTokenizer(br.readLine());
		int r1 = Integer.parseInt(st.nextToken());
		int c1 = Integer.parseInt(st.nextToken());
		int r2 = Integer.parseInt(st.nextToken());
		int c2 = Integer.parseInt(st.nextToken());
		
		System.out.println(solution(r1, c1, r2, c2, N));
		
	}

	private static int solution(int r1, int c1, int r2, int c2, int N) {
		
		int[] dx = {-2, -2, 0, 0, 2, 2};
		int[] dy = {-1, 1, -2, 2, -1, 1};

		Queue<Point> q = new LinkedList<>();
		
		boolean[][] visit = new boolean[N][N];
		q.offer(new Point(r1, c1));
		visit[r1][c1] = true;
		
		int qSize, dist = 0, nx, ny;
		Point cur;
		while(!q.isEmpty()) {
			qSize = q.size();
			while(qSize-- > 0) {
				
				cur = q.poll();
				for(int d = 0; d < 6; ++d) {
					nx = cur.x + dx[d];
					ny = cur.y + dy[d];
					
					if(nx < 0 || nx >= N || ny < 0 || ny >= N || visit[nx][ny]) continue;
					
					if(nx == r2 && ny == c2) return ++dist;
					
					q.offer(new Point(nx, ny));
					visit[nx][ny] = true;
				}
				
			}
			
			++dist;
		}
		
		return -1;
	}
}