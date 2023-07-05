import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	static int N;
	static String str;
	
	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		str = br.readLine();
		
		solution();
	}

	private static void solution() {
		
		int ans = 0;
		int cnt = 0;
		int[] alphabet = new int[(int)('z' -'a') + 1];
		
		int len = str.length();
		
		for(int L = 0, R = 0; R < len; ++R) {
			if(++alphabet[str.charAt(R) - 'a'] == 1) ++cnt;
			
			while(cnt > N) {
				if(--alphabet[str.charAt(L++) - 'a'] == 0) --cnt;
			}
			
			ans = Math.max(ans, R - L + 1);
			
		}
		
		System.out.println(ans); 
	
	}

}