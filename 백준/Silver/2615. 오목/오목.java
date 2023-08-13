import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	static int[] dx = {0, 1, 1, -1};
	static int[] dy = {1, 0, 1, 1};
	
	static int n = 19;
	static int color;
	static int[][] board = new int[n+2][n+2];
	
	public static void main(String[] args) throws Exception{
		input();
		pro();
	}

	private static void pro() {

		for(int i = 1; i <= n; ++i) {
			for(int j = 1; j <= n; ++j) {
				if(board[i][j] == 0) continue;
				
				for(int d = 0; d < 4; ++d) {
										
					if(isWin(i, j, d)) {
						System.out.println(board[i][j]);
						System.out.println(i + " " + j);
						return;
					}
				}
			}
		}
		System.out.println(0);
	}

	private static boolean isWin(int x, int y, int d) {
		
		int color = board[x][y];
		int nx, ny;
		
		// 1. 이전 위치 값이 같은지 확인
		nx = x - dx[d];
		ny = y - dy[d];
		
		if(board[nx][ny] == color) return false;
		
		// 2. 다음 위치 값이 같은지 확인
		nx = x + dx[d] * 4;
		ny = y + dy[d] * 4;
		if(nx < 1 || nx > n || ny > n) return false;
		
		nx = x + dx[d] * 5;
		ny = y + dy[d] * 5;
		if(board[nx][ny] == color) return false;
				
		// 3. 가운데 값이 같은지 확인
		for(int i = 1; i < 5; ++i) {
			nx = x + dx[d] * i;
			ny = y + dy[d] * i;
			
			if(board[nx][ny] != color) return false;
		}
		
		return true;
	}

	private static void input() throws Exception{

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		for(int i = 1; i <= n; ++i) {
			st = new StringTokenizer(br.readLine());
			for(int j = 1; j <= n; ++j) board[i][j] = Integer.parseInt(st.nextToken());
		}
		
	}

}