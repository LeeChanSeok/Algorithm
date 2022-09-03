import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	static int N, res;
	static boolean[][] board;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		board = new boolean[N][N];
		res = 0;
		N_Queen(0);
		System.out.println(res);
	}

	private static void N_Queen(int r) {
		if(r == N) {
			res++;
			return;
		}
		
		int nr, nc;
		boolean isPossible;
		for(int j = 0; j < N; j++) {
			isPossible = true;
			// 1. 열 검사
			for(int i = r-1; i >= 0; i--) {
				if(board[i][j]) {
					isPossible = false;
					break;
				}
			}
			if(!isPossible) continue;
			
			// 2. 정대각 검사
			nr = r-1; nc = j-1;
			while(inRange(nr, nc)) {
				if(board[nr][nc]) {
					isPossible = false;
					break;
				}
				nr--; nc--;
			}
			if(!isPossible) continue;
			// 3. 역 대각 검사
			nr = r-1; nc = j + 1;
			while(inRange(nr, nc)) {
				if(board[nr][nc]) {
					isPossible = false;
					break;
				}
				nr--; nc++;
			}
			if(!isPossible) continue;
			
			board[r][j] = true; 
			N_Queen(r+1);
			board[r][j] = false;
		}
		
	}

	private static boolean inRange(int i, int j) {
		if(i < 0 || i >= N || j < 0 || j >=N) return false;
		return true;
	}
}