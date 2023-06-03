import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	static int N, M;
	static int[][] board;
	
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		board = new int[N][M];
		for(int i = 0; i < N; ++i) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < M; ++j) {
				board[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		int answer = N*M*2;
		
		answer += Left();
		answer += Right();
		answer += Up();
		answer += Down();
		
		System.out.println(answer);
		
	}

	private static int Left() {

		int area = 0;
		int h = 0;
		
		for(int i = 0; i < N; ++i) {
			area += board[i][0];
			h = board[i][0];
			
			for(int j = 1; j < M; ++j) {
				if(board[i][j] > h) {
					area += board[i][j] - h; 
				}
				h = board[i][j];
			}
			
		}
		
		return area;
	}

	private static int Right() {

		int area = 0;
		int h = 0;
		
		for(int i = 0; i < N; ++i) {
			area += board[i][M-1];
			h = board[i][M-1];
			
			for(int j = M-2; j >= 0; --j) {
				if(board[i][j] > h) {
					area += board[i][j] - h; 
				}
				h = board[i][j];
			}
			
		}
		
		return area;
	}
	

	private static int Up() {

		int area = 0;
		int h = 0;
		
		for(int j = 0; j < M; ++j) {
			area += board[0][j];
			h = board[0][j];
			
			for(int i = 1; i < N; ++i) {
				if(board[i][j] > h) {
					area += board[i][j] - h; 
				}
				h = board[i][j];
			}
			
		}
		
		return area;
	}

	private static int Down() {

		int area = 0;
		int h = 0;
		
		for(int j = 0; j < M; ++j) {
			area += board[N-1][j];
			h = board[N-1][j];
			
			for(int i =N-2; i >= 0; --i) {
				if(board[i][j] > h) {
					area += board[i][j] - h; 
				}
				h = board[i][j];
			}
			
		}
		
		return area;
	}
	
}