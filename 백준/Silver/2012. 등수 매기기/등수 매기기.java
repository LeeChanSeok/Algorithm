import java.util.Arrays;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		
		int[] arr = new int[n+1];
		for(int i = 1; i <= n; ++i) arr[i] = sc.nextInt();
		Arrays.sort(arr);
		
		long res = 0;
		for(int i = 1; i <= n; ++i) {
			res += Math.abs(arr[i] - i);
		}
		
		System.out.println(res);

	}

}