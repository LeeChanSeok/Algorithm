import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	static int min;
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N, M;
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		char[][] board = new char[N][M];
		for(int i = 0; i < N; ++i) {
			board[i] = br.readLine().toCharArray();
		}
		
		min = Integer.MAX_VALUE;
		for(int i = 0; i <= N-8; ++i) {
			for(int j = 0; j <= M-8; ++j) {
				chessBoard(i, j, 'W', board);
				chessBoard(i, j, 'B', board);
			}
		}
		
		System.out.println(min);

	}
	private static void chessBoard(int x, int y, char c, char[][] board) {

		int count = 0;
		for(int i = x; i < x+8; ++i) {
			for(int j = y; j < y+8; ++j) {
				if(board[i][j] != c) ++count;
				if(count>= min) return;
				c = (c == 'B') ? 'W' : 'B';
			}
			c = (c == 'B') ? 'W' : 'B';
			
		}
		
		min = count;
		
	}

}