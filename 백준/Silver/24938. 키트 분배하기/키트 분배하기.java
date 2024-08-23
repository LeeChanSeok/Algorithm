import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();
		int[] A = new int[n];

		long sum = 0;
		for (int i = 0; i < n; ++i) {
			A[i] = sc.nextInt();
			sum += A[i];
		}

		long target = sum / n;
		long ans = 0;
		for (int i = 0; i < n - 1; ++i) {
			long diff = target - A[i];
			ans += diff;
			A[i + 1] -= diff;
		}

		System.out.println(ans);
	}

}