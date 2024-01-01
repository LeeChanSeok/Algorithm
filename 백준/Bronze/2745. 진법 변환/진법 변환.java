import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		String n = st.nextToken();
		int b = Integer.parseInt(st.nextToken());
		
		int ans = 0;
		int pow = 1;
		int len = n.length();
		for(int i = len - 1; i >= 0; --i, pow *= b) {
			char c = n.charAt(i);
			int digit = char2num(c);
			
			ans += digit * pow;
		}
		
		System.out.println(ans);

	}

	private static int char2num(char c) {
		
		if(c >= 'A') return (int)(c - 'A') + 10;
		else return (int)(c - '0');
	}
	

}