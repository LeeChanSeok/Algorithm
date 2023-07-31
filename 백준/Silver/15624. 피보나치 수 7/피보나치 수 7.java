import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {

	static int n;
	
	public static void main(String[] args) throws Exception {
		input();
		pro();
	}

	private static void pro() {

		int fibo1 = 0, fibo2 = 1;
		
		for(int i = 2; i <= n; ++i) {
			int temp = fibo2;
			fibo2 = (fibo1 + fibo2) % 1000000007;
			fibo1 = temp;
		}
		
		System.out.println(fibo2);
	}

	private static void input() throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
	}

}