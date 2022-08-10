import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	
	public static int[] dx = {0, 1, 0, -1};
	public static int[] dy = {1, 0, -1, 0};
	
	public static void printArr(int[][] arr) {
		for(int[] row : arr) {
			for(int a : row)
				System.out.print(a + " ");
			System.out.println();
		}
	}
	
	public static void rotate(int[][] arr, int N, int M, int R) {
		int x, y, nx, ny, dir;
		int cnt;
		int r;
		int temp;
		
		int rot_cnt = Math.min(N, M)/2;
		
		for(int k = 0; k < rot_cnt; k++) {
			x = k; y = k;
			dir = 0;
			cnt = (N - 1 - 2*k) * 2 + (M - 1 - 2*k) * 2;
			r = R % cnt;
			
			for(int i = 0; i < r; i++) {
				x = k; y = k;
				temp = arr[k][k];
				
				while(true) {
					nx = x + dx[dir];
					ny = y + dy[dir];
					if(nx == k && ny == k) break;
					if(nx < k || nx >= N- k || ny < k || ny >=M -k) {
						dir = (++dir)%4;
						continue;
					}
					arr[x][y] = arr[nx][ny];
					x = nx; y = ny;
				}
				arr[x][y] = temp;
			}
							
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int R = Integer.parseInt(st.nextToken());

		int[][] arr = new int[N][M];
		
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < M; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		rotate(arr, N, M, R);
		printArr(arr);
	}
}