import java.util.Scanner;

public class Main {

	static int[] f;
	static int cnt1, cnt2;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		
		f = new int[n+1];
		fib1(n);
		fib2(n);
		
		System.out.println(cnt1 + " " + cnt2);

	}

	public static int fib1(int n) {
	    if (n == 1 || n == 2) {
	    	++cnt1;
	    	return 1;
	    }
	    else return (fib1(n - 1) + fib1(n - 2));
	}
	
	public static int fib2(int n) {
	    f[1] = f[2] = 1;
	    for (int i = 3; i <= n; ++i) {
	    	++cnt2;
	    	f[i] = f[i - 1] + f[i - 2];
	    }
	    return f[n];
	}
}