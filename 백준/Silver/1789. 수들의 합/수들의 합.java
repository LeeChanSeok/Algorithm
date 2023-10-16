import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		long s = Long.parseLong(br.readLine());
		s *= 2;
		
		long l = 0;
		long r = 100000;
		
		long ans = 0;
		while(l <= r) {
			long mid = (l + r) / 2;
			
			long res = mid * (mid + 1);
			if(res <= s) {
				l = mid + 1;
				ans = mid;
			}else {
				r = mid - 1;
			}
		}
		
		System.out.println(ans);
	}

}