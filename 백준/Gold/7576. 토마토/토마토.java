import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int N, M, total;
	static int[][] map;
	static int[] dx = {-1, 0, 1, 0};
	static int[] dy = {0, 1, 0, -1};

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;

		st = new StringTokenizer(br.readLine());
		M = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());

		map = new int[N][M];
		
		Queue<Point> q = new LinkedList<>();
		total = N * M;
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if(map[i][j] == 1) {
					q.add(new Point(i, j)); 
					total--;
				}
				else if(map[i][j] == -1) total--;
			}
		}

		int res = tomato(q);
		sb.append(res);
		System.out.println(sb);

	}

	private static int tomato(Queue<Point> q) {
		int time = 0;
		while(!q.isEmpty()) {
			if(total == 0) return time;
			
			int qSize = q.size();
			for(int i = 0; i < qSize; i++) {
				Point cur = q.poll();
				
				for(int d = 0, dSize = dx.length; d < dSize; d++) {
					int nx = cur.x + dx[d];
					int ny = cur.y + dy[d];
					
					if(nx < 0 || nx >= N || ny < 0 || ny >= M || map[nx][ny] != 0) continue;
					
					map[nx][ny] = 1;
					q.add(new Point(nx, ny));
					total--;
				}
				
			}
			
			time++;
		}
		if(total == 0) return time;
		
		return -1;
	}

	static class Point {
		int x, y;

		public Point(int x, int y) {
			super();
			this.x = x;
			this.y = y;
		}
	}

}