import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		int digit = (int) (Math.log10(N))+1;
		
		int start = N - 9 * digit;
		start = Math.max(start, 0);
		
		int ans = -1, res, temp;
		for(int i = start; i <= N; ++i) {
			digit = (int) (Math.log10(i))+1;
			
			res = temp = i;
			
			while(temp != 0) {
				res += temp % 10;
				temp /= 10;
			}
			if(res == N) {
				ans = i;
				break;
			}
		}
			
		if(ans == -1) ans = 0;
		System.out.println(ans);
		

	}

}