import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int max = 0;
		int cnt = 0;
		
		for(int i = 0; i < 4; ++i) {
			int out = sc.nextInt();
			int in = sc.nextInt();
			
			cnt -= out;
			cnt += in;
			
			max = Math.max(max, cnt);
		}
		
		System.out.println(max);

	}

}