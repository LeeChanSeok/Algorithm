import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	
	static final int DELTA = 100;
	static final int[] dx = {0, 1};
	static final int[] dy = {1, 0};
	
	static int N;
	static int[][] board;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		
		board = new int[N][N];
		for(int i = 0; i < N; ++i) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < N; ++j) {
				board[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		String answer = "";
		if(solution()) answer = "HaruHaru";
		else answer = "Hing";
		
		System.out.println(answer);
	
	}
	
	private static boolean solution() {
		
		boolean[][] visited = new boolean[N][N];
		visited[0][0] = true;
		
		Queue<Integer> q = new LinkedList<>();
		q.offer(0);
		
		int nx, ny, x, y;
		
		int cur;
		while(!q.isEmpty()) {
				
			cur = q.poll();
			
			x = cur / DELTA; y = cur % DELTA;
			if( x == N-1 && y == N-1) return true;
			
			for(int d = 0; d < 2; ++d) {
				nx = x + dx[d] * board[x][y];
				ny = y + dy[d] * board[x][y];
				
				if( nx < 0 || nx >= N || ny < 0 || ny >= N || visited[nx][ny]) continue;
				
				visited[nx][ny] = true;
				q.offer(nx * DELTA + ny);
			}
			
		}
				
		return false;
	}	

}
