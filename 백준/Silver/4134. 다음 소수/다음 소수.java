import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int tc = Integer.parseInt(br.readLine());
		
		for(int t = 0; t < tc; ++t) {
			long n = Long.parseLong(br.readLine());
			long ans = nextPrime(n);
			sb.append(ans).append('\n');
		}

		System.out.println(sb);
	}

	private static long nextPrime(long n) {

		while(true) {
			if(isPirme(n)) break;
			++n;

		}
		
		return n;
	}

	private static boolean isPirme(long n) {
		
		if(n <= 1) return false;
		else if(n == 2) return true;
		else {
			for(long i = 2, mid = (long)Math.sqrt(n); i <= mid; ++i) {
				if(n % i == 0) return false;
			}
		}
		
		return true;
	}

}