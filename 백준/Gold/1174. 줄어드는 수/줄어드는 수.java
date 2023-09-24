import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {

	static int cnt;
	static int n, digit;
	static int[] nums;
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		nums = new int[11];
		nums[0] = 10;
		
		pro();

	}

	private static void pro() {
		cnt = 0;
		for(int i = 1; i <= 10; ++i) {
			digit = i;
			if(recursive(0, digit)) {
				printNum(digit);
				return;
			}
		}
		
		System.out.println(-1);
	}

	private static void printNum(int digit) {

		long ans = 0l;
		for(int i = 1; i <= digit; ++i) {
			ans = ans * 10 + nums[i];
		}
		System.out.println(ans);
	}

	private static boolean recursive(int idx, int digit) {

		if(idx == digit) {
			++cnt;
			if(cnt == n) return true;
			return false;
		}
		
		for(int i = 0; i < nums[idx]; ++i) {
			nums[idx + 1] = i;				
			if(recursive(idx + 1, digit)) return true;
		}
		
		return false;
		
	}

}