import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {

	static int ans;
	static char[] str;
	static int len;
	static int[] charCnt;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		str = br.readLine().toCharArray();
		
		len = str.length;
		charCnt = new int['z' - 'a' + 1];
		for(int i = 0; i < len; ++i) ++charCnt[str[i] - 'a'];
		
		recursive(0, '\0');
		System.out.println(ans);
	}
	private static void recursive(int cnt, char prev) {
		
		if(cnt == len) {
			++ans;
			return;
		}
		
		for(char c = 'a'; c <= 'z'; ++c) {
			if(c == prev) continue;
			
			int idx = c - 'a'; 
			if(charCnt[idx] == 0) continue;
			--charCnt[idx];
			recursive(cnt+1, c);
			++charCnt[idx];
			
		}
		
	}

}