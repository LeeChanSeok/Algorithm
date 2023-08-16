import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	static int n;
	static int[][] board;
	static long[][] D;
	
	public static void main(String[] args) throws Exception{
		input();
		pro();
	}

	private static void pro() {

		D[1][1] = 1;
		for(int i = 1; i <= n; ++i) {
			for(int j = 1; j <= n; ++j) {
				if(board[i][j] == 0) continue;
				int step = board[i][j];
				
				int nx = i + step;
				if(nx <= n) D[nx][j] += D[i][j];
				
				int ny = j + step;
				if(ny <= n) D[i][ny] += D[i][j];
			}
		}
		
		System.out.println(D[n][n]);
	}

	private static void input() throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		n = Integer.parseInt(br.readLine());
		board = new int[n+1][n+1];
		D = new long[n+1][n+1];
		
		for(int i = 1; i <= n; ++i) {
			st = new StringTokenizer(br.readLine());
			for(int j = 1; j <= n; ++j){
				board[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
	}

}