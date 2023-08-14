import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	
	static int[] dx = {-1, 0, 1, 0};
	static int[] dy = {0, -1, 0, 1};
	
	static int delta = 5000;
	static int r1,c1,r2,c2;
	
	
	public static void main(String[] args) throws Exception{

		input();
		pro();
	}

	private static void pro() {

		int r = r2 - r1 + 1;
		int c = c2 - c1 + 1;
		int[][] num = new int[r][c];
		
		int cnt = 0;
		int max = 0;
		for(int i = r1; i <= r2; ++i) {
			for(int j = c1; j <= c2; ++j) {
				
				int res = find(i, j);
				num[cnt / c][cnt % c] = res;
				max = Math.max(max, res);
				++cnt;
			}
		}
		
		int len = getLen(max);
		for(int i = 0; i < r; ++i) {
			for(int j = 0; j < c; ++j) {
				System.out.format("%" + len + "d ", num[i][j]);
			}
			System.out.println();
		}
		
	}

	private static int getLen(int num) {

		int len = 0;
		while(num != 0) {
			num /= 10;
			++len;
		}
		return len;
	}

	private static int find(int x, int y) {

		int conner = Math.max(Math.abs(x), Math.abs(y));
		int len = conner;
		int turn = conner * 2 - 1; 
		
		int num = (int)Math.pow(turn, 2) + 1;
		int nx = conner - 1;
		int ny = conner;
		
		int dir = 0;
		
		for(int i = 1; i <= conner*8; ++i) {
			if(nx == x && ny == y) return num;
			
			if(i % (len * 2) == 0) ++dir;
			
			nx += dx[dir];
			ny += dy[dir];
			++num;
				
		}
		
		return 1;
	}

	private static void input() throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		r1 = Integer.parseInt(st.nextToken());
		c1 = Integer.parseInt(st.nextToken());
		r2 = Integer.parseInt(st.nextToken());
		c2 = Integer.parseInt(st.nextToken());
				
	}

}