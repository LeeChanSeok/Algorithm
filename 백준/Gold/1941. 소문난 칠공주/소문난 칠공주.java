import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
	
	static int[] dx = {-1, 1, 0, 0};
	static int[] dy = {0, 0, -1, 1};
	static final int N = 5, M = 7;
	static int ans;
	static int[] pick;
	static char[][] board;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		board = new char[N][N];
		String str;
		char c;
		int sCnt = 0;
		
		for(int i = 0; i < N; ++i) {
			str = br.readLine();
			for(int j = 0; j < N; ++j) {
				c = str.charAt(j);
				board[i][j] = c;
				if(c == 'S') ++sCnt;
			}
		}
		
		ans = 0;
		if(sCnt >= 4) {
			pick = new int[M];
			combination(0, 0, 0);
		}
		
		System.out.println(ans);

	}

	private static void combination(int idx, int picked, int sCnt) {

		if(M - picked + sCnt < 4) return;
		
		if(picked == 7) {
			
			if(isLinked(pick, N, M)) ++ ans;
			return;
		}
		
		int x, y, s;
		for(int i = idx; i < 25; ++i) {
			x = i / N;
			y = i % N;
			
			s = board[x][y] == 'S' ? 1 : 0;
			
			pick[picked] = i;
			combination(i+1, picked+1, sCnt+s);
		}
		
	}

	
	private static boolean isLinked(int[] pick, int N, int M) {
		
		Queue<Integer> q = new LinkedList<>();
		boolean[] visit = new boolean[M];
		
		q.offer(pick[0]);
		visit[0] = true;
		
		int sCnt = 1;
		int num, x, y, nx, ny, next;
		while(!q.isEmpty()) {
			num = q.poll();
			
			x = num / N;
			y = num % N;
			
			for(int d = 0; d < 4; ++d) {
				nx = x + dx[d];
				ny = y + dy[d];
				
				if(nx < 0 || nx >= N || ny < 0 || ny >= N) continue;
				
				next = nx * N + ny;
				if(isGroup(pick, visit, M, next)) {
					q.offer(next);
					++sCnt;
				}
			}
		}
	
		if(sCnt == 7) return true;
		return false;
	}

	private static boolean isGroup(int[] pick, boolean[] visit, int M, int next) {

		for(int i = 0; i < M; ++i) {
			if(pick[i] == next && !visit[i]) {
				visit[i] = true;
				return true;
			}
		}
		
		return false;
	}

}