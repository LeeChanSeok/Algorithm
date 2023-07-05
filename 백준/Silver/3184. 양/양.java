import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	static final int[] dx = {-1, 1, 0, 0};
	static final int[] dy = {0, 0, -1, 1};
	
	static int N, M;
	static char[][] board;
	static boolean[][] visited;
	
	static int oCnt, vCnt;
	public static void main(String[] args) throws IOException {
		
		input();
		pro();
	}

	private static void pro() {

		for(int i = 0; i < N; ++i) {
			for(int j = 0; j < M; ++j) {
				if(visited[i][j]) continue;
				if(board[i][j] == '#') continue;
				bfs(i, j);
			}
		}
		
		System.out.println(oCnt + " " + vCnt);
	}

	private static void bfs(int sx, int sy) {

		Queue<Integer> que = new LinkedList<>();
		que.offer(sx);
		que.offer(sy);
		
		visited[sx][sy] = true;
		
		int o = 0, v = 0;
		
		while(!que.isEmpty()) {
			int x = que.poll();
			int y = que.poll();
			
			if(board[x][y] == 'o') ++o;
			else if(board[x][y] == 'v') ++v;
			
			for(int d = 0; d < 4; ++d) {
				int nx = x + dx[d];
				int ny = y + dy[d];
				
				if(nx < 0 || nx >= N || ny < 0 || ny >= M) continue;
				if(visited[nx][ny]) continue;
				if(board[nx][ny] == '#') continue;
				
				visited[nx][ny] = true;
				que.offer(nx);
				que.offer(ny);
			}
			
		}
		
		if(o > v) oCnt += o;
		else vCnt += v;
		
	}

	private static void input() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
	
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		board = new char[N][M];
		for(int i = 0; i < N; ++i) {
			board[i] = br.readLine().toCharArray();
		}
		
		visited = new boolean[N][M];
		
	}

}
