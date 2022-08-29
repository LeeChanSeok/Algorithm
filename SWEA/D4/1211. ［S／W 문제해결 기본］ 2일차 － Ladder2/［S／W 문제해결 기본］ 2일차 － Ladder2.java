import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
	static final int N = 100, T = 10, INF = Integer.MAX_VALUE;
	static int min, maxX;
	
	static char[][] ladder;
	static int[] dx = {0, 1, 0};
	static int[] dy = {-1, 0, 1};
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		for(int tc = 1; tc <= T; tc++) {
			br.readLine();
			ladder = new char[N][N];
			for(int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				for(int j = 0; j < N; j++)
					ladder[i][j] = st.nextToken().charAt(0);
			}
			maxX = -1;
			min = Integer.MAX_VALUE;
			solution();
			
			System.out.println("#" + tc + " " + maxX);
		}

	}

	private static void solution() {
		for(int c = 0; c < N; c++) {
			if(ladder[0][c] == '1') {
				int move = go(c);
				if(move <= min) {
					min = move;
					maxX = c;
				}
				
			}
		}
		
	}

	private static int go(int c) {
		int dir = 1;
		int x = 0;
		int y = c;
		int move = 0;
		while(x != N-1) {
			if(dir % 2 == 0) { // 좌 우로 이동하는 경우
				int nx = x + dx[1];
				int ny = y + dy[1];
				if(inRange(nx, ny) && ladder[nx][ny] == '1')	dir = 1;
			}else {
				for(int d = 0; d < 2; d++) {
					int nx = x + dx[2*d];
					int ny = y + dy[2*d];
					if(inRange(nx, ny) && ladder[nx][ny] == '1') dir = 2*d;
				}
			}
			
			x += dx[dir];
			y += dy[dir];
			
			if(++move > min) return INF;
		}
		
		return move;
	}
	
	private static boolean inRange(int x, int y) {
		if(x < 0 || x >= N || y < 0 || y >= N) return false;
		return true;
	}

}