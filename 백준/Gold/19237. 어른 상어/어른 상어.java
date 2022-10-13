import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	static class Shark{
		int x, y, head;
		int[][] dir = new int[4][4];

		public Shark(int x, int y) {
			super();
			this.x = x;
			this.y = y;
		}
		
	}
	
	static final int[] dx = {-1, 1, 0, 0};
	static final int[] dy = {0, 0, -1, 1};
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		
		Shark[] sharks = new Shark[M+1];
		
		int num;
		for(int i = 0; i < N; ++i) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < N; ++j) {
				num = Integer.parseInt(st.nextToken());
				if(num != 0) sharks[num] = new Shark(i, j);
			}
		}
		
		st = new StringTokenizer(br.readLine());
		for(int i = 1; i <= M; ++i) {
			sharks[i].head = Integer.parseInt(st.nextToken()) - 1;
		}
		
		for(int i = 1; i <= M; ++i) {
			for(int d = 0; d < 4; ++d) {
				st = new StringTokenizer(br.readLine());
				for(int j = 0; j < 4; ++j) {
					sharks[i].dir[d][j] = Integer.parseInt(st.nextToken()) - 1;
				}
			}
			
		}
		
		int time = simulation(N, M, K, sharks);
		System.out.println(time);
		
	}

	private static int simulation(int N, int M, int K, Shark[] sharks) {

		int[][][] small = new int[N][N][2];
		
		int time = 1000;
		int die;
		int sharkCnt = M;
		while(time-- > 0) {
			
			// 1. 상어 냄새 뿌리기
			putSmall(sharks, small, M, K);
			
			// 2. 상어 이동
			die = moveShark(small, N, M, sharks);
			sharkCnt -= die;
			
			if(sharkCnt == 1) return 1000 - time;
			
			// 3. 냄새 제거
			removeSmall(small, N);
			
		}
		
		return -1;
	}

	private static void removeSmall(int[][][] small, int N) {

		for(int i = 0; i < N; ++i) {
			for(int j = 0; j < N; ++j) {
				if(small[i][j][0] == 0) continue;
				--small[i][j][1];
				if(small[i][j][1] == 0) small[i][j][0] = 0;
			}
		}
		
	}

	private static int moveShark(int[][][] small,int N, int M, Shark[] sharks) {
		
		int die = 0;
		int nx, ny;
		Shark shark;
		boolean isMove;
		boolean[][] isShark = new boolean[N][N];
		for(int i = 1; i <= M; ++i) {
			shark = sharks[i];
			if(shark.x == -1) continue;
			
			// 빈공간
			isMove = false;
			for(int d = 0; d < 4; ++d) {
				nx = shark.x + dx[shark.dir[shark.head][d]];
				ny = shark.y + dy[shark.dir[shark.head][d]];
				
				if(nx < 0 || nx >= N || ny < 0 || ny >= N || small[nx][ny][0] != 0) continue;
				
				if(isShark[nx][ny]) {
					shark.x = -1;
					++die;
					isMove = true;
					break;
				}
				
				isShark[nx][ny] = true;
				shark.x = nx; shark.y = ny;
				shark.head = shark.dir[shark.head][d];
				isMove = true;
				break;
			}
			
			if(isMove) continue;
			
			// 냄새 공간
			for(int d = 0; d < 4; ++d) {
				nx = shark.x + dx[shark.dir[shark.head][d]];
				ny = shark.y + dy[shark.dir[shark.head][d]];
				
				if(nx < 0 || nx >= N || ny < 0 || ny >= N || small[nx][ny][0] != i) continue;
						
				isShark[nx][ny] = true;
				shark.x = nx; shark.y = ny;
				shark.head = shark.dir[shark.head][d];
				break;
			}
			
		}
		
		return die;
	}

	private static void putSmall(Shark[] sharks, int[][][] small, int M, int K) {

		Shark shark;
		for(int i = 1; i <= M; ++i) {
			if(sharks[i].x == -1) continue;
			shark = sharks[i];
			small[shark.x][shark.y][0] = i;
			small[shark.x][shark.y][1] = K;
		}
		
	}

}