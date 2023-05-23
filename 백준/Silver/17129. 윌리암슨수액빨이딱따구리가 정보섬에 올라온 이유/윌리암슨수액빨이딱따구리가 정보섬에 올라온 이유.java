import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	static final int[] dx = {-1, 1, 0, 0};
	static final int[] dy = {0, 0, -1, 1};
	
	static int sx, sy;
	static char[][] board;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		board = new char[N][M];
		for(int i = 0; i < N; ++i) {
			board[i] = br.readLine().toCharArray();
		}
		
		find_start(N, M);
		board[sx][sy] = '0';
		
		int answer = solution(N, M);
		if(answer == -1) {
			System.out.println("NIE");
		}else {
			System.out.println("TAK\n"+answer);
		}
		
	}

	private static int solution(int n, int m) {

		int DELTA = 3000;
		
		boolean[][] visited = new boolean[n][m];
		visited[sx][sy] = true;
		
		Queue<Integer> q = new LinkedList<>();
		q.offer(sx*DELTA + sy);
		
		int qSize;
		int cur;
		int x, y, nx, ny;
		int move = 0;
		while(!q.isEmpty()) {
			qSize = q.size();
			
			while(qSize-- > 0) {
				cur = q.poll();
				
				x = cur / DELTA; y = cur % DELTA;
				
				if(board[x][y] != '0') {
					return move;
				}
				
				for(int d = 0; d < 4; ++d) {
					nx = x + dx[d];
					ny = y + dy[d];
					
					if(nx < 0 || nx >= n || ny < 0 || ny >= m || board[nx][ny] == '1'|| visited[nx][ny]) continue;
					
					visited[nx][ny] = true;
					q.offer(nx * DELTA + ny);
				
				}
				
			}
			
			++move;
		}
		
		return -1;
	}

	private static void find_start(int n, int m) {
		for(int i = 0; i < n; ++i) {
			for(int j = 0; j < m; ++j) {
				if(board[i][j] == '2') {
					sx = i; sy = j;
					return;
				}
			}
		}
	}

}