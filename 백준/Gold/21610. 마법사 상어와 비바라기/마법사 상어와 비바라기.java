import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
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
		public int hashCode() {
			final int prime = 31;
			int result = 1;
			result = prime * result + x;
			result = prime * result + y;
			return result;
		}

		@Override
		public boolean equals(Object obj) {
			Point other = (Point) obj;
			if (x != other.x)
				return false;
			if (y != other.y)
				return false;
			return true;
		}
		
	}
	
	static int[] dx = {0, -1, -1, -1, 0, 1, 1, 1}; 
	static int[] dy = {-1, -1, 0, 1, 1, 1, 0, -1};
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		int[][] board = new int[N][N];
		
		for(int i = 0; i < N; ++i) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < N; ++j) {
				board[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		Set<Point> cloud = new HashSet<>();
		Set<Point> move = new HashSet<>();
		cloud.add(new Point(N-1, 0));
		cloud.add(new Point(N-1, 1));
		cloud.add(new Point(N-2, 0));
		cloud.add(new Point(N-2, 1));
		
		int d, s;
		for(int i = 0; i < M; ++i) {
			st = new StringTokenizer(br.readLine());
			
			d = Integer.parseInt(st.nextToken()) - 1;
			s = Integer.parseInt(st.nextToken());
			
			move.clear();
			// 1. 구름 이동
			moveCloud(cloud, move, N, d, s);
			
			// 2. rain
			addWater(move, N, board);
			
			// 3. 대각
			addWater2(move, N, board);
			
			// 구름 생성
			makeClud(move, cloud, N, board);
		}

		int ans = totalWater(N, board);
		
		System.out.println(ans);
	}

	private static int totalWater(int N, int[][] board ) {
		int total = 0;
		for(int i = 0; i < N; ++i) {
			for(int j = 0; j < N; ++j)
				total += board[i][j];
		}
		return total;
	}

	private static void makeClud(Set<Point> move, Set<Point> cloud, int N, int[][] board) {
		cloud.clear();
		Point pnt;
		for(int i = 0; i < N; ++i) {
			for(int j = 0; j < N; ++j) {
				pnt = new Point(i, j);
				if(board[i][j] >= 2 && !move.contains(pnt)) {
					board[i][j] -= 2;
					cloud.add(pnt);
				}
			}
		}
		
	}

	private static void addWater2(Set<Point> move, int N, int[][] board) {
		int nx, ny;
		for(Point pnt : move) {
			
			for(int d = 1; d < 8; d = d + 2) {
				nx = pnt.x + dx[d];
				ny = pnt.y + dy[d];
				if(nx < 0 || nx >= N || ny < 0 || ny >= N || board[nx][ny] == 0) continue;
				
				++board[pnt.x][pnt.y];
			}
			
		}
		
	}

	private static void addWater(Set<Point> move, int N, int[][] board) {
		for(Point pnt : move) {
			++board[pnt.x][pnt.y]; 
		}
	}

	private static void moveCloud(Set<Point> cloud, Set<Point> move, int N, int d, int s) {
		
		int nx, ny;
		for(Point pnt : cloud) {
			nx = (pnt.x + (dx[d] * s)%N + N)%N;
			ny = (pnt.y + (dy[d] * s)%N + N)%N;
			
			move.add(new Point(nx, ny));
		}
	}

}