import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		sc.nextLine();

		for(int tc = 1; tc <= N; tc++){
			
			String str = sc.nextLine();
			int cnt = 0;
			int sum = 0;
			for(int i = 0; i < str.length();i++) {
				if(str.charAt(i)=='O') {
					cnt++;
					sum += cnt;
				}else {
					cnt = 0;
				}
			}
			System.out.println(sum);
		}
		
	}

}
