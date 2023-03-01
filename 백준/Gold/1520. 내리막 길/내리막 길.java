import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static final int[] dx = {-1, 1, 0, 0};
	static final int[] dy = {0, 0, -1, 1};
	
	static int N, M;
	static int[][] board;
	static int[][] isPath;
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		board = new int[N][M];
		for(int i = 0; i < N; ++i) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < M; ++j) board[i][j] = Integer.parseInt(st.nextToken());
		}
		
		isPath = new int[N][M];
		for(int i = 0; i < N; ++i) {
			for(int j = 0; j < M; ++j) {
				isPath[i][j] = -1;
			}
		}
		
		dfs(0, 0);
		System.out.println(isPath[0][0]);

	}
	private static int dfs(int x, int y) {
		
		if(isPath[x][y] != -1) {
			return isPath[x][y];
		}
		
		if(x == N-1 && y == M-1) {
			return 1;
		}
		
		isPath[x][y] = 0;
		int h = board[x][y];
		for(int d = 0; d < 4; ++d) {
			int nx = x + dx[d];
			int ny = y + dy[d];
			
			if( nx < 0 || nx >= N || ny < 0 || ny >= M || board[nx][ny] >= h) continue;
			isPath[x][y] += dfs(nx, ny);
		}

		return isPath[x][y];
		
	}

}