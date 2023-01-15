import java.io.*;
import java.util.*;

public class Main {
	
	static int[] dx = {-1, 1, 0, 0, 0, 0};
	static int[] dy = {0, 0, -1, 1, 0, 0};
	static int[] dz = {0, 0, 0, 0, -1, 1};

	static int L, R, C;
	static int[] S, E; 
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		
		int time;
		char[][][] board;
		char c;
		while(true) {
			st = new StringTokenizer(br.readLine());
			
			L = Integer.parseInt(st.nextToken());
			R = Integer.parseInt(st.nextToken());
			C = Integer.parseInt(st.nextToken());
			
			if(L == 0) break;
			
			board = new char[L][R][C];
			for(int z = 0; z < L; ++z) {
				for(int x = 0; x < R; ++x) {
					board[z][x] = br.readLine().toCharArray();
					for(int y = 0; y < C; ++y) {
						c = board[z][x][y];
						if(c == 'S') S = new int[] {z, x, y};
						else if(c == 'E') E = new int[] {z, x, y};

					}
				}
				br.readLine();
			}
			
			time = bfs(S, E, board);
			
			if(time == -1) sb.append("Trapped!\n");
			else sb.append(String.format("Escaped in %d minute(s).\n", time));
			
		}
		
		bw.write(sb.toString());
		bw.close();
	}
	private static int bfs(int[] S, int[] E, char[][][] board) {

		Queue<int[]> q = new LinkedList<>();
		q.offer(S);
		
		boolean[][][] visit = new boolean[L][R][C];
		visit[S[0]][S[1]][S[1]] = true;
		
		int qSize;
		int time = 0;
		int[] cur;
		int x, y, z, nx, ny, nz;
		while(!q.isEmpty()) {
			
			qSize = q.size();
			while(qSize-- > 0) {
				cur = q.poll();
				x = cur[1]; y = cur[2]; z = cur[0];
				
				if(x == E[1] && y == E[2] && z == E[0]) return time;
				
				for(int d = 0; d < 6; ++d) {
					nx = x + dx[d];
					ny = y + dy[d];
					nz = z + dz[d];
					
					if(nx < 0 || nx >= R || ny < 0 || ny >= C || nz < 0 || nz >= L 
							|| visit[nz][nx][ny] 
									|| board[nz][nx][ny]=='#') continue;
					
					visit[nz][nx][ny] = true;
					q.offer(new int[] {nz, nx, ny});
				}
			}
			++time;
		}
		return -1;
	}

}