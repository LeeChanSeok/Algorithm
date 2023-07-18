import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {

	static String s, t;
	
	public static void main(String[] args) throws Exception {
		
		input();
		pro();
	}

	private static void pro() {
		
		int sLen = s.length();
		int tLen = t.length();
		
		int end = lcm(sLen, tLen);
		
		int ans = 1;
		for(int i = 0; i < end; ++i) {
			if(s.charAt(i%sLen) != t.charAt(i%tLen)) {
				ans = 0;
				break;
			}
		}
		
		System.out.println(ans);
		
	}

	private static int lcm(int a, int b) {
		return (a * b) / gcd(a, b);
	}

	private static int gcd(int a, int b) {
		if(b == 0) return a;
		return gcd(b, a % b);
	}

	private static void input() throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		s = br.readLine();
		t = br.readLine();
		
	}

}