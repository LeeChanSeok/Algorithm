import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	static class Point {
		int x, y;

		public Point(int x, int y) {
			super();
			this.x = x;
			this.y = y;
		}
	}

	static int R, C;
	static char[][] map;
	static boolean[][] visit;
	static Queue<Point> hedgehog;
	static Queue<Point> water;
	static int[] dx = {-1, 0, 1, 0};
	static int[] dy = {0, 1, 0, -1};
	

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());

		map = new char[R][C];
		for (int i = 0; i < R; i++)
			map[i] = br.readLine().toCharArray();

		visit = new boolean[R][C];
		hedgehog = new LinkedList<>();
		water = new LinkedList<>();
		for (int i = 0; i < R; i++) {
			for (int j = 0; j < C; j++) {
				if (map[i][j] == 'S') {
					map[i][j] = '.';
					visit[i][j] = true;
					hedgehog.add(new Point(i, j));
				} else if (map[i][j] == '*') {
					water.add(new Point(i, j));
				}
			}
		}

		int res = solution();
		if(res == -1)System.out.println("KAKTUS");
		else System.out.println(res);
	}

	private static int solution() {
		int time = 0;
		
		while(!hedgehog.isEmpty()) {
			
			// 1. 고슴도치 이동 및 목적지 확인
			int hSize = hedgehog.size();
			while(hSize-- > 0) {
				Point cur = hedgehog.poll();
				if(map[cur.x][cur.y] == 'D') return time;
				if(map[cur.x][cur.y] == '*') continue;
				for(int d = 0, dSize = dx.length; d < dSize; d++) {
					int nx = cur.x + dx[d];
					int ny = cur.y + dy[d];
					if(nx < 0 || nx >= R || ny < 0 || ny >= C || 
							visit[nx][ny] ||
							map[nx][ny] == '*' || 
							map[nx][ny] == 'X'
							) continue;
					
					visit[nx][ny] = true;
					hedgehog.add(new Point(nx, ny));
				}
			}
			
			// 2. 물 이동
			int wSize = water.size();
			while(wSize-- > 0) {
				Point cur = water.poll();
				
				for(int d = 0, dSize = dx.length; d < dSize; d++) {
					int nx = cur.x + dx[d];
					int ny = cur.y + dy[d];
					if(nx < 0 || nx >= R || ny < 0 || ny >= C || 
							map[nx][ny] != '.') continue;
					
					map[nx][ny] = '*';
					water.add(new Point(nx, ny));
				}
			}
			time++;
		}
		
		return -1;
	}

}