import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		final int r = 31, M = 1234567891;
		
		int L = Integer.parseInt(br.readLine());
		String str = br.readLine();
		
		long a, ri = 1, res = 0;
		for(int i = 0; i < L; ++i) {
			
			a = (int)(str.charAt(i) - 'a') + 1;
			
			res = (res + (a * ri) % M) % M;
			ri = (ri * r) % M;
			
		}
		
		System.out.println(res);
	}

}