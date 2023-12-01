import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws Exception{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		
		System.out.println(pro(n));

	}

	private static int pro(int n) {
				
		int mok = n / 5;
		while(mok >= 0) {
			int money = n;
			int cnt = mok;
			money -= (mok * 5);
			
			if(money % 2 == 0) return cnt + money / 2;
			
			--mok;
			
		}
		
		return -1;
	}

}