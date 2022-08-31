import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
	static int[] memoiz;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int T = 10;
		for(int tc = 1; tc<=T; tc++) {
			br.readLine();
			st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			int M = Integer.parseInt(st.nextToken());
			
			memoiz = new int[M+1];
			memoiz[0] = 0;
			memoiz[1] = N;
			
			int res = recursive(N, M);
			System.out.println("#" + tc + " " + res);
		}
	}

	private static int recursive(int n, int m) {
		
		if(memoiz[m] != 0) return memoiz[m];
		if(m == 1) return n;
		else if(m == 0) return 1;
		
		if(m % 2 == 0) {
			memoiz[m] = recursive(n, m / 2) * recursive(n, m / 2);
		}else {
			memoiz[m] = recursive(n, m / 2) * recursive(n, m / 2) * n ;
		}
		
		return memoiz[m];
	}

}