import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	static class Point{
		int x, y, k;

		public Point(int x, int y, int k) {
			super();
			this.x = x;
			this.y = y;
			this.k = k;
		}
		
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int[] dx = {-1, 1, 0, 0};
		int[] dy = {0, 0, -1, 1};
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		
		char[][] board = new char[N][M];
		for(int i = 0; i < N; ++i)
			board[i] = br.readLine().toCharArray();
		
		int dist = simulation(N, M, K, dx, dy, board);
		System.out.println(dist);
	}

	private static int simulation(int N, int M, int K, int[] dx, int[] dy, char[][] board) {
		
		Queue<Point> q = new LinkedList<>();
		q.add(new Point(0, 0, K+1));
		
		int[][] visit = new int[N][M];
		visit[0][0] = K+1;
		
		int dist = 1;
		int qSize, nx, ny;
		Point cur;
		
		while(!q.isEmpty()) {
			qSize = q.size();
			while(qSize-- > 0){
				cur = q.poll();
				
				if(cur.x == N -1 && cur.y == M-1) return dist;
				
				for(int d = 0; d < 4; ++d) {
					nx = cur.x + dx[d];
					ny = cur.y + dy[d];
					
					if(nx < 0 || nx >= N || ny < 0 || ny >= M) continue;
					
					// '0'으로 갈 때
					if(board[nx][ny] == '0') {
						if(cur.k > visit[nx][ny]) {
							visit[nx][ny] = cur.k;
							q.add(new Point(nx, ny, cur.k));
						}
					}else { // '1' 으로 갈 때
						if(cur.k-1 > visit[nx][ny]){
							visit[nx][ny] = cur.k-1;
							q.add(new Point(nx, ny, cur.k-1));
						}
					}
				
				}
			}
			++dist;
		}
			
		return -1;
	}

}