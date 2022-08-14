import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		long N = sc.nextInt();
		long total_sum = 0;
		for(long n = 1; n <= N; n++) {
			total_sum += n*(N/n);
		}
		System.out.println(total_sum);
	}
}