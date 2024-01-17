import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int t = Integer.parseInt(br.readLine());
		for(int i = 0; i < t; ++i) {
			st=  new StringTokenizer(br.readLine());
			
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			
			System.out.println((a*b)/gcd(a, b));
		}
			
	}

	static int gcd(int n1, int n2) {
		if(n1%n2 == 0) return n2;
		
		return gcd(n2, n1 % n2);
	}
}