import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	static int[] cnt;
	static int[][] board;
	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int N = Integer.parseInt(br.readLine());
		cnt = new int[3];
		
		board = new int[N][N];
		for(int i = 0; i < N; ++i) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < N; ++j) {
				board[i][j] = Integer.parseInt(st.nextToken())+1;
			}
		}
		
		recursive(N, 0, 0);
		
		System.out.println(cnt[0]);
		System.out.println(cnt[1]);
		System.out.println(cnt[2]);

	}
	private static void recursive(int n, int x, int y) {
		
		if(n == 1) {
			++cnt[board[x][y]];
			return;
		}
		
		if(isPaper(n, x, y)) {
			++cnt[board[x][y]];
		}else {
			n /= 3;
			for(int i = 0; i < 3; ++i) {
				for(int j = 0; j < 3; ++j) {
					recursive(n, x + i*n, y + j*n);
				}
			}
		}
		
	}
	private static boolean isPaper(int n, int x, int y) {

		int num = board[x][y];
		
		for(int i = 0; i < n; ++i) {
			for(int j = 0; j < n; ++j ) {
				if(board[x+i][y+j] != num) return false;
			}
			
		}
		
		return true;
		
	}

}