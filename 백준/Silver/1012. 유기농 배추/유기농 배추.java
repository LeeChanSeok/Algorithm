import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static class Point{
		int x, y;

		public Point(int x, int y) {
			this.x = x;
			this.y = y;
		}
		
	}
	
	static int T, N, M, K;
	static int arr[][];
	
	static final int[] dx = {0, 1, 0, -1};
	static final int[] dy = {1, 0, -1, 0};
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int T = Integer.parseInt(br.readLine());
		for(int tc =1; tc<=T; tc++) {
			st = new StringTokenizer(br.readLine());			
			M = Integer.parseInt(st.nextToken());
			N = Integer.parseInt(st.nextToken());
			K = Integer.parseInt(st.nextToken());
			
			arr = new int[N][M];
			for(int i = 0; i <K; i++) {
				st = new StringTokenizer(br.readLine());
				int c = Integer.parseInt(st.nextToken());
				int r = Integer.parseInt(st.nextToken());
				arr[r][c] = 1;
			}
			
			int res = 0;
			for(int i = 0; i < N; i++) {
				for(int j = 0; j < M; j++) {
					if(arr[i][j] == 1) {
						solution(i, j);
						res++;
					}
				}
				
			}
			System.out.println(res);
		}
		
	}

	private static void solution(int i, int j) {
		
		Queue<Point> q = new ArrayDeque<>();
		q.offer(new Point(i, j));
		arr[i][j] = 0;
		while(!q.isEmpty()) {
			Point cur = q.poll();
			
			for(int d = 0; d < 4; d++) {
				int nx = cur.x + dx[d];
				int ny = cur.y + dy[d];
				
				if(nx < 0 || nx >= N || ny < 0 || ny >= M || arr[nx][ny] == 0) continue;
				
				arr[nx][ny] = 0;
				q.add(new Point(nx, ny));
			}
		}
		
	}

}
