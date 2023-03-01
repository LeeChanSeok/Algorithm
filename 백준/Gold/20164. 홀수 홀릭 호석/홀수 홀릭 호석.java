import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class Main {

	static int max, min;
	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		max = 0; min = Integer.MAX_VALUE;
		dfs(N, 0);
		System.out.println(min + " " + max);

	}

	private static void dfs(int N, int odd) {

		int cnt = countOdd(N);
		String s = String.valueOf(N);
		int sLen = s.length();
		if(sLen >= 3) {
			
			for(int i = 0; i < sLen-2; ++i) {
				for(int j = i+1; j < sLen-1; ++j) {
					
					int num1 = Integer.parseInt(s.substring(0, i+1));
					int num2 = Integer.parseInt(s.substring(i+1, j+1));
					int num3 = Integer.parseInt(s.substring(j+1, sLen));
					dfs(num1 + num2 + num3, odd+ cnt);
				}
			}
			
		}else if(sLen == 2) {
			int num1 = N / 10; int num2 = N % 10;
			dfs(num1 + num2, odd + cnt);
		}else {
			max = Math.max(max, odd + cnt);
			min = Math.min(min, odd + cnt);
		}
		
	}

	private static int countOdd(int num) {
		int cnt = 0;
		while(num != 0) {
			if((num & 1) != 0) ++cnt;
			num /= 10;
		}
		
		return cnt;
	}

}