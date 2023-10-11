import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws Exception{

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int ans = 0;
		int n = Integer.parseInt(br.readLine());
		
		for(int i = 1; i <= 9; ++i) {
			if(i > n) break;
			++ans;
									
			for(int j = -9; j <= 9; ++j) {
				int num = i;
				int last = i;
				while(true) {
					last = last + j;
					if(last < 0 || last > 9) break;
					
					num = num * 10 + last;
					if(num > n) break;
					++ans;
				}
			}
		}
		
		System.out.println(ans);

	}

}