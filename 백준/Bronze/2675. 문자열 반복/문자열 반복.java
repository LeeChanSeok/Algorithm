import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		for(int tc = 1; tc <=T ; tc++) {
			int cnt = sc.nextInt();
			String str = sc.next();
			
			for(int i = 0; i < str.length(); i++) {
				char c = str.charAt(i);
				for(int j = 0; j < cnt; j++) {
					System.out.print(c);
				}
			}
			System.out.println();
		}
	}

}
