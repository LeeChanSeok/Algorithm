import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	
	static int dx[] = {-2, -2, -1, -1, 1, 1, 2, 2};
	static int dy[] = {-1, 1, -2, 2, -2, 2, -1, 1};
	
	static int N, M;
	static int[][] dist;
	static int kx, ky;
	static int[][] Es;

	public static void main(String[] args) throws IOException {

		input();
		pro();
		
	}

	private static void pro() {

		bfs();
		
		StringBuilder sb = new StringBuilder();
		for(int i = 0; i < M; ++i) {
			sb.append(dist[Es[i][0]][Es[i][1]]).append(' ');
		}
		
		System.out.println(sb.toString());
		
	}

	private static void bfs() {

		Queue<Integer> que = new LinkedList<>();
		que.offer(kx);
		que.offer(ky);
		
		dist[kx][ky] = 0;
		
		while(!que.isEmpty()) {
			int x = que.poll();
			int y = que.poll();
			
			for(int d = 0; d < 8; ++d) {
				int nx = x + dx[d];
				int ny = y + dy[d];
				
				if(nx < 0 || nx >= N || ny < 0 || ny >= N) continue;
				if(dist[nx][ny] != -1) continue;
				
				dist[nx][ny] = dist[x][y] + 1;
				que.offer(nx);
				que.offer(ny);

			}
		}
		
	}

	private static void input() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		dist = new int[N][N];
		for(int i = 0; i < N; ++i) {
			Arrays.fill(dist[i], -1);
		}
		st = new StringTokenizer(br.readLine());
		kx = Integer.parseInt(st.nextToken()) - 1;
		ky = Integer.parseInt(st.nextToken()) - 1;
		
		Es = new int[M][2];
		for(int i = 0; i < M; ++i) {
			st = new StringTokenizer(br.readLine());
			Es[i][0] = Integer.parseInt(st.nextToken()) - 1;
			Es[i][1] = Integer.parseInt(st.nextToken()) - 1;
		}
		
	}

}