import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution {

	static class Point{
		int x, y;

		public Point(int x, int y) {
			super();
			this.x = x;
			this.y = y;
		}
		
	}
	
	static int N, K, max, peek, height;
	static int[][] board, cntBoard;
	static int[] dx = { 0, 1, 0, -1 };
	static int[] dy = { 1, 0, -1, 0 };
	static boolean[][] visit;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		Queue<Point> peeks = new LinkedList<>();
		
		int T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= T; tc++) {
			st = new StringTokenizer(br.readLine());

			N = Integer.parseInt(st.nextToken());
			K = Integer.parseInt(st.nextToken());

			board = new int[N][N];
			cntBoard = new int[N][N];
			for(int i = 0; i < N; ++i) {
				st = new StringTokenizer(br.readLine());
				for(int j = 0; j < N; ++j) {
					board[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			
			peeks.clear();
			peek = -1;
			for(int i = 0; i < N; ++i) {
				for(int j = 0; j < N; ++j) {
					height = board[i][j];
					if(height >= peek) {
						if(height > peek) {
							peeks.clear();
							peek = height;
						}
						peeks.offer(new Point(i, j));
					}
				}
			}
			
			max = 0;
			
			visit = new boolean[N][N];
			for(Point point : peeks) {
				visit[point.x][point.y] = true;
				dfs(point.x, point.y, K, 1);
				visit[point.x][point.y] = false;
			}
			System.out.printf("#%d %d\n", tc, max);
			
		} // test-case 종료

	}

	private static void dfs(int x, int y, int K, int move) {
		
		int nx, ny;
		int num = board[x][y];
		int temp;
		visit[x][y] = true;
		for(int d = 0; d < 4; ++d) {
			nx = x + dx[d]; ny = y + dy[d];
			
			if(nx < 0 || nx >= N || ny < 0 || ny >= N || visit[nx][ny] || board[nx][ny]-K >= num) continue;
			
			if(K != 0 && board[nx][ny] >= num) {
				temp = board[nx][ny];
				board[nx][ny] = num - 1;
				dfs(nx, ny, 0, move + 1);
				board[nx][ny] = temp;
			}
			else {
				dfs(nx, ny, K, move + 1);
			}
		}
		visit[x][y] = false;
		max = Math.max(max, move);
			
	}
}
