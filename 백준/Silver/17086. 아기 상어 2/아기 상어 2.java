import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	
	static final int[] dx = {-1, -1, 0, 1, 1, 1, 0, -1};
	static final int[] dy = {0, 1, 1, 1, 0, -1, -1, -1};
	static final int DELTA = 100;
	
	static int N, M;
	static char[][] board;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		board = new char[N][M];
		for(int i = 0; i < N; ++i) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < M; ++j) board[i][j] = st.nextToken().charAt(0);
		}
		
		Queue<Integer> sharks = new LinkedList<>();
		for(int i = 0; i < N; ++i) {
			for(int j = 0; j < M; ++j) {
				if(board[i][j] == '1') sharks.add(i*100 + j);
			}
		}
		
		System.out.println(bfs(sharks));
	}

	private static int bfs(Queue<Integer> q) {
		
		boolean[][] visited = new boolean[N][M];
		for(Integer pos : q) visited[pos/DELTA][pos%DELTA] = true;
		
		int move = 0;
		int qSize;
		int pos, x, y, nx, ny;
		while(!q.isEmpty()) {
			qSize = q.size();
			while(qSize-- > 0) {
				pos = q.poll();
				x = pos/DELTA; y = pos%DELTA;
				
				for(int d = 0; d < 8; ++d) {
					nx = x + dx[d];
					ny = y + dy[d];
					if(nx < 0 || nx >= N || ny < 0 || ny >= M || visited[nx][ny]) continue;
					
					q.offer(nx*DELTA + ny);
					visited[nx][ny] = true;
				}
			}
			++move;
		}
		
		return move-1;
	}

}
