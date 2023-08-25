import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	static int[] dx = {-1, 1, 0, 0};
	static int[] dy = {0, 0, -1, 1};
	
	static boolean[][] board;
	static int r, c, rd;
	static int rx, ry;
	static int[] dir;
	
	public static void main(String[] args) throws Exception {
		input();
		pro();
	}

	private static void pro() {

		rd = 0;
		board[rx][ry] = true;
		while(isMove()) {}
		
		System.out.println(rx + " " + ry);
		
	}

	private static boolean isMove() {

		for(int d = 0; d < 4; ++d) {
			
			int nx = rx + dx[dir[rd]];
			int ny = ry + dy[dir[rd]];
			
			if(nx >= 0 && nx < r && ny >= 0 && ny < c) {
				if(!board[nx][ny]) {
					
					board[nx][ny] = true;
					rx = nx; ry = ny;
					return true;
					
				}
			
			}
			
			rd = ++rd % 4;
		}
		
		return false;
	}

	private static void input() throws Exception{

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		r = Integer.parseInt(st.nextToken());
		c = Integer.parseInt(st.nextToken());
		
		board = new boolean[r][c];
		int k = Integer.parseInt(br.readLine());
		for(int i = 0; i < k; ++i) {
			st = new StringTokenizer(br.readLine());
			
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			
			board[x][y] = true;
		}
		
		st = new StringTokenizer(br.readLine());
		
		rx = Integer.parseInt(st.nextToken());
		ry = Integer.parseInt(st.nextToken());
		
		dir = new int[4];
		st = new StringTokenizer(br.readLine());
		for(int d = 0; d < 4; ++d) dir[d] = Integer.parseInt(st.nextToken()) - 1;
		
	}

}