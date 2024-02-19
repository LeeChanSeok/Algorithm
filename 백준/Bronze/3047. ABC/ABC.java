import java.util.Arrays;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int n = 3;
		int[] arr = new int[n];
		for(int i = 0; i < n; ++i) {
			arr[i] = sc.nextInt();
		}
		Arrays.sort(arr);
		
		String str = sc.next();
		
		for(int i = 0; i < n; ++i) {
			System.out.print(arr[(int)(str.charAt(i)-'A')] + " ");
		}

	}

}