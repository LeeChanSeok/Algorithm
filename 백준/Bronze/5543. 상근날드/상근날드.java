import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int n = 3;
		int[] burger = new int[n];
		for(int i = 0; i < n; ++i) {
			burger[i] = sc.nextInt();
		}
		
		int m = 2;
		int[] drink = new int[m];
		for(int i = 0; i < m; ++i) {
			drink[i] = sc.nextInt();
		}
		
		int b = burger[0];
		for(int i = 1; i < n; ++i) {
			b = Math.min(b,burger[i]);
		}
		
		int d = drink[0];
		for(int i = 1; i < m; ++i) {
			d = Math.min(d,drink[i]);
		}
		
		System.out.println(b+d-50);

	}

}