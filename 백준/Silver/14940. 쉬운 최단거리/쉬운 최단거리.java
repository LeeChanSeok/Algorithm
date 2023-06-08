import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	
	static final int DELTA = 1000;
	static int N, M;
	static int[][] board;
	
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		board = new int[N][M];
		for(int i = 0; i < N; ++i) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < M; ++j) {
				board[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		bfs(find_start());
		
		
		for(int i = 0; i < N; ++i) {
			for(int j = 0; j < M; ++j) {
				sb.append(board[i][j] + " ");
			}
			sb.append("\n");
		}

		bw.write(sb.toString());
		bw.flush();
		
		bw.close();
		br.close();
		
	}

	private static void bfs(int pos) {

		int[] dx = {-1, 1, 0, 0};
		int[] dy = {0, 0, -1, 1};
		
		int x = pos/DELTA;
		int y = pos%DELTA;
		
		boolean[][] visited = new boolean[N][M];
		visited[x][y] = true;
		
		Queue<Integer> q = new LinkedList<>();
		q.offer(x * DELTA + y);
		
		int move = 0;
		int qSize;
		int nx, ny;
		int cur;
		while(!q.isEmpty()) {
			qSize = q.size();
			while(qSize-- > 0) {
				cur = q.poll();
				
				x = cur / DELTA;
				y = cur % DELTA;
				board[x][y] = move;
				
				for(int d = 0; d < 4; ++d) {
					nx = x + dx[d];
					ny = y + dy[d];
					
					if(nx < 0 || nx >= N || ny < 0 || ny >= M || visited[nx][ny] || (board[nx][ny]&1) == 0) continue;
					q.offer(nx*DELTA + ny);
					visited[nx][ny] = true;
				}
			}
			
			++move;
		}
		
		for(int i = 0; i < N; ++i) {
			for(int j = 0; j < M; ++j) {
				if(!visited[i][j] && board[i][j] == 1) board[i][j] = -1;
			}
		}
		
	}

	private static int find_start() {

		for(int i = 0; i < N; ++i) {
			for(int j = 0; j < M; ++j) {
				if(board[i][j] == 2) {
					board[i][j] = 0;
					return i * DELTA + j;
				}
			}
		}
		
		return 0;
		
	}

}