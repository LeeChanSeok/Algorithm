import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Tank {
	int x=-1;
	int y=-1;
	int dir=-1;
	
	public Tank(int x, int y, int dir) {
		this.x = x;
		this.y = y;
		this.dir = dir;
	}
	
	public void setAll(int x, int y, int dir) {
		this.x = x;
		this.y = y;
		this.dir = dir;
	}

}

public class Solution {

	public static int[] dx = { -1, 1, 0, 0 };
	public static int[] dy = { 0, 0, -1, 1 };

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int T = Integer.parseInt(br.readLine());

		for (int tc = 1; tc <= T; tc++) {
			st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			int M = Integer.parseInt(st.nextToken());

			char[][] map = new char[N][M];
			for (int i = 0; i < N; i++) {
				map[i] = br.readLine().toCharArray();
			}

			Tank tk = null;
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < M; j++) {
					if (map[i][j] == '^') {
						tk = new Tank(i, j, 0);
						map[i][j] = '.';
						break;
					} else if (map[i][j] == 'v') {
						tk = new Tank(i, j, 1);
						map[i][j] = '.';
						break;
					} else if (map[i][j] == '<') {
						tk = new Tank(i, j, 2);
						map[i][j] = '.';
						break;
					} else if (map[i][j] == '>') {
						tk = new Tank(i, j, 3);
						map[i][j] = '.';
						break;
					}
				}
			}
			
			int L = Integer.parseInt(br.readLine());
			char[] command = br.readLine().toCharArray();
			
			for(int i = 0; i < command.length; i++) {
				char com = command[i];
				
				// shot
				if(com == 'S') {
					int x = tk.x; int y = tk.y; int dir = tk.dir;
					
					while(true) {
						x += dx[dir];
						y += dy[dir];
						
						if ((x < 0 || x >=N || y <0 || y >= M) || map[x][y] == '#') break;
						if(map[x][y] == '*') {
							map[x][y] = '.';
							break;
						}
					}
					
				}else {//무브
					int x = tk.x; int y = tk.y; int dir = tk.dir;
					
					if(com == 'U') dir = 0;
					else if(com == 'D') dir = 1;
					else if(com == 'L') dir = 2;
					else if(com == 'R') dir = 3;
					
					x += dx[dir];
					y += dy[dir];
					if(x >= 0 && x < N && y >= 0 && y < M && map[x][y] == '.') {
						
					}else {
						x -= dx[dir];
						y -= dy[dir];
					}	
										
					tk.setAll(x, y, dir);
				}
			}
			
			if(tk.dir == 0) map[tk.x][tk.y] = '^';
			else if(tk.dir == 1) map[tk.x][tk.y] = 'v';
			else if(tk.dir == 2) map[tk.x][tk.y] = '<';
			else if(tk.dir == 3) map[tk.x][tk.y] = '>';
			
			System.out.print("#" + tc + " ");
			for(int i = 0; i<N; i++){
				for(int j = 0; j < M; j++) {
					System.out.print(map[i][j]);
				}
				System.out.println();
			}

		}
	}

}
