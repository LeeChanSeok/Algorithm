import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int x = Integer.parseInt(st.nextToken());
		int y = Integer.parseInt(st.nextToken());
		
		int gcd = GCD(x, y);

		System.out.println(x + y - gcd);
	}

	private static int GCD(int x, int y) {

		if(x > y) {
			int tmp = x;
			x = y;
			y = tmp;
		}
		
		while(y != 0) {
			int tmp = x % y;
			x = y;
			y = tmp;
		}
		
		return x;
	}

}