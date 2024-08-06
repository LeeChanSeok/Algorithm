import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	
	static int[] dx = {-1, 1, 0, 0};
	static int[] dy = {0, 0, -1, 1};

	static int N, M, K;
	
	static Queue<int[]> qManne;
	static char[][] board;
	static boolean[][] mannequin;
	
	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());

		board = new char[N][M];
		mannequin = new boolean[N][M];
		qManne = new LinkedList<>();
		
		int x = 0, y = 0;
		for(int i = 0; i < N; ++i) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < M; ++j) {
				char c = st.nextToken().charAt(0);
				board[i][j] = c;
				
				if(c == '3') {
					qManne.add(new int[] {i,j});
					mannequin[i][j] = true;
				} else if(c == '4') {
					x = i; y = j;
				}
				
			}
		}
		
		mannequinBfs();
		int ans = bfs(x, y);
		System.out.println(ans);
		

	}
	
	private static void mannequinBfs() {

		
		
		int move = 0;
		while(!qManne.isEmpty() && move < K) {
			int qSize = qManne.size();
			while(qSize-- > 0) {
				int[] cur = qManne.poll();
				int x = cur[0];
				int y = cur[1];
				
				for(int d = 0; d < 4; ++d) {
					int nx = x + dx[d];
					int ny = y + dy[d];
					
					if(nx < 0 || nx >= N || ny < 0 || ny >= M) continue;
					if(mannequin[nx][ny]) continue;
					
					mannequin[nx][ny] = true;
					qManne.offer(new int[] {nx, ny});
				}
				
			}
			
			++move;
		}
		
	}

	private static int bfs(int sx, int sy) {

		Queue<int[]> q = new LinkedList<>();
		q.offer(new int[] {sx, sy});
		
		boolean[][] visited = new boolean[N][M];
		visited[sx][sy] = true;
		
		int move = 0;
		while(!q.isEmpty()) {
			int qSize = q.size();
			while(qSize-- > 0) {
				int[] cur = q.poll();
				int x = cur[0];
				int y = cur[1];
				
				if(board[x][y] == '2') return move;
				
				for(int d = 0; d < 4; ++d) {
					int nx = x + dx[d];
					int ny = y + dy[d];
					
					if(nx < 0 || nx >= N || ny < 0 || ny >= M) continue;
					if(board[nx][ny] == '1' || mannequin[nx][ny] || visited[nx][ny]) continue;
					
					visited[nx][ny] = true;
					q.offer(new int[] {nx, ny});
				}
				
			}
			++move;
		}
		
		
		return  -1;
		
	}

}