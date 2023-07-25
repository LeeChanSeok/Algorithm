import java.io.*;
import java.util.*;

public class Main {

	static int n, k;
	static int ans;
	static String[] words;
	static boolean[] alpha;

	public static void main(String[] args) throws Exception {
		
		input();
		pro();

	}

	private static void pro() {

		ans = 0;		
		if(k < 5) ans = 0;
		else {
			selectWord(0, 0);
		}

		System.out.println(ans);
	}

	private static void selectWord(int index, int cnt) {

		if(cnt == (k - 5)) {
			int match = 0;
			for (int i = 1; i <= n; ++i) {
				if (isMatch(i))
					++match;
			}
			
			ans = Math.max(ans, match);
			return;
			
		}
		
		for(int i = index; i < 26; ++i) {
			if(alpha[i]) continue;
			alpha[i] = true;
			selectWord(i + 1, cnt + 1);
			alpha[i] = false;
		}
		
		
	}
	
	private static boolean isMatch(int index) {

		for(int i = 4, len = words[index].length(); i < len - 4; ++i) {
			if(!alpha[words[index].charAt(i) - 'a']) return false;
		}
		
		return true;
	}

	private static void input() throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		n = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());

		words = new String[n + 1];
		for (int i = 1; i <= n; ++i)
			words[i] = br.readLine();

		alpha = new boolean[26];
		alpha['a' - 'a'] = alpha['n' - 'a'] = alpha['t' - 'a'] = alpha['i' - 'a'] = alpha['c' - 'a'] = true;  
	}

}