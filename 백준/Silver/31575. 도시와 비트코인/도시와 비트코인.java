import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	
	static int N, M;
	static char[][] arr;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		M = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());
		
		arr = new char[N][M];
		for(int i = 0; i < N; ++i) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < M; ++j) {
				arr[i][j] = st.nextToken().charAt(0);
			}
		}
		
		String ans = "No";
		if(solution()) ans = "Yes";
		System.out.println(ans);

	}

	private static boolean solution() {

		int[] dx = {0, 1};
		int[] dy = {1, 0};
		
		Queue<int[]> q = new LinkedList<>();
		q.offer(new int[] {0, 0});
		
		boolean[][] visited = new boolean[N][M];
		visited[0][0] = true;
		
		while(!q.isEmpty()) {
			int[] cur = q.poll();
			
			int x = cur[0];
			int y = cur[1];
			
			if(x == N - 1 && y == M - 1) return true;
			
			for(int d = 0; d < 2; ++d) {
				int nx = x + dx[d];
				int ny = y + dy[d];
				
				if(nx < 0 || nx >= N || ny < 0 || ny >= M) continue;
				if(arr[nx][ny] == '0') continue;
				if(visited[nx][ny]) continue;
				
				q.offer(new int[] {nx, ny});
				visited[nx][ny] = true;
				
				
			}
		}
		
		return false;
	}

}