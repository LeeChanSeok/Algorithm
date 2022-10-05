import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.ListIterator;
import java.util.StringTokenizer;

public class Main {
	
	static class Shark{
		int x, y, s, d, z;

		public Shark(int x, int y, int s, int d, int z) {
			super();
			this.x = x;
			this.y = y;
			this.d = d;
			this.z = z;
			
			if((d & 1<<1) == 0) this.s = s % (2*(R-1)); // 상하 이동
			else this.s = s % (2*(C-1)); // 좌우 이동
		}
		
		public Shark(Shark shark) {
			this.x = shark.x;
			this.y = shark.y;
			this.s = shark.s;
			this.d = shark.d;
			this.z = shark.z;
		}

		public void move() {
			// 상 이동
			if(d == 0) {
				if (s <= x) x -= s;
				else if(s < R + x ) {
					x = s - x;
					d = 1;
				}else x = 2* R - s + x - 2;
			}
			
			//하 이동
			else if(d == 1) {
				if (s < R - x) x += s;
				else if(s < 2*R - x - 1) {
					x = 2*R - x  - 2 - s ;
					d = 0;
				}else x = s - (2*R - x - 2);
			}
			
			// 우 이동
			else if(d == 2) {
				if (s < C - y) y += s;
				else if(s < 2*C - y - 1) {
					y = 2*C - y  - 2 - s;
					d = 3;
				}else y = s - (2*C - y - 2);
				
			}
			
			//좌 이동
			else if(d == 3) {
				if (s <= y) y -= s;
				else if(s < C + y ) {
					y = s - y;
					d = 2;
				}else y = 2 * C - s + y - 2;
			}
		}
		
	}
	
	static int R, C, M;
	static LinkedList<Shark> sharks;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
				
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		sharks = new LinkedList<>();
		
		Shark[][] map = new Shark[R][C];
		Shark shark;
		int r, c, s, d, z;
		
		for(int i = 0; i < M; ++i) {
			st = new StringTokenizer(br.readLine());
			
			r = Integer.parseInt(st.nextToken())-1;
			c = Integer.parseInt(st.nextToken())-1;
			s = Integer.parseInt(st.nextToken());
			d = Integer.parseInt(st.nextToken())-1;
			z = Integer.parseInt(st.nextToken());
			
			shark = new Shark(r,c,s,d,z);
			sharks.add(shark);
			map[r][c] = shark;
		}
		
		
		int y = -1;
		int score = 0;
		while(++y < C){
			// 1. 오른쪽으로 한칸 이동한다
			
			// 2. 상어를 잡는다.
			score += get(y, map);
			
			// 3. 상어가 이동한다.
			move(map, sharks);
		}
		System.out.println(score);
	}

	private static int get(int y, Shark[][] map) {
		int score;
		for(int x = 0; x < R; ++x) {
			if(map[x][y] != null) {
				score = map[x][y].z;
				map[x][y].s = -1;
				map[x][y] = null;
				
				return score;
			}
		}
		
		return 0;
	}

	private static void move(Shark[][] map, LinkedList<Shark> sharks) {
		Shark[][] newMap = new Shark[R][C];
		ListIterator<Shark> iter = sharks.listIterator();
		Shark shark;
		
		while(iter.hasNext()) {
			shark = iter.next();
			if(shark.s == -1) iter.remove();
			else {
				shark.move();
				if(newMap[shark.x][shark.y] == null) {
					newMap[shark.x][shark.y] = shark; 
				}
				else {
					if(newMap[shark.x][shark.y].z > shark.z) iter.remove();
					else {
						newMap[shark.x][shark.y].s = -1;
						newMap[shark.x][shark.y] = shark;
					}
				}
			}
		}
		
		copyMap(newMap, map);
		
	}

	private static void copyMap(Shark[][] newMap, Shark[][] map) {
		for(int i = 0; i < R; ++i) {
			for(int j = 0; j < C; ++j) {
				map[i][j] = newMap[i][j];
			}
		}
		
	}

}