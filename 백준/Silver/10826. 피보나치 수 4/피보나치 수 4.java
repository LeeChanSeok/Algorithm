import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.math.BigInteger;

public class Main {

	static int n;
	
	public static void main(String[] args) throws Exception {
		input();
		pro();
	}

	private static void pro() {
		
		BigInteger fibo1 = BigInteger.ZERO;
		BigInteger fibo2 = BigInteger.ONE;
		
		for(int i = 2; i <= n; ++i) {
			BigInteger temp = fibo2;
			fibo2 = fibo2.add(fibo1);
			fibo1 = temp;
		}
        if(n == 0) fibo2 = fibo1;
		System.out.println(fibo2);
	}

	private static void input() throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
	}
}