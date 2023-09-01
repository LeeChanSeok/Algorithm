import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	
	static int n, m;
	static int ans;
	static boolean[][] board;
	
	public static void main(String[] args) throws Exception{
		input();
		pro();
	}

	private static void pro() {
		recursive(1, 1);
		System.out.println(ans);
	}

	private static void recursive(int x, int y) {

		if(y == m + 1) {
			++x;
			y = 1;
		}
		
		if(x == n + 1) {
			++ans;
			return;
		}
		
		recursive(x, y+1);
		if(!(board[x-1][y] && board[x][y-1] && board[x-1][y-1])) {
			board[x][y] = true;   
			recursive(x, y+1);
		}
		board[x][y] = false;
		
	}

	private static void input() throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		
		board = new boolean[n+1][m+1];
		
	}
	
	public static void print() {
		for(int i = 1; i <= n; ++i) {
			for(int j = 1; j <= m; ++j) {
				if(board[i][j]) System.out.print(1);
				else System.out.print(0);
			}
			System.out.println();
		}
		System.out.println();
	}

}