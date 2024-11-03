import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	static final int MAX = 30;
	static int[][] pascal = new int[MAX + 1][MAX + 1];
	
	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int n = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());

		for(int i = 1; i <= MAX; ++i) {
			for(int j = 1; j <= i; ++j) {
				pascal[i][j] = Pascal(i,j);
				
			}
		}
		
		System.out.println(pascal[n][k]);

	}

	private static int Pascal(int n, int k) {
		if(pascal[n][k] != 0) return pascal[n][k];
		if (k == 1 || k == n)
			return 1;
		return Pascal(n - 1, k - 1) + Pascal(n - 1, k);
	}

}