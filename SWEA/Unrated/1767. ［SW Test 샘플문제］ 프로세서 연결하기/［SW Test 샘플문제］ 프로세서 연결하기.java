import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Solution {

	static final int[] dx = {-1, 1, 0, 0};
	static final int[] dy = {0, 0, -1, 1};
	
	static final int MAX_CORE = 12;
	static int[][] cores;
	static int core_size;
	
	static char[][] board;
	
	static int max;
	static int total;
	static int N;
	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		
		int T = Integer.parseInt(br.readLine());
		for(int tc = 1; tc <= T; ++tc) {
			init();
			
			N = Integer.parseInt(br.readLine());
			board = new char[N][N];
					
			for(int i = 0; i < N; ++i) {
				st = new StringTokenizer(br.readLine());
				for(int j = 0; j < N; ++j) {
					char c = st.nextToken().charAt(0);
					board[i][j] = c;
					if(i == 0 || i == N-1 || j == 0 || j == N-1) continue;
					if(c == '1') {
						cores[core_size++] = new int[] {i, j};
					}
				}
			}

			dfs(0, 0, 0);
			
			sb.append("#").append(tc).append(" ").append(total).append("\n");
		}

		bw.write(sb.toString());
		bw.flush();
		
		bw.close();
		br.close();
	}

	private static void dfs(int idx, int install, int len) {
		
		if(idx == core_size) {
			if(install > max) {
				max = install;
				total = len;
			}else if(install == max) {
				total = Math.min(total, len);
			}
			return ;
		}
		
		int[] core = cores[idx];
		for(int d = 0; d < 4; ++d) {
			int line = link(core, d);
			if(line == -1) continue; 
			dfs(idx + 1, install + 1, len + line);
			back(core, d);
		}
		
		dfs(idx + 1, install, len);
	}

	private static void back(int[] core, int d) {
		int r = core[0] + dx[d];
		int c = core[1] + dy[d];
		while(inRange(r, c)) {
			board[r][c] = '0';
			r += dx[d];
			c += dy[d];
		}
		
	}

	private static int link(int[] core, int d) {

		int r = core[0] + dx[d];
		int c = core[1] + dy[d];
		
		while(inRange(r, c)) {
			if(board[r][c] != '0') return -1;
			r += dx[d];
			c += dy[d];
		}
		
		int res = 0;
		r = core[0] + dx[d];
		c = core[1] + dy[d];
		while(inRange(r, c)) {
			board[r][c] = '2';
			r += dx[d];
			c += dy[d];
			++res;
		}
				
		return res;
	}

	private static boolean inRange(int r, int c) {
		if(r >= 0 && r < N && c >= 0 && c < N) return true;
		return false;
	}

	private static void init() {
		cores = new int[MAX_CORE][2];
		core_size = 0;
		max = 0;
		total = 0;
	}

}