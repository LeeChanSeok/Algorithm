import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	static int[] dx = {0, 0, 1, -1};
	static int[] dy = {-1, 1, 0, 0};
	
	static int n;
	static boolean[][] visited = new boolean[30][30]; 
	static double ans;
	static double[] prob = new double[4];
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		n = Integer.parseInt(st.nextToken());
		for(int i = 0; i < 4; ++i) prob[i] = Integer.parseInt(st.nextToken()) * 0.01;
		
		ans = 0;
		recursive(0, 1, 15, 15);
		System.out.println(ans);

	}

	private static void recursive(int idx, double p, int x, int y) {

		if(idx == n) {
			ans += p;
			return;
		}
		
		visited[x][y] = true; 
		
		for(int d = 0; d < 4; ++d) {
			if(Double.compare(prob[d], 0) == 0) continue;
			
			int nx = x + dx[d];
			int ny = y + dy[d];
			if(visited[nx][ny]) continue;
			
			recursive(idx + 1, p * prob[d], nx, ny);
		}
		
		visited[x][y] = false; 
	}

}