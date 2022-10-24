import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	// 0 : 상, 1 : 하, 2 : 좌, 3 : 우
	static int[] dr = {-1, 1, 0, 0};
	static int[] dc = {0, 0, -1, 1};
	
	static int ansR, ansC;
	static char block;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int R, C;
		char[][] board;

			st = new StringTokenizer(br.readLine());
			
			R = Integer.parseInt(st.nextToken());
			C = Integer.parseInt(st.nextToken());
			
			board = new char[R][C];
			for(int i = 0; i < R; ++i)
				board[i] = br.readLine().toCharArray();
			
			simulation(R, C, board);
			System.out.printf("%d %d %c\n", ansR+1, ansC+1, block);

	}

	private static void simulation(int R, int C, char[][] board) {
	
		// 1. M과 Z의 인접 부분에 블록이 있는지 확인
		int nr, nc, check, d;
		
		for(int r = 0; r < R; ++r) {
			for(int c = 0; c < C; ++c) {
				if(board[r][c] != '.') continue;
				
				check = 0;
				for(d = 0; d < 4; ++d) {
					nr = r + dr[d]; nc = c + dc[d];
					if(nr < 0 || nr >= R || nc < 0 || nc >= C 
							|| board[nr][nc] == '.' || board[nr][nc] == 'M' || board[nr][nc] == 'Z') 
						continue;
					
					if(isLink(d, board[nr][nc])) {
						check |= 1 << d;
					}
				}
				
				if(check == 0) continue;
				
				ansR = r; ansC = c;
				block = findBlock(check); 
				
				return;
			}
		}
	
	}

	private static char findBlock(int check) {
		if(check == 3) return '|';
		else if(check == 12) return '-';
		else if(check == 15) return '+';
		else if(check == 10) return '1';
		else if(check == 9) return '2';
		else if(check == 5) return '3';
		else if(check == 6) return '4';
		
		return 0;
	}

	private static boolean isLink(int d, char block) {
		
		if(d == 0) {
			if(block =='|' || block == '+' || block == '1' || block == '4') return true;
		}else if(d == 1) {
			if(block =='|' || block == '+' || block == '2' || block == '3') return true;
		}else if(d == 2) {
			if(block =='-' || block == '+' || block == '1' || block == '2') return true;
		}else if(d == 3) {
			if(block =='-' || block == '+' || block == '3' || block == '4') return true;
		}
		
		return false;
	}

}