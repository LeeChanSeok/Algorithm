import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N,idx, num, mod;
		try {
			while (true) {
				N = Integer.parseInt(br.readLine());	
				
				idx = 1;
				num = 1;
				
				while (true) {
					mod = num % N;
					if (mod == 0)
						break;
					num = mod * 10 + 1;
					idx++;
				}
				System.out.println(idx);
			}
			
		}catch(Exception e) {
			System.exit(0);
		}
	}
}