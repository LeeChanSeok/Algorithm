import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		StringBuilder sb = new StringBuilder();
		
		int n = sc.nextInt();
		int r = sc.nextInt()-1;
		int c = sc.nextInt()-1;
		
		boolean[][] visited = new boolean[n][n];
		visited[r][c] = true;
		
		Queue<int[]> q = new LinkedList<>();
		q.offer(new int[] {r, c});
		
		int[] dx = {-1, -1, 1, 1};
		int[] dy = {-1, 1, 1, -1};
		
		while(!q.isEmpty()) {
			int[] cur = q.poll();
			
			for(int d = 0; d < 4; ++d) {
				int nx = cur[0] + dx[d];
				int ny = cur[1] + dy[d];
				
				if(nx < 0 || nx >= n || ny < 0 || ny >= n) continue;
				if(visited[nx][ny]) continue;
				
				visited[nx][ny] = true;
				q.offer(new int[] {nx, ny});
			}
		}
		
		for(int i = 0; i < n; ++i) {
			for(int j = 0; j < n; ++j) {
				if(visited[i][j]) sb.append('v');
				else sb.append('.');
			}
			sb.append('\n');
		}
		
		System.out.println(sb);
	}

}