import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = 8;
		char[][] board = new char[n][n];
		
		for(int i = 0; i < n; ++i) {
			board[i] = br.readLine().toCharArray();
		}

		int ans = 0;
		for(int i = 0; i < n; ++i) {
			int delta = i % 2;
			for(int j = 0; j < n; j += 2) {
				if(board[i][j+delta] == 'F') ++ans;
			}
		}
		
		System.out.println(ans);
	}

}