import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();

	static int MOD = 1000000009;
	static int Q;
	static int[][] Dy;
	
	public static void main(String[] args) throws Exception {
		
		input();
		pro();
	}

	private static void pro() throws Exception {
		Dy = new int[100005][4];

		preprocess();
		while(Q-- > 0) {
			int x = Integer.parseInt(br.readLine());
			int ans = 0;
			for(int i = 1; i <= 3; ++i) ans = (ans + Dy[x][i]) % MOD; 
			sb.append(ans).append('\n');
		}
		
		System.out.println(sb);
	}

	private static void preprocess() {
		Dy[1][1] = 1;
		Dy[2][2] = 1;
		Dy[3][1] = Dy[3][2] = Dy[3][3] = 1;
				
		for(int i = 4; i <= 100000; ++i) {
			for(int cur = 1; cur <= 3; ++cur) {
				for(int prev = 1; prev <= 3; ++prev) {
					if(cur == prev) continue;
					Dy[i][cur] += Dy[i-cur][prev];
					Dy[i][cur] %= MOD;
				}
			}
			
		}
			
	}

	private static void input() throws Exception {
		Q = Integer.parseInt(br.readLine());
	}

}