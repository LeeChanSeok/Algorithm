import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
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
		public String toString() {
			return x + "," + y;
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
	
	static List<Point> group = new LinkedList<>();
	static int rainbowCnt;
	
	static final int[] dx = {-1, 1, 0, 0};
	static final int[] dy = {0, 0, -1, 1};
	
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
		
		int score = simulation(N, M, board);
		System.out.println(score);
		
	}

	private static int simulation(int N, int M, int[][] board) {

		boolean[][] visit;
		int score = 0;
		int groupSize;
		while(true){
			group.clear();
			rainbowCnt = 0;
			
			visit = new boolean[N][N];
			//1. 블록 찾기
			for(int i = 0; i < N; ++i) {
				for(int j = 0; j < N; ++j) {
					
					if(board[i][j] > 0 && board[i][j] <= M && !visit[i][j]) {
						bfs(i, j, N, M, board, visit);
					}
					
				}
			}
			if(group.size() < 2) break;
			
			// 2. 블록 제거
			groupSize = group.size();
			score += groupSize * groupSize;
			removeBlock(group, board);
			
			// 3. 중력
			gravity(board, N);
			// 4. 90도 반시계 회전
			rotate(board, N);
			// 5. 중력
			gravity(board, N);
		}
		
		return score;
	}
	
	
	private static void rotate(int[][] board, int N) {
		int[][] newBoard = new int[N][N];
		
		for(int i = 0; i < N; ++i) {
			for(int j = 0; j < N; ++j) {
				newBoard[i][j] = board[j][N-1-i];
			}
		}
		
		for(int i = 0; i < N; ++i)
			board[i] = newBoard[i].clone();
	}

	private static void gravity(int[][] board, int N) {

		int i, k;
		for(int j = 0; j < N; ++j) {
			i = N - 1; k = i - 1;
			while(i > 0) {
				while(i > 0 && board[i][j] != 6) --i;
				if(i == 0) break;
				
				k = Math.min(k, i - 1);
				while(k >= 0 && board[k][j] == 6) --k;
				if(k == -1) break;
				if(board[k][j] == -1) {
					i = k -1;
					continue;
				}
				
				board[i][j] = board[k][j];
				board[k][j] = 6;
				--i;
				
			}
		}
		
	}


	private static void removeBlock(List<Point> group, int[][] board) {
		
		for(Point pnt : group) {
			board[pnt.x][pnt.y] = 6; 
		}
		
	}

	private static void bfs(int i, int j, int N, int M, int[][] board, boolean[][] visit) {
		int color = board[i][j];
		
		List<Point> temp = new LinkedList<>();
		temp.add(new Point(i, j));
		
		visit[i][j] = true;
		
		Queue<Point> q = new LinkedList<>();
		q.offer(new Point(i, j));
		
		int nx, ny, num;
		Point cur, next;
		Set<Point> rainbow = new HashSet<>();
		
		while(!q.isEmpty()) {
			cur = q.poll();
			for(int d = 0; d < 4; ++d) {
				nx = cur.x + dx[d];
				ny = cur.y + dy[d];

				// 경계 밖
				if(nx < 0 || nx >= N || ny < 0 || ny >= N || visit[nx][ny]) continue;
				
				num = board[nx][ny];
				next = new Point(nx, ny);

				// 무지개
				if(num == 0) {
					if(!rainbow.contains(next)) {
						temp.add(next);
						q.offer(next);
						rainbow.add(next);
					}
				}else if(num == color){ // 일반 블록
					visit[nx][ny] = true;
					temp.add(next);
					q.offer(next);
				}
				
			}
		}
		
		int groupSize = group.size();
		int tempSize = temp.size();
		int rbCnt = rainbow.size();
		
		if((tempSize > groupSize)
				|| ((tempSize == groupSize) && (rbCnt > rainbowCnt))
				||((tempSize == groupSize) && (rbCnt == rainbowCnt) && (group.get(0).x < temp.get(0).x))
				||((tempSize == groupSize) && (rbCnt == rainbowCnt) && (group.get(0).x == temp.get(0).x) && (group.get(0).y < temp.get(0).y))
				
				) {
			group = temp;
			rainbowCnt = rbCnt;
		}
		
	}

}