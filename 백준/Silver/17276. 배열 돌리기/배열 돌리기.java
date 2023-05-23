import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;

		int T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= T; ++tc) {
			int n, d, half;
			st = new StringTokenizer(br.readLine());

			n = Integer.parseInt(st.nextToken());
			d = Integer.parseInt(st.nextToken());
			half = n / 2;
			int[][] board = new int[n][n];
			for (int i = 0; i < n; ++i) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < n; ++j) {
					board[i][j] = Integer.parseInt(st.nextToken());
				}
			}

            int rot_cnt = 0;
			d = (d+360)%360;
			rot_cnt = d / 45;
			
			if(rot_cnt >= 4) {
				rot_cnt = 8 - rot_cnt;
				for(int i = 0; i < rot_cnt; ++i) 
					reverse_rotate(n, half, board);
			}else {
				for(int i = 0; i < rot_cnt; ++i) 
					rotate(n, half, board);
			}
			print(sb, board);
		}
		
		bw.write(sb.toString());
		bw.flush();
		
		bw.close();
		br.close();
	}

	private static void print(StringBuilder sb, int[][] board) {
		int n = board.length;
		for(int i = 0; i < n; ++i) {
			for(int j = 0; j < n; ++j) {
				sb.append(board[i][j] + " ");
			}
			sb.append("\n");
		}
	}

	private static void rotate(int n, int half, int[][] board) {

		int[] temp = new int[half];

		for (int i = 0; i < half; ++i) {
			temp[i] = board[i][half];
		}

		// 1. \ -> |
		for (int i = 0; i < half; ++i) {
			board[i][half] = board[i][i];
		}

		// 2. - -> \
		for (int i = 0; i < half; ++i) {
			board[i][i] = board[half][i];
		}

		// 3. / -> -
		for (int i = 0; i < half; ++i) {
			board[half][i] = board[n - 1 - i][i];
		}

		// 4. | -> /
		for (int i = 0; i < half; ++i) {
			board[n - 1 - i][i] = board[n - 1 - i][half];
		}

		// 5. \ -> |
		for (int i = 0; i < half; ++i) {
			board[n - 1 - i][half] = board[n - 1 - i][n - 1 - i];
		}

		// 6. - -> \
		for (int i = 0; i < half; ++i) {
			board[n - 1 - i][n - 1 - i] = board[half][n - 1 - i];
		}

		// 7. / -> -
		for (int i = 0; i < half; ++i) {
			board[half][n - 1 - i] = board[i][n - 1 - i];
		}

		// 8.| -? /
		for (int i = 0; i < half; ++i) {
			board[i][n - 1 - i] = temp[i];
		}

		
	}

	private static void reverse_rotate(int n, int half, int[][] board) {

		int[] temp = new int[half];

		for (int i = 0; i < half; ++i) {
			temp[i] = board[i][half];
		}

		// 1. / -> |
		for (int i = 0; i < half; ++i) {
			board[i][half] = board[i][n - 1 - i];
		}
		
		// 2. - -> /
		for (int i = 0; i < half; ++i) {
			board[i][n - 1 - i] = board[half][n - 1 - i];
		}
		
		// 3. \ -> -
		for (int i = 0; i < half; ++i) {
			board[half][n - 1 - i] = board[n - 1 - i][n - 1 - i];
		}
		
		// 4. | -> \
		for (int i = 0; i < half; ++i) {
			board[n - 1 - i][n - 1 - i] = board[n - 1 - i][half];
		}

		// 5. / -> |
		for (int i = 0; i < half; ++i) {
			board[n - 1 - i][half] = board[n - 1 - i][i];
		}
		
		// 6. - -> /
		for (int i = 0; i < half; ++i) {
			board[n - 1 - i][i] = board[half][i];
		}
		
		// 7. \ -> -
		for (int i = 0; i < half; ++i) {
			board[half][i] = board[i][i];
		}
		
		//8. | -> \
		for (int i = 0; i < half; ++i) {
			board[i][i] = temp[i];
		}
		
	}
	
}