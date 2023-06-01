import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	static int[] dx = {1, 0};
	static int[] dy = {0, 1};
	
	static int N;
	static char[][] board;
	static int[] answer = new int[2];
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		N = Integer.parseInt(br.readLine());
		
		board = new char[N][N];
		for(int i = 0; i < N; ++i) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < N; ++j) {
				board[i][j] = st.nextToken().charAt(0);
			}
		}
		answer[0] = Integer.MIN_VALUE;
		answer[1] = Integer.MAX_VALUE;
		solution(0, 0, 0, '+');
		System.out.println(answer[0] + " " + answer[1]);
	}

	private static void solution(int x, int y, int sum, char prev) {
		
		if(x == N - 1 && y == N - 1) {
			
			sum = calc(sum, (int)(board[x][y] - '0'), prev);
			
			answer[0] = Math.max(answer[0], sum);
			answer[1] = Math.min(answer[1], sum);
			return;
		}
		
		if(board[x][y] >= '0' && board[x][y] <= '5') 
			sum = calc(sum, (int)(board[x][y] - '0'), prev);
		prev = board[x][y];
		
		int nx, ny;		
		for(int d = 0; d < 2; ++d) {
			nx = x + dx[d];
			ny = y + dy[d];
			
			if(nx < 0 || nx >= N || ny < 0 || ny >= N) continue;
			solution(nx, ny, sum, prev);
			
		}
		
	}

	private static int calc(int sum, int num, char prev) {
		
		if(prev == '+') sum += num;
		else if(prev == '-') sum -= num;
		else if(prev == '*') sum *= num;
		
		return sum;
	}

}