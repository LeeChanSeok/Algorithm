import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	static int N;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		
		System.out.println(factorial(N));

	}
	private static int factorial(int n) {
		
		if(n == 0 | n == 1) return 1;
		return n * factorial(n-1);
		
	}

}