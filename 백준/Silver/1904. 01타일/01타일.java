import java.util.Scanner;

public class Main {

	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		
		int ans = 0;
		if (n == 1) ans = 1;
		else {
			int[] D = new int[n+1];
			D[1] = 1;
			D[2] = 2;
			
			for(int i = 3; i <= n; ++i) {
				D[i] = (D[i-2] + D[i-1]) % 15746;
			}

			ans = D[n];
		}
		
		System.out.println(ans);

	}

}