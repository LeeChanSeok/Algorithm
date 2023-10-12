import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int x = Integer.parseInt(br.readLine());

		long s = 1;
		long e = Integer.MAX_VALUE;
		long res = 1;

		while (s <= e) {
			long mid = (s + e) / 2;

			if (isSum(mid) >= x) {
				res = mid;
				e = mid - 1;
			} else {
				s = mid + 1;
			}
		}
		
		long remain = isSum(res) - x;
		
		if((res & 1) == 1) {
			System.out.println((remain + 1) + "/" + (res - remain));
		}else {
			System.out.println((res - remain)  + "/" + (remain + 1));
		}

	}

	private static long isSum(long num) {
		return num * (num + 1) / 2;
	}

}