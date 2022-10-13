import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
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
	}
	
	static final int[] dx = {-1, 1, 0, 0};
	static final int[] dy = {0, 0, -1, 1};

	static int N, M, candiSize, idx, min;
	static int[][][] distBoard;
	static char[][] board;
	static List<Point> candi; 
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		board = new char[N][N];
		char c;
		candi = new LinkedList<>();
		for(int i = 0; i < N; ++i) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < N; ++j) {
				c = st.nextToken().charAt(0);
				if(c =='2') candi.add(new Point(i, j));
				board[i][j] = c;
			}
		}

		candiSize = candi.size();
		distBoard = new int[candiSize][N][N];
		idx = 0;
		for(Point pos : candi) {
			makeDist(board, distBoard, idx++, pos);
		}
		
		// 조합
		min = 1000;
		int[] comb = new int[M];
		combination(0, 0, comb);

		if(min == 1000) System.out.println(-1);
		else System.out.println(min);

	}
	private static void combination(int idx, int cnt, int[] comb) {
		
		if(cnt == M) {
			int res = minDist(comb);
			min = Math.min(min, res);
			return;
		}
		
		for(int i = idx; i < candiSize; ++i) {
			comb[cnt] = i;
			combination(i + 1, cnt + 1, comb);
		}
		
	}
	
	private static int minDist(int[] comb) {
		int[][] mergeBoard = new int[N][N];
		for(int i = 0; i < N; ++i)
			mergeBoard[i] = distBoard[comb[0]][i].clone();
		
		int idx;
		for(int k = 1; k < M; ++k) {
			idx = comb[k];
			
			for(int i = 0; i < N; ++i) {
				for(int j = 0; j < N; ++j) {
					mergeBoard[i][j] = Math.min(mergeBoard[i][j], distBoard[idx][i][j]);
				}
			}
		}
		
		return calcMinDist(mergeBoard, board);
	}
	
	private static int calcMinDist(int[][] mergeBoard, char[][] board) {
		
		int max = 0;
		
		for(int i = 0; i < N; ++i) {
			for(int j = 0; j < N; ++j) {
				
				if(mergeBoard[i][j] == 1000) {
					if(board[i][j] == '0') return 1000;
					continue;
				}
				max = Math.max(max, mergeBoard[i][j]);
			}
		}
		
		return max;
	}
	
	private static void makeDist(char[][] board, int[][][] distBoard, int idx, Point pos) {
		
		int INF = 1000;
		
		Queue<Point> q = new LinkedList<>();
		q.offer(pos);
		
		boolean[][] visit = new boolean[N][N];
		
		for(int i = 0; i < N; ++i)
			Arrays.fill(distBoard[idx][i], INF);
		
		distBoard[idx][pos.x][pos.y] = 0;
		
		int qSize, dist = 0;
		int nx, ny;
		Point cur;
		while(!q.isEmpty()) {
			qSize = q.size();
			++dist;
			while(qSize-- > 0) {
				cur = q.poll();
				for(int d = 0; d < 4; ++d) {
					nx = cur.x + dx[d];
					ny = cur.y + dy[d];
					
					if(nx < 0 || nx >= N || ny < 0 || ny >= N || board[nx][ny] == '1' || distBoard[idx][nx][ny] <= dist) continue;
					
					distBoard[idx][nx][ny] = dist;
					q.offer(new Point(nx, ny));
					
				}
			}
		}
		
		
	}

}