import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt() - 1;

		String str = "WelcomeToSMUPC";
		int len = 14;
		N %= len;

		System.out.println(str.charAt(N));


	}

}