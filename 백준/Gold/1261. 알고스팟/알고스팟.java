import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main{

	static final int[] dx = {-1, 1, 0, 0};
	static final int[] dy = {0, 0, -1, 1};
	
	static int N, M;
	static final int DELTA = 1000;
	static char[][] board;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		M = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());
		
		board = new char[N][M];
		for(int i = 0; i < N; ++i) {
			board[i] = br.readLine().toCharArray();
		}
		
		int answer = bfs();
		System.out.println(answer);
	}

	private static int bfs() {
		
		boolean[][] visited = new boolean[N][M];
		visited[0][0] = true;
		
		PriorityQueue<int[]> pq = new PriorityQueue<>((p1, p2) ->  p1[1] - p2[1]);
		pq.offer(new int[] {0, 0});
		
		while(!pq.isEmpty()) {
			int[] cur = pq.poll();
			int x = cur[0] / DELTA;
			int y = cur[0] % DELTA;
			
			if(x == N-1 && y == M-1) return cur[1];
			
			for(int d = 0; d < 4; ++d) {
				int nx = x + dx[d];
				int ny = y + dy[d];
				
				if(nx < 0 || nx >= N || ny < 0 || ny >= M || visited[nx][ny]) continue;
				
				if(board[nx][ny] == '0') pq.offer(new int[] {nx * DELTA + ny, cur[1]});
				else pq.offer(new int[] {nx*DELTA + ny, cur[1]+1});
				
				visited[nx][ny] = true;
				
			}
		}
		
		return 0;
	}

}
