import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {

	static int N;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = 9;
		char[][] board = new char[N][N];
		
		for(int i = 0; i < N; ++i)
			board[i] = br.readLine().toCharArray();
		
		Sudoku(board, N, 0);
		
		for(int i = 0; i < N; ++i)
			System.out.println(new String(board[i]));
	}
	
	private static boolean Sudoku(char[][] board, int N, int point) {
		
		if(point == N*N) 
			return true;

		int x = point / N;
		int y = point % N;
		
		if(board[x][y] != '0') {
			if(Sudoku(board, N, point+1)) 
				return true;
		}
		else {
			for(int i = 1; i < 10; ++i) {
				board[x][y] = (char)(i + '0');
				if(rowCheck(board, N, point) && colCheck(board, N, point) && squareCheck(board, N, point)) {
					if(Sudoku(board, N, point+1)) 
						return true;
				}
				board[x][y] = '0';
			}
		}
		
		return false;
		
	}

	static boolean squareCheck(char[][] board, int N, int point) {
		int x = point / N;
		int y = point % N;
		
		boolean isRight = true;
		int[] number = new int[N+1];
		int idx;
		int r = 3*(x/3);
		int c = 3*(y/3);
		for(int i = r; i < r+3; ++i) {
			for(int j = c; j < c+3; ++j) {
				idx = board[i][j] - '0';
				if(board[i][j] != '0' 
						&& number[idx] != 0) return false;
				++number[idx]; 
			}
		}
		
		return isRight;
	}
	
	static boolean colCheck(char[][] board, int N, int point) {
		int x = point / N;
		int y = point % N;
		
		boolean isRight = true;
		int[] number = new int[N+1];
		int idx;
		for(int i = 0; i < N; ++i) {
			idx = board[i][y] - '0';
			if(board[i][y] != '0' && number[idx] != 0) return false;
			++number[idx]; 
		}
		
		return isRight;
	}

	static boolean rowCheck(char[][] board, int N, int point) {
		int x = point / N;
		int y = point % N;
		
		boolean isRight = true;
		int[] number = new int[N+1];
		int idx;
		for(int j = 0; j < N; ++j) {
			idx = board[x][j] - '0';
			if(board[x][j] != '0' && number[idx] != 0) return false;
			++number[idx]; 
		}
		
		return isRight;
	}
	
}