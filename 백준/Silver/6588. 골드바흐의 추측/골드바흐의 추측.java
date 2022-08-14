import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	public static void initPrime(boolean[] prime, int max) {
		
		for(int i = 2; i < Math.sqrt(max)+1; i++) {
			if(prime[i]) continue;
			for(int j = i*2; j <= max; j+=i) {
				prime[j] = true;
			}
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuffer sb = new StringBuffer();
		
		int max = 1_000_000;
		boolean[] prime = new boolean[max + 1];
		initPrime(prime, max);
		int number, i;
		while((number = Integer.parseInt(br.readLine()))!=0) {
			for(i = 3; i <= number/2; i+=2) {
				if(!prime[i] && !prime[number-i]) {
					sb.append(String.format("%d = %d + %d\n", number, i, number -i));
					break;
				}
			}
			if(i > number/2) sb.append("Goldbach's conjecture is wrong.\n");
		}
		System.out.println(sb);
	}

}
