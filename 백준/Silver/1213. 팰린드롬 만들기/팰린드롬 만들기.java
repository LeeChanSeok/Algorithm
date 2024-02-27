import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		StringBuilder sb = new StringBuilder();
		
		String str = sc.next();
		
		int len = str.length();
		int[] alphaCnt = new int[26];
		for(int i = 0; i < len; ++i) {
			++alphaCnt[str.charAt(i) - 'A'];
		}
		
		int odd = 0;
		for(int i = 0; i < 26; ++i) {
			if(alphaCnt[i] % 2 == 1) odd++;
		}
		String ans = "";
		if(odd > 1) ans = "I'm Sorry Hansoo";
		else {
			
			for(int i = 0; i < 26; ++i) {
				for(int j = 0; j < alphaCnt[i]/2; ++j) {
					sb.append((char)(i + 'A'));
				}
			}
			
			ans = sb.toString();
			
			for(int i = 0; i < 26; ++i) {
				if(alphaCnt[i] % 2 == 1) {
					ans += (char)(i + 'A');
					break;
				}
			}
			
			ans += sb.reverse().toString();
		
		}
		
		System.out.println(ans);
	}

}