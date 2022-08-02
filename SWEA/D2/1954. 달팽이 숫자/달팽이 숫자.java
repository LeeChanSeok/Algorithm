import java.util.Scanner;

public class Solution {

	public static int[] dx = {0, 1, 0, -1};
	public static int[] dy = {1, 0, -1, 0};
	public static int dir;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		
		for(int tc = 1; tc <= T; tc++) {
			int N = sc.nextInt();
			
			int num = 1;
			int dest = N*N;
			dir = 0;
			int[][] map = new int[N][N];
			boolean[][] visit = new boolean[N][N];
			int x = 0;
			int y = 0;
			while(num < dest) {
				visit[x][y] = true;
				map[x][y] = num++;
				
				int nx = x + dx[dir];
				int ny = y + dy[dir];
				if((nx < 0 || nx >= N || ny < 0 || ny >=N)||
						visit[nx][ny]) {
					dir = (++dir)%4;
				}
				
				x += dx[dir];
				y += dy[dir];
			}
			map[x][y] = num;
			
			
			System.out.println("#" + tc);
			for(int[] r : map) {
				for(int c : r)
					System.out.printf(c + " ");
				System.out.println();
				
			}
		}

	}

}