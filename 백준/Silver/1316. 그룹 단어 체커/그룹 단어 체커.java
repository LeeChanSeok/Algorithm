import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int answer = 0;
		int alphaCnt = (int)('z' - 'a') + 1;
		boolean[] alpha = new boolean[alphaCnt];
		
		int idx;
		char c, prev = '\0';
		boolean isGroup;
		int T = Integer.parseInt(br.readLine());
		for(int tc = 0; tc < T; ++tc) {
			char[] str = br.readLine().toCharArray();
			
			Arrays.fill(alpha, false);
			prev = '\0';
			isGroup = true;
			
			for(int i = 0, n = str.length; i < n; ++i) {
				
				c = str[i];
				idx = (int)(c - 'a');
				if(alpha[idx] && prev != c) {
					isGroup = false;
					break;
				}
				
				prev = c;
				alpha[idx] = true;
				
			}
			
			if(isGroup) ++answer;
			
		}
		
		System.out.println(answer);
	}

}
