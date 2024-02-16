import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		StringBuilder sb = new StringBuilder();
		
		int n = 10000;
		boolean[] prime = new boolean[n+1];
		for(int i = 2; i <= Math.sqrt(n); ++i) {
			if(prime[i]) continue;
			for(int j = i*i; j <= n; j += i) {
				prime[j] = true;
			}
		}
		
		List<Integer> list = new LinkedList<>();
		for(int i = 2; i <= n; ++i) {
			if(!prime[i]) list.add(i);
		}

		int t = sc.nextInt();
		for(int i = 0; i < t; ++i) {
			int x = sc.nextInt();
			
			int a = 0, b = 0;
			for(int p : list) {
				int q = x - p;
				if(prime[q]) continue;
				if(p > q) break;
				
				a = p;
				b = q;
			}
			sb.append(a + " " + b + "\n");
		}
		
		System.out.println(sb);
		
	}

}