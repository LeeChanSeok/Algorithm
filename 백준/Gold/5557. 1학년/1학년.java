import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	static int n, ans;
	static int[] num;
	static long[][] D;
	
	public static void main(String[] args) throws Exception {
		
		input();
		pro();
		
	}

	private static void pro() {

		ans = 0;
		D[0][num[0]] = 1;
		for(int i = 1; i < n - 1; ++i) {
			for(int j = 0; j <= 20; ++j) {
				
				if(j + num[i] <= 20) D[i][j + num[i]] += D[i - 1][j];
				if(j - num[i] >= 0) D[i][j - num[i]] += D[i - 1][j];
			}
		}
		
		System.out.println(D[n-2][num[n-1]]);
		
	}

	private static void input() throws Exception{

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		n = Integer.parseInt(br.readLine());
		
		num = new int[n];
		
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i < n; ++i) num[i] = Integer.parseInt(st.nextToken());
			
		D = new long[n-1][21];
		
	}

}