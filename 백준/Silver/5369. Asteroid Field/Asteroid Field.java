import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Main {

	static int[] dx = {-1, 1, 0, 0};
	static int[] dy = {0, 0, -1, 1};
	
	static int M;
	static char[][] board;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		while(T-- > 0) {
			M = Integer.parseInt(br.readLine());
			board = new char[M][M];
			for(int i = 0; i < M; ++i) {
				board[i] = br.readLine().toCharArray();
			}

			board[0][0] = board[M-1][M-1] = '-';
			
			long ans = bfs();
			System.out.println(ans);
			
		}
	}

	private static long bfs() {

		Queue<int[]> q = new LinkedList<>();
		q.offer(new int[] {0, 0});
		
		boolean[][] visited = new boolean[M][M];
		visited[0][0] = true;
		
		long move = 0;
		while(!q.isEmpty()) {
			
			long size = q.size();
			while(size-- > 0) {
				int[] cur = q.poll();
				
				int x = cur[0];
				int y = cur[1];
				if(x == M-1 && y == M-1) return move;
				
				for(int d = 0; d < 4; ++d) {
					int nx = x + dx[d];
					int ny = y + dy[d];
					
					if(nx < 0 || nx >= M || ny < 0 || ny >= M) continue;
					if(board[nx][ny] == '*' || visited[nx][ny]) continue;
					
					q.offer(new int[] {nx, ny});
					visited[nx][ny] = true;
				}
			}
			
			++move;
		}
		
		return -1;
	}

}