import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String str = br.readLine();
		int size = str.length();
		
		int open = 0;
		char c, last = '\0';
		int ans = 0;
		for(int i = 0; i < size; ++i) {
			c = str.charAt(i);
			if(c == '(') ++open;
			else {
				--open;
				if(last == ')') ++ans;
				else {
					ans += open;
				}
			}
			last = c;
		}
		System.out.println(ans);
	}

}