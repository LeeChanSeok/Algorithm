import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws Exception{

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		
		int[][] board = new int[n][m];
		for(int i = 0; i < n; ++i) {
			String str = br.readLine();
			for(int j = 0; j < m; ++j) {
				board[i][j] = (int)(str.charAt(j) - '0');
			}
		}
		
		int ans = 1;
		for(int i = 0; i < n; ++i) {
			for(int j = 0; j < m; ++j) {
				int num = board[i][j];
				
				int k = 1;
				while(i + k < n && j + k < m) {
					if(board[i+k][j+k] == num && board[i+k][j] == num && board[i][j + k] == num) {
						ans = Math.max(ans, (k+1)*(k+1));
					}
					
					++k;
				}
				
			}
		}
		
		System.out.println(ans);
	}

}