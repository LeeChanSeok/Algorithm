import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int N = sc.nextInt();

		int l = 1, r = 1;
		int ans = 0;
		int sum = 1;
		while (l <= N && r <= N) {

			if (sum < N) {
				++r;
				sum += r;
			} else {
				if (sum == N) {
					++ans;
				}
				sum -= l;
				++l;
			}

		}

		System.out.println(ans);
	}

}