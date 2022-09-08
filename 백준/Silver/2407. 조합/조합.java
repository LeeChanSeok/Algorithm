import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.StringTokenizer;

public class Main {

	static BigInteger[][] memoiz;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		memoiz = new BigInteger[N+1][M+1];
		
		System.out.println(comb(N, M));
	}

	private static BigInteger comb(int n, int m) {
		
		if(memoiz[n][m] != null) return memoiz[n][m];
		if(n == m || m == 0) return memoiz[n][m] = BigInteger.ONE;
		
		return memoiz[n][m] = comb(n-1, m-1).add(comb(n-1, m));
	}

}