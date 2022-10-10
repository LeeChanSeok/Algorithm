import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	
	static final int[] dx = {0, 1, 0, -1};
	static final int[] dy = {-1, 0, 1, 0};
	
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int N = Integer.parseInt(br.readLine());
		
		int[][] board = new int[N][N];
		for(int i = 0; i < N; ++i) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < N; ++j)
				board[i][j] = Integer.parseInt(st.nextToken());
		}
		
		int tx, ty, nx, ny, ndir;
		tx = ty = N/2;
		
		int[] sandRate = new int[6];
		boolean[][] visit = new boolean[N][N];
		visit[tx][ty] = true;
		
		int dir = 0;
		int answer = 0;
		do {
			nx = tx + dx[dir]; ny = ty + dy[dir];
			// 1. 모래 비율 정하기
			calcSandRate(board[nx][ny], sandRate);
			
			// 2. 모래 이동 시키기
			answer += moveSand(N, nx, ny, dir, board, sandRate);
			board[nx][ny] = 0;
			
			// 3. 토네이도 이동하기
			tx = nx; ty = ny;
			visit[tx][ty] = true;
			
			// 4. 방향 결정하기
			ndir = (dir + 1) % 4;
			nx = tx + dx[ndir];
			ny = ty + dy[ndir];
			
			if(!visit[nx][ny]) dir = ndir;
			
		}while(tx != 0 || ty != 0);
		
		System.out.println(answer);
	}
	
	private static int moveSand(int N, int nx, int ny, int dir, int[][] board, int[] sandRate) {
		
		int outSand = 0;
		int sx, sy; // sand 이동 좌표
		
		// 1 %
		sx = nx - dx[dir] + dy[dir]; sy = ny - dy[dir] + dx[dir];
		outSand += putSand(N, sx, sy, board, sandRate, 0);
		sx = nx - dx[dir] - dy[dir]; sy = ny - dy[dir] - dx[dir];
		outSand += putSand(N, sx, sy, board, sandRate, 0);
		
		// 2 %
		sx = nx + dy[dir]*2; sy = ny + dx[dir]*2;
		outSand += putSand(N, sx, sy, board, sandRate, 1);
		sx = nx - dy[dir]*2; sy = ny - dx[dir]*2;
		outSand += putSand(N, sx, sy, board, sandRate, 1);
		
		// 5 %
		sx = nx + dx[dir]*2; sy = ny + dy[dir]*2;
		outSand += putSand(N, sx, sy, board, sandRate, 2);
		
		// 7 %
		sx = nx + dy[dir]; sy = ny + dx[dir];
		outSand += putSand(N, sx, sy, board, sandRate, 3);
		sx = nx - dy[dir]; sy = ny - dx[dir];
		outSand += putSand(N, sx, sy, board, sandRate, 3);
		
		// 10 %
		sx = nx + dx[dir] + dy[dir]; sy = ny + dy[dir] + dx[dir];
		outSand += putSand(N, sx, sy, board, sandRate, 4);
		sx = nx + dx[dir] - dy[dir]; sy = ny + dy[dir] - dx[dir];
		outSand += putSand(N, sx, sy, board, sandRate, 4);
		
		// a %
		sx = nx + dx[dir]; sy = ny + dy[dir];
		outSand += putSand(N, sx, sy, board, sandRate, 5);
		
		return outSand;
	}


	private static int putSand(int N, int sx, int sy, int[][] board, int[] sandRate, int sandIdx) {
		if(inRange(N, sx, sy)) {
			board[sx][sy] += sandRate[sandIdx];
		}else {
			return sandRate[sandIdx];
		}
		
		return 0;
	}

	private static boolean inRange(int N, int sx, int sy) {
		if(sx < 0 || sx >= N || sy < 0 || sy >= N) return false;
		return true;
	}

	private static void calcSandRate(int sand, int[] sandRate) {
		
		sandRate[0] = (int)(sand * 0.01); // 1 %
		sandRate[1] = (int)(sand * 0.02); // 2 %
		sandRate[2] = (int)(sand * 0.05); // 5 %
		sandRate[3] = (int)(sand * 0.07); // 7 %
		sandRate[4] = (int)(sand * 0.1); // 10 %
		sandRate[5] = sand - (sandRate[0] * 2 + sandRate[1] * 2 + sandRate[2] + sandRate[3] * 2 + sandRate[4] * 2);
		
	}

}