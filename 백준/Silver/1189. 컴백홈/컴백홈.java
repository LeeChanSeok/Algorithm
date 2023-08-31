import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	
	static int[] dx = {-1, 1, 0, 0};
	static int[] dy = {0, 0, -1, 1};
	
	static int r, c, k;
	static int ans;
	static int T;
	static int DELTA = 5;
	
	public static void main(String[] args) throws Exception{
		input();
		pro();
	}

	private static void pro() {
	
		ans = 0;
		dfs(1, (r-1) * DELTA, 1 << ((r-1) * DELTA));
		System.out.println(ans);
		
	}

	private static void dfs(int move, int pos, int flag) {
		
		int x = pos / DELTA;
		int y = pos % DELTA;
		
		if(move == k) {
			if(x == 0 && y == (c-1)) ++ans;
			return;
		}
		
		for(int d = 0; d < 4; ++d) {
			int nx = x + dx[d];
			int ny = y + dy[d];
			
			if(nx < 0 || nx >= r || ny < 0 || ny >= c) continue;
			
			int nPos = nx * DELTA + ny;
			if(((1 << nPos) & T) != 0) continue;
			if(((1 << nPos) & flag) != 0) continue;
			
			dfs(move + 1, nPos, flag | (1 << nPos));
		}
		
		
	}

	private static void input() throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		r = Integer.parseInt(st.nextToken());
		c = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());
		
		for(int i = 0; i < r; ++i) {
			String str = br.readLine();
			for(int j = 0; j < c; ++j) {
				if(str.charAt(j) == 'T') T |= (1 << (i * DELTA + j));
			}
		}
		
	}

}