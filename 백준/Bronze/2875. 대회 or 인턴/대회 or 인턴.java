import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		int m = sc.nextInt();
		int k = sc.nextInt();
		
		int team = Math.min(n / 2, m);
		
		n -= team*2;
		m -= team;
		
		k -= (n + m);
		
		if(k <= 0) System.out.println(team);
		else System.out.println(team - ((k - 1)/3 + 1));

	}

}