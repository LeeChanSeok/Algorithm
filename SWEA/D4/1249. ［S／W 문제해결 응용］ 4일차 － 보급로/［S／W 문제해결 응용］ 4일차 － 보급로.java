import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;

public class Solution {
	static class Point{
		int x, y;

		public Point(int x, int y) {
			super();
			this.x = x;
			this.y = y;
		}

		@Override
		public String toString() {
			return "Point [x=" + x + ", y=" + y + "]";
		}

		
	}
	
	static int N;
	static int INF = Integer.MAX_VALUE;
	static int[][] map, cntMap;
	static final int[] dx = {-1, 1, 0, 0};
	static final int[] dy = {0, 0, -1, 1};
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		for(int tc = 1; tc <= T; tc++) {
			N = Integer.parseInt(br.readLine());
			
			map = new int[N][N];
			cntMap = new int[N][N];
			
			for(int i = 0; i < N; i++) {
				char[] temp = br.readLine().toCharArray();
				for(int j = 0; j < N; j++)
					map[i][j] = temp[j] - '0';
			}
			
			for(int i = 0; i < N; i++)
				Arrays.fill(cntMap[i], INF);
			
			bfs();
			System.out.println("#" + tc + " " + cntMap[N-1][N-1]);
		}

	}

	private static void bfs() {
		
		Queue<Point> q = new ArrayDeque<>();
		q.offer(new Point(0, 0));
		cntMap[0][0] = 0;
		
		while(!q.isEmpty()) {
			Point cur = q.poll();
			
			for(int d = 0; d < 4; d++) {
				int nx = cur.x + dx[d];
				int ny = cur.y + dy[d];
				
				if(!inRange(nx, ny)) continue;				
				
				if(cntMap[nx][ny] > cntMap[cur.x][cur.y] + map[nx][ny]) {
					cntMap[nx][ny] = cntMap[cur.x][cur.y] + map[nx][ny];
					q.offer(new Point(nx, ny));
				}
				
			}
		}
		
	}

	private static boolean inRange(int x, int y) {
		if(x < 0 || x >= N || y < 0 || y >= N) return false;
		return true;
	}

}