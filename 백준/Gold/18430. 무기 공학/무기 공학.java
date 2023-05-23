import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	
	static int[][] dx = {
			{0, 1},
			{-1, 0},
			{-1, 0},
			{0, 1},
	};
	static int[][] dy = {
			{-1, 0},
			{0, -1},
			{0, 1},
			{1, 0},
	};
	
	static int N, M, NM;
	static int[][] tree;
	static boolean[][] visited;
	static int answer;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		NM = N * M;
		
		tree = new int[N][M];
		for(int i = 0; i < N; ++i) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < M; ++j) {
				tree[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		visited = new boolean[N][M];
		answer = 0;
		
		recursive(0, 0);
		System.out.println(answer);
	}

	private static void recursive(int pos, int score) {
		int x = pos / M;
		int y = pos % M;
		
		if(x == N) {
			answer = Math.max(answer, score);
			return;
		}
		
		int nx, ny, s;
		if(visited[x][y]) recursive(pos + 1, score);
		else {
			for(int b =  0; b < 4; ++b) {
				s = isMake(x, y, b);
				if(s == 0) continue;
				
				isUse(x, y, b);
				recursive(pos+1, score + s);
				unUse(x, y, b);
			}
			recursive(pos+1,score);
		}
		
	}

	private static void unUse(int x, int y, int b) {

		int nx, ny;
		visited[x][y] = false;
		for(int d = 0; d < 2; ++d) {
			nx = x + dx[b][d];
			ny = y + dy[b][d];
			visited[nx][ny] = false;
		}
	}

	private static void isUse(int x, int y, int b) {
		
		int nx, ny;
		visited[x][y] = true;
		for(int d = 0; d < 2; ++d) {
			nx = x + dx[b][d];
			ny = y + dy[b][d];
			visited[nx][ny] = true;
		}
		
		
	}

	private static int isMake(int x, int y, int b) {
		int nx, ny, score;
		score = 0;
		for(int d = 0; d < 2; ++d) {
			nx = x + dx[b][d];
			ny = y + dy[b][d];
			if(nx < 0 || nx >= N || ny < 0 || ny >= M || visited[nx][ny]) return 0;
			score += tree[nx][ny];
		}
		
		return score + tree[x][y]*2;
	}

}
