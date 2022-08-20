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
		
		if(N>20) System.out.println(getCount(N));
		else {
			HanoiTower(N, 1, 2, 3);
			System.out.println(ans);
			System.out.println(sb.toString());
		}
		
	}
	
	
	static BigInteger getCount(int N) {
		return (new BigInteger("2")).pow(N).subtract(new BigInteger("1"));
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