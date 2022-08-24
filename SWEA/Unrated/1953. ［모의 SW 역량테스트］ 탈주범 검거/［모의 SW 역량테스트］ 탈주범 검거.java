import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution {
	static int N, M, R, C, L;
	static int ans;
	static boolean[][] visit;
	static char[][] map;
	static int[][] dx, dy;

	public static void main(String[] args) throws IOException {
		initDir();
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		
		int T = Integer.parseInt(br.readLine());
		for(int tc = 1; tc <= T; tc++) {
			st = new StringTokenizer(br.readLine());
			
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			R = Integer.parseInt(st.nextToken());
			C = Integer.parseInt(st.nextToken());
			L = Integer.parseInt(st.nextToken());
			
			map = new char[N][M];
			for(int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				for(int j = 0 ; j < M; j++) {
					map[i][j] = st.nextToken().charAt(0);
				}
			}
			
			visit = new boolean[N][M];
			ans = 0;
			
			simulation();			
			sb.append("#" + tc + " " + ans + "\n");
		}
		bw.write(sb.toString());
		bw.close();
		
	}

	private static void simulation() {
		
		// 1. 현재 맨홀 위치를 입력 받는다.
		Queue<Point> q = new LinkedList<>();
		q.add(new Point(R, C));
		visit[R][C] = true;
		ans++;
		int time = 1;
		while(!q.isEmpty()) {
			if(time++ == L) return;		// 2. L 시간 내에 아래를 수행한다
			int qSize = q.size();
			while(qSize-- >0) {
				Point cur = q.poll();
				
				// 2-1. 현재 터널의 구조에 맞게 이동할 수 있는 곳으로 이동한다
				int dir = map[cur.x][cur.y]-'0';
				for(int d = 0, dSize = dx[dir].length; d < dSize; d++) {
					int nx = cur.x + dx[dir][d];
					int ny = cur.y + dy[dir][d];
					
					if(nx < 0 || nx >= N || ny < 0 || ny >= M
							|| visit[nx][ny]
							|| map[nx][ny] == '0') continue;
					
					int nDir = map[nx][ny] - '0';
					if(nx + dx[nDir][(d+2)%4] != cur.x 
							||ny + dy[nDir][(d+2)%4] != cur.y) continue;
					
					// 2-2. 이동할 때 마다 카운트를 해주며 이동한다.
					visit[nx][ny] = true;
					ans++;
					q.add(new Point(nx, ny));
				}
			}
		}
		
	}

	private static void initDir() {
		dx = new int[][] { { 0, 0, 0, 0 }, // 0
				{ -1, 0, 1, 0 }, // 1
				{ -1, 0, 1, 0 }, // 2
				{ 0, 0, 0, 0 }, // 3
				{ -1, 0, 0, 0 }, // 4
				{ 0, 0, 1, 0 }, // 5
				{ 0, 0, 1, 0 }, // 6
				{ -1, 0, 0, 0 } // 7
		};

		dy = new int[][] { { 0, 0, 0, 0 }, // 0
				{ 0, 1, 0, -1 }, // 1
				{ 0, 0, 0, 0 }, // 2
				{ 0, 1, 0, -1 }, // 3
				{ 0, 1, 0, 0 }, // 4
				{ 0, 1, 0, 0 }, // 5
				{ 0, 0, 0, -1 }, // 6
				{ 0, 0, 0, -1 } // 7
		};

	}

	static class Point{
		int x,y;

		public Point(int x, int y) {
			super();
			this.x = x;
			this.y = y;
		}
	}
}