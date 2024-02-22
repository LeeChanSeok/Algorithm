import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String str = br.readLine();
		String pattern = br.readLine();

		int len = str.length();
		int plen = pattern.length();
		int ans = 0;
		
		for(int i = 0; i <= len - plen; ++i) {
			if(isMatch(str.substring(i, i+plen), pattern)) {
				i += plen-1;
				ans++;
			}
		}
		
		System.out.println(ans);
	}

	private static boolean isMatch(String substring, String pattern) {

		for(int i = 0; i < pattern.length(); ++i) {
			if(substring.charAt(i) != pattern.charAt(i)) return false;
		}
		
		return true;
	}

}