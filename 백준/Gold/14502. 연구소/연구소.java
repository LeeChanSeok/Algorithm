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
	
	static int N, M, max, maxIdx;
	static char[][] map;
	
	static int[] dx = {-1, 1, 0, 0};
	static int[] dy = {0, 0, -1, 1};
	static int[] wall;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		map = new char[N][M];
		
		for(int i = 0; i < N; ++i) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < M; ++j)
				map[i][j] = st.nextToken().charAt(0);
		}
	
		wall = new int[3];
		max = 0; maxIdx = N * M;
		dfs(0, 0);
		
		System.out.println(max);
	}
	
	
	private static void dfs(int cnt, int idx) {
		
		if(cnt == 3) {
			solution(wall, N, M);
			return;
		}
		
		int x, y;
		for(int i = idx, maxIdx = N * M; i < maxIdx; ++i) {
			x = i / M; 
			y = i % M;
			
			if(map[x][y] == '0') {
				wall[cnt] = i;
				dfs(cnt+1, i+1);
			}
		}
		
	}
	
	private static void solution(int[] wall, int N, int M) {

		// map copy
		char[][] newMap = new char[N][M];
		copyArr(map, newMap);
		
		// 벽 세우기
		int x, y;
		for(int i = 0; i <3; ++i) {
			x = wall[i] / M;
			y = wall[i] % M;
			newMap[x][y] = '1';
		}
		
		// 바이러스 전파
		bfs(newMap, N, M);
		
		// 안전영역 확인
		int res = safeSpace(newMap, N, M);
		max = Math.max(max, res);
	}

	private static int safeSpace(char[][] newMap, int n2, int m2) {
		int res = 0;
		for(int i = 0; i < N; ++i) {
			for(int j = 0; j < M; ++j) {
				if(newMap[i][j] == '0') ++res;
			}
		}
		return res;
	}
	
	private static void bfs(char[][] newMap, int N, int M) {

		boolean[][] visit = new boolean[N][M];
		Queue<Point> q = new LinkedList<>();
		Point cur;
		int nx, ny;
		for(int i = 0; i < N; ++i) {
			for(int j = 0; j < M; ++j) {
				
				if(newMap[i][j] == '2' && !visit[i][j]) {
					
					q.offer(new Point(i, j));
					visit[i][j] = true;
					
					while(!q.isEmpty()) {
						cur = q.poll();
						
						for(int d = 0; d < 4; ++d) {
							nx = cur.x + dx[d];
							ny = cur.y + dy[d];
							if(nx < 0 || nx>=N || ny < 0 || ny >= M || visit[nx][ny] || newMap[nx][ny] != '0') continue;
							newMap[nx][ny] = '2';
							q.offer(new Point(nx, ny));
						}
					}
					
				}
				
			}
		}
		
	}
	private static void copyArr(char[][] map, char[][] newMap) {
			for(int i = 0; i < N; ++i)
				newMap[i] = map[i].clone();
	}
}