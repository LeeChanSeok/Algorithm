import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	static int n, m;
	static boolean[][] board;
	static int[][] D;
	
	public static void main(String[] args) throws Exception {
		input();
		pro();
	}

	private static void pro() {

		int ans = 0;
		for(int i = 1; i <= n; ++i) {
			for(int j = 1; j <= m; ++j) {
				if(!board[i][j]) {
					D[i][j] = Math.min(Math.min(D[i-1][j], D[i][j-1]), D[i-1][j-1]) + 1;
					ans = Math.max(ans, D[i][j]);
				}
			}
		}
		
		System.out.println(ans);
	}

	private static void input() throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		
		board = new boolean[n+1][m+1];
		D = new int[n+1][m+1];
		
		for(int i = 1; i <= n; ++i) {
			st = new StringTokenizer(br.readLine());
			for(int j = 1; j <= m; ++j) {
				if(st.nextToken().charAt(0) != '0') board[i][j] = true;
			}
		}
		
	}

}