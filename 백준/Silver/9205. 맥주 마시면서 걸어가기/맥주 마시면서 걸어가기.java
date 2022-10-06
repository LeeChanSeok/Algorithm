import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	static class Point{
		int x, y;

		public Point(int x, int y) {
			super();
			this.x = x;
			this.y = y;
		}
		
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		
		int n, x, y, N;
		int INF = Integer.MAX_VALUE;
		Point[] positions;
		int[][] dist;
		int T = Integer.parseInt(br.readLine());
		for(int tc = 1; tc <= T; ++tc) {
			n = Integer.parseInt(br.readLine());
			N = n+2;
			// 좌표 정보 저장
			positions = new Point[n+2];
			
			for(int i = 0; i < N; ++i) {
				st = new StringTokenizer(br.readLine());
				x = Integer.parseInt(st.nextToken());
				y = Integer.parseInt(st.nextToken());
				
				positions[i] = new Point(x, y);
			}
			
			// 각 좌표간의 최단 거리를 FW를 이용하여 계산
			dist = new int[N][N];
			for(int i = 0; i < N; ++i) {
				Arrays.fill(dist[i], INF);
			}
			
			for(int k = 0; k < N; ++k) {
				for(int i = 0; i < N; ++i) {
					for(int j = 0; j < N; ++j) {
						if(i == j) dist[i][j] = 0;
						else
							dist[i][j] = Math.min(dist[i][j], calc_dist(positions[i], positions[k]) + calc_dist(positions[k], positions[j]));
					}
				}
			}
			
			boolean happy = bfs(N, positions, dist);
			
			if(happy) sb.append("happy\n");
			else sb.append("sad\n");
		}

		bw.write(sb.toString());
		bw.close();
	}

	private static boolean bfs(int N, Point[] positions, int[][] dist) {

		Queue<Integer> q = new LinkedList<>();
		q.add(0);
		
		boolean[] visit = new boolean[N];
		visit[0] = true;
		
		int cur;
		
		while(!q.isEmpty()) {
			cur = q.poll();
			
			if(cur == N-1) return true;
			
			for(int d = 0; d < N; ++d) {
				if(!visit[d] && dist[cur][d] <= 1000) {
					q.add(d);
					visit[d] = true;
				}
			}
		}
		
		return false;
	}

	private static int calc_dist(Point point, Point point2) {
		return Math.abs(point.x - point2.x) + Math.abs(point.y - point2.y);
	}

}