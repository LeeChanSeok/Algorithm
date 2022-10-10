import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.List;
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

		@Override
		public String toString() {
			return "(" + x + ", " + y + ")";
		}
		
		
		
	}
	
	static int N, M;
	static int[][] map;
	static boolean[][] visit;
	
	static int[] dx = {-1, 1, 0, 0};
	static int[] dy = {0, 0, -1, 1};
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		map = new int[N][M];
		
		for(int i = 0; i < N; ++i) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < M; ++j) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		visit = new boolean[N][M];
		int group = 1;
		for(int i = 0; i < N; ++i) {
			for(int j = 0; j < M; ++j) {
				if(!visit[i][j] && map[i][j] == 1) {
					grouping(i, j, map, group);
					++group;
				}
			}
		}
		
		List<Point>[] island = new LinkedList[group];
		for(int i = 1; i < group; ++i)
			island[i] = new LinkedList<>();
		
		visit = new boolean[N][M];
		for(int i = 0; i < N; ++i) {
			for(int j = 0; j < M; ++j) {
				if(!visit[i][j] && map[i][j] == 0) {
					findIsland(i, j, map, island);
				}
			}
		}
		
		System.out.println(link(map, island, --group));
		
	}

	private static int link(int[][] map, List<Point>[] island, int group) {

		int total_dist = 0;
		int INF = Integer.MAX_VALUE;
		int dist, idx, min;
		int x, y;
		while(--group > 0) {
			
			min = Integer.MAX_VALUE;  idx = -1;
			for(Point pos : island[1]) {
				
				for(int d = 0; d < 4; ++d) {
					x = pos.x; y = pos.y;
					
					dist = 0;
					while(true) {
						x += dx[d];
						y += dy[d];
						
						if(x < 0 || x >= N || y < 0 || y >= M || map[x][y] == 1) break;
						
						if(map[x][y] != 0) {
							if(dist >= 2 && dist < min) {
								min = dist; idx = map[x][y];
							}
							break;
						}
						
						++dist;
					}
					
				}
				
			}
			
			if(min == INF) {
				total_dist = -1;
				break;
			}
			
			for(Point pos : island[idx])
				map[pos.x][pos.y] = 1;
			island[1].addAll(island[idx]);
			island[idx].clear();
			
			total_dist += min;
			
		}
		
		return total_dist;
	}

	private static void findIsland(int i, int j, int[][] map, List<Point>[] island) {
		
		Queue<Point> q = new LinkedList<>();
		q.offer(new Point(i, j));
		visit[i][j] = true;
		
		Point cur;
		int nx, ny;
		while(!q.isEmpty()) {
			cur = q.poll();
			
			for(int d = 0; d < 4; ++d) {
				nx = cur.x + dx[d];
				ny = cur.y + dy[d];
				
				if(nx < 0 || nx >= N || ny < 0 || ny >= M || visit[nx][ny]) continue;
				if(map[nx][ny] != 0) 
					island[map[nx][ny]].add(new Point (nx, ny));
				else
					q.offer(new Point (nx, ny));
				
				visit[nx][ny] = true;
				
			}
		}
	}

	private static void grouping(int i, int j, int[][] map, int group) {
		
		Queue<int[]> q = new LinkedList<>();
		q.offer(new int[] {i, j});
		visit[i][j] = true;
		
		int[] cur;
		int nx, ny;
		while(!q.isEmpty()) {
			cur = q.poll();
			map[cur[0]][cur[1]] = group;
			
			for(int d = 0; d < 4; ++d) {
				nx = cur[0] + dx[d];
				ny = cur[1] + dy[d];
				
				if(nx < 0 || nx >= N || ny < 0 || ny >= M || visit[nx][ny] || map[nx][ny] != 1) continue;
				visit[nx][ny] = true;
				q.offer(new int[] {nx, ny});
			}
		}
		
	}

}