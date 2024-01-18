import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		long a = Long.parseLong(st.nextToken());
		long b = Long.parseLong(st.nextToken());
		
		long ans = (a * b) / gcd(a,b); 
		System.out.println(ans);
	}
	
	private static long gcd(long a, long b) {
		
		if(a % b == 0) return b;
		return gcd(b, a % b);
	}		

}