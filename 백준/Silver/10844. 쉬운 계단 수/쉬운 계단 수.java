import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		long[][] D = new long[n][10];
		
		for(int i = 1; i < 10; ++i) D[0][i] = 1;
		
		for(int i = 1; i < n; ++i) {
			
			for(int j = 0; j < 10; ++j) {
				if(j - 1 >= 0) D[i][j] = (D[i][j] + D[i-1][j-1]) % 1000000000;
				if(j + 1 < 10) D[i][j] = (D[i][j] + D[i-1][j+1]) % 1000000000;
			}
		}

		long ans = 0;
		for(int i = 0; i < 10; ++i) ans = (ans + D[n-1][i]) % 1000000000;
		System.out.println(ans);
		
	}

}