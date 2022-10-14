import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	
	static int N, M;
	static int x, y, dir;
	static int ans;
	static char[][] board;
	static boolean[][] clean;
	
	static int dx[] = {-1, 0, 1, 0};
	static int dy[] = {0, 1, 0, -1};
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		st = new StringTokenizer(br.readLine());
		x = Integer.parseInt(st.nextToken());
		y = Integer.parseInt(st.nextToken());
		dir = Integer.parseInt(st.nextToken());
		
		board = new char[N][M];
		for(int i = 0; i < N; ++i) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < M; ++j) {
				board[i][j] = st.nextToken().charAt(0);
			}
		}
		
		ans = 1;
		board[x][y] = '2';
		int nx, ny;
		boolean isClean;
		while(true) {
			isClean = false;
			for(int d = 0; d < 4; ++d) {
				dir = (dir + 3) % 4;
				
				nx = x + dx[dir];
				ny = y + dy[dir];
				
				if(nx < 0 || nx >= N || ny < 0 || ny >= M 
						|| board[nx][ny] == '2' 
						|| board[nx][ny] == '1') continue;
				
				isClean = true;
				x = nx; y = ny;
				++ans;
				board[x][y] = '2';
				break;
			}
			
			if(!isClean) {
				x -= dx[dir];
				y -= dy[dir];
				
				if(board[x][y] == '1') break;
			}
		}
		
		System.out.println(ans);
		
	}

}