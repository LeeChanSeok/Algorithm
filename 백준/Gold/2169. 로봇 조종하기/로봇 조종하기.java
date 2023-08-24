import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	static int n, m;
	static int[][] board;
	static int[][] D;
	
	public static void main(String[] args) throws Exception {
		
		input();
		pro();

	}

	private static void pro() {

		int[] tempR = new int[m+1];
		int[] tempL = new int[m+1];
		
		D[1][1] = board[1][1];
		for(int j = 2; j <=m; ++j) {
			D[1][j] = D[1][j-1] + board[1][j];
		}
		
		for(int i = 2; i <= n; ++i) {
			
			tempL[1] = D[i-1][1] + board[i][1];
			for(int j = 2; j <= m; ++j) {
				tempL[j] = Math.max(D[i-1][j], tempL[j-1]) + board[i][j];
			}
			
			tempR[m] = D[i-1][m] + board[i][m];
			for(int j = m - 1; j > 0; --j) {
				tempR[j] = Math.max(D[i-1][j], tempR[j+1]) + board[i][j];
			}
			
			for(int j = 1; j <= m; ++j) D[i][j] = Math.max(tempL[j], tempR[j]);
		}
		
		System.out.println(D[n][m]);
	}

	private static void input() throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		
		board = new int[n+1][m+1];
		D = new int[n+1][m+1];
		
		for(int i = 1; i <= n; ++i) {
			st = new StringTokenizer(br.readLine());
			for(int j = 1; j <= m; ++j) {
				board[i][j] = Integer.parseInt(st.nextToken());
			}
		}
	}

}