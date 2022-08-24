import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
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
	
	static class Shark extends Point{
		int size;
		int aet;
		int totalEat;
		public Shark(int x, int y) {
			super(x, y);
			this.size = 2;
			this.aet = 0;
			this.totalEat = 0;
		}
		
		public void eat() {
			if(++aet == size) {
				aet = 0;
				size++;
			}
		}
	}
	
	static int N, time, move;
	static char[][] map;
	static int[] dx = {-1, 0, 1, 0};
	static int[] dy = {0, 1, 0, -1};
	static Shark shark;
	static int totalFish;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		N = Integer.parseInt(br.readLine());
		
		totalFish = 0;
		map = new char[N][N];
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < N; j++) {
				map[i][j] = st.nextToken().charAt(0);
				if(map[i][j] == '9') {
					shark = new Shark(i, j);
					map[i][j] = '0';
				}
				else if (map[i][j] != '0') totalFish++;
			}
		}
		
		int ans = simulation();
		System.out.println(ans);
		
	}

	private static int simulation() {
		
		time = 0;
		while(true) {
			if(shark.totalEat == totalFish) return time;
			
			// 1. 먹을 수 있는 물고기가 있는지 확인한다.
			Point fish = findFish();
			if(fish == null) return time;
			
			//time++;
			
			// 2. 먹을 수 있는 물고기가 있다면 해당 위치로 이동한다.
			time += move;
			shark.x = fish.x;
			shark.y = fish.y;
			shark.totalEat++;
			
			// 3. 물고기를 먹고 상어의 크기 상태를 체크한다.
			shark.eat();
		}
		
	}

	private static Point findFish() {
		
		boolean[][] visit = new boolean[N][N];
		Queue<Point> q = new LinkedList<>();
		q.add(new Point(shark.x, shark.y));
		visit[shark.x][shark.y] = true;
		move = 0;
		Point candi= new Point(N , N);;
		while(!q.isEmpty()) {
			
			if(candi.x != N && candi.y != N) {
				map[candi.x][candi.y] = '0'; 
				return candi;
			}
			
			int qSize = q.size();
			
			while(qSize-- >0) {
				Point cur = q.poll();
				for(int d = 0, dSize = dx.length; d < dSize; d++) {
					int nx = cur.x + dx[d];
					int ny = cur.y + dy[d];
					
					if(nx < 0 || nx >= N || ny < 0 || ny >= N 
							|| visit[nx][ny]
							|| map[nx][ny] - '0' > shark.size) continue;
					
					if (map[nx][ny] != '0' && map[nx][ny]-'0' < shark.size) {
						if(nx < candi.x
								|| (nx == candi.x) && (ny < candi.y)) {
							candi.x = nx;
							candi.y = ny;
						}
					}
					
					visit[nx][ny] = true;
					q.add(new Point(nx, ny));
				}
			}
			move++;
		}
		
		return null;
	}

}