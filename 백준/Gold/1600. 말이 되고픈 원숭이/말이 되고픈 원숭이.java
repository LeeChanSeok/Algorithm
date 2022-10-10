import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	static class Monkey {
		int x, y, k;

		public Monkey(int x, int y, int k) {
			super();
			this.x = x;
			this.y = y;
			this.k = k;
		}
	}
	
	static final int[] dx = {-1, 1, 0, 0, -2, -1, 1, 2, 2, 1, -1, -2};
	static final int[] dy = {0, 0, -1, 1, 1, 2, 2, 1, -1, -2, -2, -1};
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int K = Integer.parseInt(br.readLine())+1;
		
		st = new StringTokenizer(br.readLine());
		int W = Integer.parseInt(st.nextToken());
		int H = Integer.parseInt(st.nextToken());
		
		char[][] map = new char[H][W];
		for(int i = 0; i < H; ++i) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < W; ++j)
				map[i][j] = st.nextToken().charAt(0);
		}
		
		System.out.println(simulation(K, H, W, map));
		
	}



	private static int simulation(int K, int H, int W, char[][] map) {
		int INF = Integer.MAX_VALUE;
		// K에 대한 방문 처리 배역을 만든다
		int[][] visit = new int[H][W];
		visit[0][0] = K;
		
		Monkey monkey = new Monkey(0, 0, K);
		Monkey cur;
		
		Queue<Monkey> q = new LinkedList<>();
		q.add(monkey);
		
		int qSize, move = 0;
		int nx, ny;
		
		while(!q.isEmpty()) {
			
			// 같은 이동거리를 가지는 원소들에 대해서만 이동 처리
			qSize = q.size();
			while(qSize-- > 0) {
				cur = q.poll();
				
				// 목적지에 도착한 경우,
				if(cur.x == H-1 && cur.y == W-1) return move;
				// K가 남아있다면 말로 이동
				if(cur.k != 1) {
					for(int d = 4; d < 12; ++d) {
						nx = cur.x + dx[d];
						ny = cur.y + dy[d];
						
						// 격자 밖이거나, 벽이고, 해당 위치에 K이동횟수를 가지고 이미 방문한 적이 있는지 확인
						if(nx < 0 || nx >= H || ny < 0 || ny >=W 
								|| map[nx][ny] == '1' 
								|| visit[nx][ny] >= cur.k-1) 
							continue;
						
						visit[nx][ny] = cur.k-1;
						q.offer(new Monkey(nx, ny, cur.k-1));
					}
				}
				
				// K가 남아있는지 상관 없이 일반적인 인접 이동
				for(int d = 0; d < 4; ++d) {
					nx = cur.x + dx[d];
					ny = cur.y + dy[d];
					
					// 격자 밖이거나, 벽이고, 해당 위치에 K이동횟수를 가지고 이미 방문한 적이 있는지 확인
					if(nx < 0 || nx >= H || ny < 0 || ny >=W || map[nx][ny] == '1' || visit[nx][ny] >= cur.k ) continue;
					
					visit[nx][ny] = cur.k;
					q.offer(new Monkey(nx, ny, cur.k));
				}
			}
			
			++move;
			
		}
		
		return -1;
		
	}

}