import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Solution {
	static class Info {
		int x, y, cnt, dir;

		public Info(int x, int y, int cnt, int dir) {
			super();
			this.x = x;
			this.y = y;
			this.cnt = cnt;
			this.dir = dir;
		}

	}

	static int N, M, K;
	static final int[] dx = { -1, 1, 0, 0 };
	static final int[] dy = { 0, 0, -1, 1 };
	static List<Info>[][] map;

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;

		int T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= T; tc++) {
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			K = Integer.parseInt(st.nextToken());

			map = new ArrayList[N][N];
			for (int i = 0; i < N; i++)
				for (int j = 0; j < N; j++)
					map[i][j] = new ArrayList<>();

			for (int n = 1; n <= K; n++) {
				st = new StringTokenizer(br.readLine());
				int x = Integer.parseInt(st.nextToken());
				int y = Integer.parseInt(st.nextToken());
				int cnt = Integer.parseInt(st.nextToken());
				int dir = Integer.parseInt(st.nextToken()) - 1;

				map[x][y].add(new Info(x, y, cnt, dir));
			}

			sb.append("#" + tc + " " + simulation() + "\n");

		} // tc 종료

		bw.write(sb.toString());
		bw.close();
	}

	private static int simulation() {

		List<Info>[][] new_map = new ArrayList[N][N];
		for (int i = 0; i < N; i++)
			for (int j = 0; j < N; j++)
				new_map[i][j] = new ArrayList<>();
		
		int time = M;
		while (time-- > 0) {
			// 1. 미생물 이동
			for (int i = 0; i < N; i++)
				for (int j = 0; j < N; j++)
					new_map[i][j].clear();
			
			for(int i = 0; i < N; i++) {
				for(int j =0; j < N; j++) {
					if(map[i][j].size() == 0) continue;
					
					for(Info cell : map[i][j]) {
						int nx = cell.x + dx[cell.dir];
						int ny = cell.y + dy[cell.dir];
						if(nx < 1 || nx >= N-1 || ny < 1 || ny >= N-1) {
							cell.cnt /= 2;
							cell.dir = (cell.dir % 2 == 0) ? cell.dir+1 : cell.dir-1;
						}
						if(cell.cnt == 0) continue;
						cell.x = nx;
						cell.y = ny;
						
						new_map[nx][ny].add(cell);
					}
				}
			} // 1. 미생물 이동  - end
			
			// 2. 미생물 합치기
			for(int i = 0; i < N; i++) {
				for(int j =0; j < N; j++) {
					map[i][j].clear(); 
					if(new_map[i][j].size() == 0 ) continue;
					
					int total_cnt = 0;
					Info max_cell = new_map[i][j].get(0);
					for(Info cell : new_map[i][j]) {
						total_cnt += cell.cnt;
						if(cell.cnt > max_cell.cnt) {
							max_cell = cell;
						}
					}
					
					max_cell.cnt = total_cnt;
					map[i][j].clear(); 
					map[i][j].add(max_cell);
				}
			}// 2. 미생물 합치기 - end
			
		}// 3. time - end
		
		// 3. 미생물 수
		int total_cell = 0;
		for(int i = 0; i < N; i++) {
			for(int j =0; j < N; j++) {
				
				if(map[i][j].size() == 0 ) continue;
				total_cell += map[i][j].get(0).cnt;
				
			}
		}

		return total_cell;
	}

}
