import java.util.Arrays;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(System.in);

		int N;
		while ((N = sc.nextInt()) != 0) {
			int[] arr = new int[N + 1];
			for (int i = 1; i <= N; ++i) {
				arr[i] = sc.nextInt();
			}

			Arrays.sort(arr);

			if (isPossible(arr))
				System.out.println("POSSIBLE");
			else
				System.out.println("IMPOSSIBLE");
		}

	}

	private static boolean isPossible(int[] arr) {

		int N = arr.length;
		for (int i = 1; i < N; ++i) {
			if (arr[i] - arr[i - 1] > 200)
				return false;
		}

		if(1422 - arr[N-1] > 100) return false;
		
		return true;
	}

}