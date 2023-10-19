import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		char[] ans = br.readLine().toCharArray();
		int len = ans.length;
		
		for(int i = 1; i < N; ++i) {
			char[] tmp = br.readLine().toCharArray();
			for(int j = 0; j < len; ++j) {
				if(ans[j] == '?') continue;
				if(ans[j] != tmp[j]) ans[j] = '?';
			}
		}
		
		System.out.println(String.copyValueOf(ans));
	}
}