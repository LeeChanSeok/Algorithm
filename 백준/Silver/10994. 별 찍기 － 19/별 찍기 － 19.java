import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

public class Main {

	static int ex, ey;
	static char[][] board;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		int N = Integer.parseInt(br.readLine());
		
		int side = 1 + (N-1)*4;
		board = new char[side][side];
		for(int i = 0; i < side; ++i) Arrays.fill(board[i], ' ');
	
		ex = ey = side/2;
		recursive(0, 0, side);
		
		for(int i = 0; i < side; ++i) {
			for(int j = 0; j < side; ++j) {
				sb.append(board[i][j]);
			}
			sb.append("\n");
		}
		
		bw.write(sb.toString());
		bw.flush();
		
		bw.close();
		br.close();
	}
	
	private static void recursive(int x, int y, int side) {
		if(x == ex && y == ey) {
			board[x][y] = '*';
			return;
		}
		
		for(int i = 0; i < side; ++i) {
			board[x][y+i] = board[x + side-1][y+i] = '*';
		}
		
		for(int i = 1; i < side - 1; ++i) {
			board[x+i][y] = board[x+i][y+side-1] = '*';
		}
		
		recursive(x+2, y+2, side-4);
	}

}