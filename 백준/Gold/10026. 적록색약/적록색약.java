import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
	static int N, ans1, ans2;
	static char[][] map;
	static int[] dx = {0, 1, 0, -1};
	static int[] dy = {1, 0, -1, 0};
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		map = new char[N][N];
		for(int i = 0; i < N; i++)
			map[i] = br.readLine().toCharArray();
		
		char[][] copyMap = new char[N][N];
		
		
		arrayCopy(map, copyMap);
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < N; j++) {
				if(copyMap[i][j] != '.') solution1(copyMap, i, j);
			}
		}
		
		
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < N; j++) {
				if(map[i][j] != '.') solution2(map, i, j);
			}
		}
		System.out.println(ans1 + " " + ans2);
	}
	
	private static void solution1(char[][] map, int x, int y) {
		
		Queue<Point> q = new LinkedList<>();
		q.add(new Point(x, y));
		char color = map[x][y];
		map[x][y] = '.';
		
		while(!q.isEmpty()) {
			Point cur = q.poll();
			for(int d = 0, dSize = dx.length; d < dSize; d++) {
				int nx = cur.x + dx[d];
				int ny = cur.y + dy[d];
				
				if(nx < 0 || nx >= N || ny < 0 || ny >= N 
						|| map[nx][ny] == '.') continue;
				
				if(color != map[nx][ny]) continue;
				
				map[nx][ny] = '.';
				q.add(new Point(nx, ny));
			}
		}
		ans1++;
	}

	private static void solution2(char[][] map, int x, int y) {
		
		Queue<Point> q = new LinkedList<>();
		q.add(new Point(x, y));
		char color = map[x][y];
		map[x][y] = '.';
		
		while(!q.isEmpty()) {
			Point cur = q.poll();
			for(int d = 0, dSize = dx.length; d < dSize; d++) {
				int nx = cur.x + dx[d];
				int ny = cur.y + dy[d];
				
				if(nx < 0 || nx >= N || ny < 0 || ny >= N 
						|| map[nx][ny] == '.') continue;
				
				if((color == 'B' && map[nx][ny] != 'B') ||
						(color != 'B' && map[nx][ny] == 'B')) continue;
				
				map[nx][ny] = '.';
				q.add(new Point(nx, ny));
			}
		}
		ans2++;
	}
	
	static void arrayCopy(char[][] from, char[][] to) {
		for(int i = 0; i < N; i++) {
			to[i] = from[i].clone();
		}
	}
	
	static class Point{
		int x, y;

		public Point(int x, int y) {
			super();
			this.x = x;
			this.y = y;
		}
		
	}

}