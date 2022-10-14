import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
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
	
	static int dx[] = {-1, 1, 0, 0};
	static int dy[] = {0, 0, -1, 1};
	
	static int N, L, R;
	static int[][] board, group;
	static Map<Integer, Integer> info = new HashMap<>();
	
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		L = Integer.parseInt(st.nextToken());
		R = Integer.parseInt(st.nextToken());
		
		board = new int[N][N];
		
		for(int i = 0; i < N; ++i) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < N; ++j) {
				board[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		int time = 0,gNum;
		int total = N * N;
		
		while(true) {
			info.clear();
			gNum = 0;
			group = new int[N][N];
			
			// 1. grouping
			for(int i = 0; i < N; ++i) {
				for(int j = 0; j < N; ++j) {
					if(group[i][j] != 0) continue;
					bfs(i, j, N, L, R, board, group, ++gNum, info);
				}
			}
			if(gNum == total) break;
			// 2. 인구 이동
			move(board, group, info);
			
			++time;
		}
		
		System.out.println(time);
	}

	private static void move(int[][] board, int[][] group, Map<Integer, Integer> info) {
		
		for(int i = 0; i < N; ++i) {
			for(int j = 0; j < N; ++j) {
				board[i][j] = info.get(group[i][j]);
			}
		}
		
	}

	private static void bfs(int x, int y, int N, int L, int R, int[][] board, int[][] group, int gNum,
			Map<Integer, Integer> info) {
		
		Queue<Point> q = new LinkedList<>();
		q.offer(new Point(x, y));
		group[x][y] = gNum;
		
		int count = 1;
		int sum = board[x][y];
		Point pos;
		int nx, ny;
		int cur, next, diff;
		
		while(!q.isEmpty()) {
			pos = q.poll();
			
			for(int d = 0; d < 4; ++d) {
				nx = pos.x + dx[d];
				ny = pos.y + dy[d];
				
				if(nx < 0 || nx >= N || ny < 0 || ny >= N || group[nx][ny] != 0) continue;
				cur = board[pos.x][pos.y];
				next = board[nx][ny];
				
				diff = Math.abs(cur - next);
				if(diff >= L && diff <= R) {
					q.offer(new Point(nx, ny));
					group[nx][ny] = gNum;
					sum += next;
					++count;
				}
				
			}
			
		}
		
		info.put(gNum, sum/count);
	}

}