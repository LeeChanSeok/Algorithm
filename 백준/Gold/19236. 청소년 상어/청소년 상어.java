import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	static class Fish {
		int x, y, num, dir;

		public Fish(int x, int y, int num, int dir) {
			super();
			this.x = x;
			this.y = y;
			this.num = num;
			this.dir = dir;
		}
		
		public Fish(Fish fish) {
			super();
			this.x = fish.x;
			this.y = fish.y;
			this.num = fish.num;
			this.dir = fish.dir;
		}
		
	}
	
	static int max;
	static final int N = 4, fishSize = N*N;
	
	static final int[] dx = {-1, -1, 0, 1, 1, 1, 0, -1};
	static final int[] dy = {0, -1, -1, -1, 0, 1, 1, 1};
	
	public static void main(String[] args) throws IOException, CloneNotSupportedException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		Fish[] fishes = new Fish[fishSize+1];
		int[][] board = new int[N][N];
		Fish fish, shark;
		
		int num, dir;
		for(int i = 0; i < N; ++i) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < N; ++j) {
				num = Integer.parseInt(st.nextToken());
				dir = Integer.parseInt(st.nextToken()) - 1;
				
				board[i][j] = num;
				fishes[num] = new Fish(i, j, num, dir);
			}
		}
		
		fish = fishes[board[0][0]];
		max = fish.num;
		shark = new Fish(0, 0, fish.num, fish.dir);
		fish.x = -1;
		board[0][0] = 0;
		
		dfs(board, fishes, shark);
		System.out.println(max);

	}

	private static void dfs(int[][] board, Fish[] fishes, Fish shark)  {

		int[][] newBoard = new int[N][N];
		Fish[] newFishes = new Fish[fishSize + 1];
		for(int i = 1; i < fishSize+1; ++i) {
			newFishes[i] = new Fish(fishes[i]);
		}
		
		Fish newShark;
		// 물고기 이동
		fishMove(board, newBoard, newFishes, shark);
		
		// 상어 이동
		int nx, ny, idx;
		int x;
		Fish fish;
		for(int d = 1; d < 4; ++d) {
			nx = shark.x + dx[shark.dir]*d;
			ny = shark.y + dy[shark.dir]*d;
			if(nx < 0 || nx >= N || ny < 0 || ny >= N) break;
			
			idx = newBoard[nx][ny];
			if(idx == 0) continue;
			
			fish = newFishes[idx];
			newShark = new Fish(nx, ny, shark.num + fish.num, fish.dir);
			
			x = fish.x;
			newBoard[nx][ny] = 0;
			fish.x = -1;
			
			dfs(newBoard, newFishes, newShark);
			
			newBoard[nx][ny] = idx;
			fish.x = x;
			
		}
		
		max = Math.max(max, shark.num);
	}

	private static void fishMove(int[][] board, int[][] newBoard, Fish[] newFishes, Fish shark)  {
		
		for(int i = 0; i < N; ++i)
			newBoard[i] = board[i].clone();
		
		Fish fish, nfish;
		int nx, ny, x, y, dir;
		for(int i = 1; i <= fishSize; ++i) {
			fish = newFishes[i];
			if(fish.x == -1) continue;
			
			x = fish.x;
			y = fish.y;
			
			dir = fish.dir; 
			for(int d = 0; d < 8; ++d) {
				nx = x + dx[dir];
				ny = y + dy[dir];
				
				if(nx < 0 || nx >= N || ny < 0 || ny >=N 
						|| (shark.x == nx && shark.y == ny)) {
					dir = (++dir) % 8;
					continue;
				}
				
				if(newBoard[nx][ny] == 0) {
					nfish = new Fish(nx, ny, 0, 0);
				}else {
					nfish = newFishes[newBoard[nx][ny]];
				}
				
				newBoard[nx][ny] = fish.num;
				newBoard[x][y] = nfish.num;
				swap(fish, nfish);
				
				break;
			}
			fish.dir = dir;
		}
		
	}

	private static void swap(Fish fish, Fish nfish)  {
		
		Fish temp = new Fish(fish);
		
		fish.x = nfish.x;
		fish.y = nfish.y;
		
		nfish.x = temp.x;
		nfish.y = temp.y;
		
	}
	
}
