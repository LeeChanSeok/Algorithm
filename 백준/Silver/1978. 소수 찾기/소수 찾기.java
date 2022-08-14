import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static boolean isPrime(int n) {
		if(n==1) return false;
		for(int i = 2; i <= Math.sqrt(n); i++) {
			if(n % i == 0) {
				return false;
			}
		}
		return true;
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int N = Integer.parseInt(br.readLine());
		int number, cnt=0;
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i < N; i++) {
			number = Integer.parseInt(st.nextToken());
			if(isPrime(number)) cnt++;
		}
		System.out.println(cnt);
	}

}