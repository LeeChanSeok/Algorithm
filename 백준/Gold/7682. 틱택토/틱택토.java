import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashSet;
import java.util.Set;

public class Main {

	static Set<String> TicTacToe, temp;
	static char[] board = { '.', '.', '.', '.', '.', '.', '.', '.', '.' };

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();

		TicTacToe = new HashSet<>();
		temp = new HashSet<>();
		findAllPossibleResult(true, 0);
		
		String str;
		while(!(str = br.readLine()).equals("end")) {
			if(TicTacToe.contains(str)) sb.append("valid");
			else sb.append("invalid");
			sb.append("\n");
		}
		
		bw.write(sb.toString());
		bw.flush();
		
		bw.close();
		br.close();

	}

	private static void findAllPossibleResult(boolean player, int cnt) {

		temp.add(new String(board));
		// 게임판이 가등 찬 경우
		if (cnt == 9) {
			TicTacToe.add(new String(board));
			return;
		}

		// 한쪽이 승리한 경우
		if(check('X') || check('O')) {
			TicTacToe.add(new String(board));
			return;
		}

		// 말을 두는 경우
		for (int k = 0; k < 9; ++k) {
			if (board[k] == '.') {
				if (player) board[k] = 'X';
				else board[k] = 'O';
				
				if(!temp.contains(new String(board)))
					findAllPossibleResult(!player, cnt + 1);
				board[k] = '.';
			}
		}

	}

	private static boolean check(char c) {
		
		// 가로
		for(int i = 0; i < 3; ++i) {
			if(board[3*i] == c && board[3*i + 1] == c && board[3*i + 2] == c) return true;
		}
		
		// 세로
		for(int i = 0; i < 3; ++i) {
			if(board[i]==c && board[i + 3]==c && board[i + 6] == c) return true;
		}
		
		// 대각선
		if(board[0] == c && board[4] == c && board[8] == c) return true;
		if(board[2] == c && board[4] == c && board[6] == c) return true;
		
		return false;
	}

}