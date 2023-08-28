import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
	
	static int n = 5;
	static int m = 9;
	
	static char[][] board = new char[n][m];
	static int[][] pos = new int[12][2];
	static int[] star = new int[12];
	static int flag;
	
	public static void main(String[] args) throws Exception {
		input();
		pro();
	}

	private static void pro() {

		recursive(0, flag);
		
	}

	private static boolean recursive(int idx, int flag) {

		if(!isHeagram()) return false;
		
		if(idx == 12) {
			printArr();
			return true;
		}
		
		if(star[idx] != -100) {
			if(recursive(idx + 1, flag)) 
				return true;
		}
		else {
			for(int i = 1; i <= 12; ++i) {
				if(((1 << i) & flag) != 0) continue;
				star[idx] = i;
				if(recursive(idx + 1, flag | (1 << i))) 
					return true;
				star[idx] = -100;
			}
		}
		
		return false;
	}

	private static void printArr() {

		for(int i = 0; i < 12; ++i) {
			int x = pos[i][0];
			int y = pos[i][1];
			
			board[x][y] = (char)('A' + star[i] - 1);
			
		}
		
		StringBuilder sb = new StringBuilder();
		for(int i = 0; i < n; ++i) {
			for(int j = 0; j < m; ++j) {
				sb.append(board[i][j]);
			}
			sb.append('\n');
		}
		
		System.out.println(sb);
		
	}

	private static boolean isHeagram() {

		int num = star[0] + star[2] + star[5] + star[7];
		if(num != 26 && num > 0) return false;
		
		num = star[0] + star[3] + star[6] + star[10];
		if(num != 26 && num > 0) return false;
		
		num = star[7] + star[8] + star[9] + star[10];
		if(num != 26 && num > 0) return false;
		
		num = star[1] + star[2] + star[3] + star[4];
		if(num != 26 && num > 0) return false;
		
		num = star[1] + star[5] + star[8] + star[11];
		if(num != 26 && num > 0) return false;
		
		num = star[4] + star[6] + star[9] + star[11];
		if(num != 26 && num > 0) return false;
		
		return true;
	}

	private static void input() throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		for(int i = 0; i < n; ++i) {
			board[i] = br.readLine().toCharArray();
		}
		
		Arrays.fill(star, -100);
		
		int cnt = 0;
		for(int i = 0; i < n; ++i) {
			for(int j = 0; j < m; ++j) {
				if(board[i][j] != '.') {
					
					pos[cnt][0] = i;
					pos[cnt][1] = j;
					
					if(board[i][j] != 'x') {
						int num = board[i][j] - 'A' + 1;
						star[cnt] = num;
						flag |= (1 << num);
					}
					++cnt;
				}
			}
		}
		
	}

}