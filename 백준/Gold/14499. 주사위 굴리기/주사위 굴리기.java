import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	
	static int[][] dice;
	static int[][] board;
	static int N, M, x, y, K;
	static int[] moveArr;
	
	static final int[] dx = {0, 0, -1, 1};
	static final int[] dy = {1, -1, 0, 0};
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		dice = new int[4][3];
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		x = Integer.parseInt(st.nextToken());
		y = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		
		board = new int[N][M];
		for(int i = 0; i < N; ++i) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < M; ++j) {
				board[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		st = new StringTokenizer(br.readLine());
		
		moveArr = new int[K];
		for(int i = 0; i < K; ++i) {
			moveArr[i] = Integer.parseInt(st.nextToken())-1;
		}
		
		for(int d : moveArr) {
			
			x += dx[d];
			y += dy[d];
			
			if(x < 0 || x >= N || y < 0 || y >= M) {
				x -= dx[d];
				y -= dy[d];
				continue;
			}
			
			// 1. move dice
			moveDice(d);
			
			// 2. copy value
			copyValue();
			
			// 3. print
			System.out.println(dice[1][1]);
		}

	}

	private static void copyValue() {
		
		int num = board[x][y];
		int bottom = dice[3][1];
		
		if(num == 0) {
			board[x][y] = bottom;
		}else {
			dice[3][1] = num;
			board[x][y] = 0;
		}
		
	}

	private static void moveDice(int d) {
		int temp;
		if(d == 0) {
			temp = dice[3][1];
			dice[3][1] = dice[1][2];
			dice[1][2] = dice[1][1];
			dice[1][1] = dice[1][0];
			dice[1][0] = temp;
		}else if(d == 1) {
			temp = dice[3][1];
			dice[3][1] = dice[1][0];
			dice[1][0] = dice[1][1];
			dice[1][1] = dice[1][2];
			dice[1][2] = temp;
		}else if(d == 2) {
			temp = dice[0][1];
			dice[0][1] = dice[1][1];
			dice[1][1] = dice[2][1];
			dice[2][1] = dice[3][1];
			dice[3][1] = temp;
		}else if(d == 3) {
			temp = dice[3][1];
			dice[3][1] = dice[2][1];
			dice[2][1] = dice[1][1];
			dice[1][1] = dice[0][1];
			dice[0][1] = temp;
		}
		
	}

}