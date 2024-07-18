import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {

	static int[] dx = {-1, 0, 1, 0};
	static int[] dy = {0, 1, 0, -1};
	
	static int R, C;
	static boolean[][] visited;
	static long ans;
	
	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		
		int T = Integer.parseInt(br.readLine());
		for(int tc = 1; tc <= T; ++tc) {
			st = new StringTokenizer(br.readLine());
			
			R = Integer.parseInt(st.nextToken());
			C = Integer.parseInt(st.nextToken());
	
			ans = 0;
			visited = new boolean[R][C];
			recursive(R - 1, 0, 0);
			
			bw.write(String.format("Case #%d: %d\n", tc, ans));
		}
		
		bw.flush();
		bw.close();
		br.close();

	}

	private static void recursive(int x, int y, int d) {

		visited[x][y] = true;

		boolean isMove = false;
	
		int nx = x + dx[d];
		int ny = y + dy[d];

		if(nx >= 0 && nx < R && ny >= 0 && ny < C && !visited[nx][ny]) {
			isMove = true;
			recursive(nx, ny, d);
			
		}
	
		d = (d + 1) % 4;
		nx = x + dx[d];
		ny = y + dy[d];
		
		if(nx >= 0 && nx < R && ny >= 0 && ny < C && !visited[nx][ny]) {
			isMove = true;
			recursive(nx, ny, d);
		}
		
		if(!isMove) {
			++ans;
		}
		
		visited[x][y] = false;
	}

}