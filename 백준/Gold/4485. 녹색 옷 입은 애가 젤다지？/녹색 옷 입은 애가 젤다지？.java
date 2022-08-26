import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {

	static class Link{
		int x, y, score;

		public Link(int x, int y, int score) {
			super();
			this.x = x;
			this.y = y;
			this.score = score;
		}
		
	}
	
	static int[][] map, minMap;
	static final int INF = Integer.MAX_VALUE;
	static int[] dx = {0, 1, 0, -1};
	static int[] dy = {1, 0, -1, 0};
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuffer sb = new StringBuffer();
		StringTokenizer st;
		
		int tc = 1;
		while(true) {
			int N = Integer.parseInt(br.readLine());
			if( N == 0) break;
			
			map = new int[N][N];
			
			for(int i = 0; i<N; i++) {
				st = new StringTokenizer(br.readLine());
				for(int j = 0; j < N; j++)
					map[i][j] = Integer.parseInt(st.nextToken());
			}
			
			minMap = new int[N][N];
			for(int i = 0; i < N; i++) {
				Arrays.fill(minMap[i], INF);
			}
		
			PriorityQueue<Link> pq = new PriorityQueue<>((l1, l2) -> l1.score - l2.score);
			pq.add(new Link(0, 0, map[0][0]));
			
			while(!pq.isEmpty()) {
				
				Link cur = pq.poll();
				if(cur.score > minMap[cur.x][cur.y]) continue;
				minMap[cur.x][cur.y]= cur.score; 
				
				
				for(int d = 0, dSize = dx.length; d < dSize; d++) {
					int nx = cur.x + dx[d];
					int ny = cur.y + dy[d];
					
					if(nx < 0 || nx >= N || ny < 0 || ny >=N) continue;
					int score = map[nx][ny] + cur.score;
					if(minMap[nx][ny] > score) {
						minMap[nx][ny] = score;
						pq.add(new Link(nx, ny, minMap[nx][ny]));
					}
				}
				
			}
			
			sb.append("Problem " + tc++ +": " + minMap[N-1][N-1] + "\n");
		}
		
		bw.write(sb.toString());
		bw.close();
		
	}

}