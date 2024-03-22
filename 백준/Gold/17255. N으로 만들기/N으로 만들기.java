import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {

	static int ans = 0;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String input = br.readLine();
		int N = Integer.parseInt(input);
		int len = input.length();
		
		recursive(N, len);
		
		System.out.println(ans);
	}

	private static void recursive(int n, int len) {

		if(len == 1) {
			++ans;
			return;
		}
		
		int L = n / 10;
		int R = n % (int)Math.pow(10, len-1);
		
		if(L == R) {
			++ans;
			return;
		}
		
		recursive(L, len - 1);
		recursive(R, len - 1);
		
	}

}