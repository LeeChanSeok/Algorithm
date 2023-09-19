import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	static int[] dx = {-1, 1, 0, 0};
	static int[] dy = {0, 0, -1, 1};
	
	static int r, c;
	static char[][] map;
	
	public static void main(String[] args) throws Exception{
		input();
		pro();
	}

	private static void pro() {
		StringBuilder sb = new StringBuilder();
		
		int res = solution();
		sb.append(res).append('\n');
		
		if(res == 1) {
			for(int i = 0; i < r; ++i) {
				for(int j = 0; j < c; ++j) sb.append(map[i][j]);
				sb.append('\n');
			}

		}
		
		System.out.println(sb);
		
	}

	private static int solution() {

		for(int x = 0; x < r; ++x) {
			for(int y = 0; y < c; ++y) {
				if(map[x][y] == 'S') {
					
					for(int d = 0; d < 4; ++d) {
						int nx = x + dx[d];
						int ny = y + dy[d];
						
						if(nx < 0 || nx >= r || ny < 0 || ny >= c) continue;
						if(map[nx][ny] == 'S') continue;
						if(map[nx][ny] == 'W') return 0;
						map[nx][ny] = 'D';
					}
					
				}
			}
		}
		return 1;
	}

	private static void input() throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		r = Integer.parseInt(st.nextToken());
		c = Integer.parseInt(st.nextToken());
		
		map = new char[r][c];
		
		for(int i = 0; i < r; ++i) {
			map[i] = br.readLine().toCharArray();
		}
		
	}

}