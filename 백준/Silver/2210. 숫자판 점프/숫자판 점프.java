import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class Main {
	
	static final int N = 5;
	static final int[] dx = {-1, 1, 0, 0};
	static final int[] dy = {0, 0, -1, 1};
	
	static Set<String> numbers;
	static char[][] board;
	
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		board = new char[N][N];
		for(int i = 0; i < N; ++i) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < N; ++j) {
				board[i][j] = st.nextToken().charAt(0);
			}
		}
		
		numbers = new HashSet<>();
		char[] numStr = new char[N+1];
		for(int i = 0; i < N; ++i) {
			for(int j = 0; j < N; ++j) {
				recursive(0, i, j, numStr);
			}
		}
		
		System.out.println(numbers.size());
	}

	private static void recursive(int idx, int x, int y, char[] numStr) {

		if(idx == N+1) {
			numbers.add(char2String(numStr));
			return;
		}
		numStr[idx] = board[x][y];
		
		int nx, ny;
		for(int d = 0; d < 4; ++d) {
			nx = x + dx[d];
			ny = y + dy[d];
		
			if(nx < 0 || nx >= N || ny < 0 || ny >= N) continue;
			recursive(idx + 1, nx, ny, numStr);
		}
	}

	private static String char2String(char[] ch) {
		StringBuilder sb = new StringBuilder();
		for(int i = 0; i <= N; ++i) sb.append(ch[i]);
		
		return sb.toString();
	}
	
}