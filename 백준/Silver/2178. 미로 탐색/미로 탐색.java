import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {

	static int[] dx = {-1, 1, 0, 0};
	static int[] dy = {0, 0, -1, 1};
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		char[][] board = new char[N][M];
		for(int i = 0; i < N; ++i)
			board[i] = br.readLine().toCharArray();
		
		System.out.println(bfs(board, N, M));

	}

	private static int bfs(char[][] board, int N, int M) {
		int res = 0;
		
		PriorityQueue<int[]> pq = new PriorityQueue<>((p1, p2) -> p1[2] - p2[2]);
		pq.offer(new int[] {0, 0, 1});
		
		int[][] visit = new int[N][M];
		int INF = Integer.MAX_VALUE;
		for(int i = 0; i < N; ++i)
			Arrays.fill(visit[i], INF);
		
		visit[0][0] = 0;
		
		int[] cur;
		int x, y, nx, ny, dist;
		while(!pq.isEmpty()) {
			cur = pq.poll();
			x = cur[0];
			y = cur[1];
			dist = cur[2];
			
			if(x == N-1 && y == M-1) {
				res = dist;
				break;
			}
			
			for(int d = 0; d < 4; ++d) {
				nx = x + dx[d];
				ny = y + dy[d];
				
				if(nx < 0 || nx >= N || ny < 0 || ny >= M || board[nx][ny] == '0') continue;
				
				if(visit[nx][ny] > dist + 1) {
					visit[nx][ny] = dist + 1;
					pq.offer(new int[] {nx, ny, dist+1});
					
				}
			}
		}
		
		return res;
	}

}