import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;
import java.io.BufferedReader;

public class Main {
	
	static int n;
	static int[][] pole;

	public static void main(String[] args) throws Exception{
		input();
		pro();
	}

	private static void pro() {

		Arrays.sort(pole, (p1, p2) -> p1[0] - p2[0]);
		
		int ans = 0;
		
		int x = 1;
		int y = n;
		
		int[] prev = pole[1];
		for(int i = 2; i <= n; ++i) {
			if(pole[i][1] > prev[1]) {
				ans += (pole[i][0] - prev[0]) *  prev[1];
				prev = pole[i];
				x = i;
			}
		}
		
		prev = pole[n];
		for(int i = n-1; i > 0; --i) {
			if(pole[i][1] > prev[1]) {
				ans += (prev[0] - pole[i][0]) *  prev[1];
				prev = pole[i];
				y = i;
			}
		}
		
		ans += (pole[y][0] - pole[x][0] + 1) * pole[x][1];
		
		System.out.println(ans);
		
	}

	private static void input() throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		n = Integer.parseInt(br.readLine());
		
		pole = new int[n+1][2];
		for(int i = 1; i <= n; ++i) {
			st  = new StringTokenizer(br.readLine());
			
			pole[i][0] = Integer.parseInt(st.nextToken());
			pole[i][1] = Integer.parseInt(st.nextToken());
			
		}
		
	}

}