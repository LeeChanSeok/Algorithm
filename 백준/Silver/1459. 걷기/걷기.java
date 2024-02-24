import java.util.Scanner;

public class Main {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		
		long x = sc.nextLong();
		long y = sc.nextLong();
		long w = sc.nextLong();
		long s = sc.nextLong();
		
		long k = Math.min(x, y);
		
		long res = Math.min(k * 2 * w , s * k);
		
		long remain = Math.max(x - k, y - k) ;
		res += Math.min(remain * w, ((remain % 2 == 1)? (remain - 1) * s + w : remain * s));
		
		System.out.println(res);

	}

}