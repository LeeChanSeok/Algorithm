import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		int m = Integer.parseInt(br.readLine());
		
		int min = Integer.MAX_VALUE;
		int sum = 0;
		
		for(int i = n; i <= m; ++i) {
			if(isPrime(i)) {
				min = Math.min(min, i);
				sum += i;
			}
		}
		
		if(min == Integer.MAX_VALUE) System.out.println(-1);
		else {
			System.out.println(sum);
			System.out.println(min);
		}
	}

	private static boolean isPrime(int num) {
		if(num == 1) return false;
		else if (num == 2) return true;
		else {
			for(int i = 2; i <= Math.sqrt(num); ++i) {
				if(num % i == 0) return false;
			}
		}
		
		return true;
	}

}