import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {
	
	static final int end = 4_000_000;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());
		
		List<Integer> primelist = new ArrayList<>();
		boolean[] primes = new boolean[end+1];
		find_Prime(primes);
		

		for(int i = 2; i <= end; ++i) if(!primes[i]) primelist.add(i);
		
		long cnt = sum_prime(N, primes, primelist);
		System.out.println(cnt);

	}

	private static int sum_prime(int N, boolean[] primes, List<Integer> primelist) {

		int answer = 0;
		long sum = 2;
		int s = 0, e = 0;
		int size = primelist.size();
		while(s <= e) {
			
			if(sum >= N) {
				if(sum == N) ++answer;
				sum -= primelist.get(s);
				++s;
				if(s >= size) break;
			}else{
				++e;
				if(e >= size) break;
				sum += primelist.get(e);
			}
		}
		
		return answer;
	}

	private static void find_Prime(boolean[] primes) {
		
		primes[0] = primes[1] = true;
		for(int i = 2; i <= Math.sqrt(end); ++i) {
			if(primes[i]) continue;
			for(int j = i*i; j <= end; j += i) primes[j] = true;
		}
		
	}

}