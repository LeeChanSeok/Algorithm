import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		StringBuilder sb = new StringBuilder();
		
		int n = sc.nextInt();
		
		for(int i = 0; i < n; ++i) {
			if((i&1) == 1) sb.append(' ');
			for(int j = 0; j < n; ++j) {
				sb.append("* ");
			}
			sb.append('\n');
		}
		
		System.out.println(sb);

	}

}