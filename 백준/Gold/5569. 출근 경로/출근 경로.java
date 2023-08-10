import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	
	static int w, h;
	static int[][][][] D;
	
	public static void main(String[] args) throws Exception{
		input();
		pro();
	}

	private static void pro() {
		int mod = 100000;
		
		for(int i = 1; i <= w; ++i) D[i][1][0][0] = 1;
		for(int i = 1; i <= h; ++i) D[1][i][1][0] = 1;
		
		// 0 : -> , 1 : V
		for(int i = 2; i <= w; ++i) {
			for(int j = 2; j <= h; ++j) {
				
				
                D[i][j][1][0] = (D[i][j - 1][1][1] + D[i][j - 1][1][0]) % mod;
                D[i][j][1][1] = D[i][j - 1][0][0] % mod;
                D[i][j][0][0] = (D[i - 1][j][0][0] + D[i - 1][j][0][1]) % mod;
                D[i][j][0][1] = D[i - 1][j][1][0];
			}
		}
		
		int ans = (D[w][h][0][0] + D[w][h][0][1] + D[w][h][1][0] + D[w][h][1][1]) % mod; 
		System.out.println(ans);
		
	}

	private static void input() throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		 w = Integer.parseInt(st.nextToken());
		 h = Integer.parseInt(st.nextToken());
		
		 D = new int[w+1][h+1][2][2];
	}

}