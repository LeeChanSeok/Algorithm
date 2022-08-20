import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;

public class Main {
	static int N, ans;
	static StringBuilder sb;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		sb = new StringBuilder();
		N = Integer.parseInt(br.readLine());
		
		ans = 0;
		
		if(N>20) System.out.println(powof2(N));
		else {
			HanoiTower(N, 1, 2, 3);
			System.out.println(ans);
			System.out.println(sb.toString());
		}
		
	}
	
	private static BigInteger powof2(int N) {
		BigInteger bigNumber = new BigInteger("1");
		BigInteger sub = new BigInteger("2");
		BigInteger mul = new BigInteger("2");
		for(int i = 1; i <= N; i++) {
			bigNumber = bigNumber.multiply(mul);
		}
		bigNumber.subtract(sub);
		return bigNumber;
	}
	

	private static void HanoiTower(int n, int s, int t, int e) {
		ans++;
		if(n==1) {
			sb.append(s).append(" ").append(e).append("\n");
			return ;
		}
		
		HanoiTower(n-1, s, e, t);
		sb.append(s).append(" ").append(e).append("\n");
		HanoiTower(n-1, t, s, e);
	}

}