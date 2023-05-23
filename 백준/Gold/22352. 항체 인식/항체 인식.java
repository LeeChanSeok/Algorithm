import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	
	static final int DELTA = 1000;

	static final int[] dx = {-1, 1, 0, 0};
	static final int[] dy = {0, 0, -1, 1};
	
	static int N, M;
	static int[][] original, vaccine;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		original = new int[N][M];
		vaccine = new int[N][M];
		
		for(int i = 0; i < N; ++i) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < M; ++j) {
				original[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		for(int i = 0; i < N; ++i) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < M; ++j) {
				vaccine[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		if(solution()) System.out.println("YES");
		else System.out.println("NO");
		
	}

	private static boolean solution() {
		boolean isVaccine = false;
		for(int i = 0; i < N; ++i) {
			for(int j = 0; j < M; ++j) {
				if(original[i][j] != vaccine[i][j]) {
					if(isVaccine) return false;
					isVaccine = true;
					
					inputVaccine(i, j, vaccine[i][j]);
					
				}
			}
		}
		
		for(int i = 0; i < N; ++i) {
			for(int j = 0; j < M; ++j) {
				if(original[i][j] != vaccine[i][j]) return false;
			}
		}
		
		return true;
	}

	private static void inputVaccine(int i, int j, int vc) {
		
		boolean[][] visited = new boolean[N][M];
		visited[i][j] = true;
		
		
		Queue<Integer> q = new LinkedList<>();
		q.offer(i * DELTA + j);
		
		int ori = original[i][j];
		original[i][j] = vc;
		
		int cur, x, y, nx, ny;
		while(!q.isEmpty()) {
			cur = q.poll();
			
			x = cur / DELTA; y = cur % DELTA;
			for(int d = 0; d < 4; ++d) {
				nx = x + dx[d];
				ny = y + dy[d];
				
				if(nx < 0 || nx >= N || ny < 0 || ny >= M || visited[nx][ny] || original[nx][ny] != ori) continue;
				
				original[nx][ny] = vc;
				q.offer(nx * DELTA + ny);
				visited[nx][ny] = true;
			}
		}
		
	}

}