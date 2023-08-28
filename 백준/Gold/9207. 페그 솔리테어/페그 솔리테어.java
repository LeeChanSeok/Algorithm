import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {

	static int[] dx = {-1, 1, 0, 0};
	static int[] dy = {0, 0, -1, 1};
	
	static int n = 5;
	static int m = 9;
	static int mCnt, mMove;
	
	static int pinCnt;
	static int[][] pinPos;
	static char[][] board;
	
	public static void main(String[] args) throws Exception{

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int T = Integer.parseInt(br.readLine());
		
		board = new char[n+2][m+2];
		
		while(T-- > 0) {
			
			Arrays.fill(board[0], '#');
			Arrays.fill(board[n+1], '#');
			
			for(int i = 1; i <= n; ++i) {
				board[i][0] = board[i][m+1] = '#';
				String row = br.readLine();
				for(int j = 1; j <= m; ++j) {
					board[i][j] = row.charAt(j-1);
				}
			}
			
			pro();
			
			sb.append(mCnt + " " +  mMove + "\n");
			if(T == 0) break;
			br.readLine();
		}
		
		System.out.println(sb);

	}

	private static void pro() {
		
		pinCnt = 0;
		for(int i = 1; i <= n; ++i) {
			for(int j = 1; j <= m; ++j) {
				if(board[i][j] == 'o') ++pinCnt;
			}
		}
		
		mCnt = pinCnt;
		mMove = 0;

		recursive(pinCnt, 0);
	
	}

	private static void recursive(int cnt, int move) {

		if(cnt < mCnt) {
			mCnt = cnt;
			mMove = move;
		}
		
		for(int x = 1; x <= n; x++) {
			for(int y = 1; y <= m; ++y) {
				
				if(board[x][y] != 'o') continue;
				
				for(int d = 0; d < 4; ++d) {
					int nx = x + dx[d];
					int ny = y + dy[d];
					int nnx = x + dx[d] * 2;
					int nny = y + dy[d] * 2;
					
					if(board[nx][ny] == 'o' && board[nnx][nny] == '.') {
						
						board[x][y] = board[nx][ny] = '.';
						board[nnx][nny] = 'o';
						recursive(cnt - 1, move + 1);
						board[x][y] = board[nx][ny] = 'o';
						board[nnx][nny] = '.';
						
					}
				}
			}
			
		}
		
	}

}