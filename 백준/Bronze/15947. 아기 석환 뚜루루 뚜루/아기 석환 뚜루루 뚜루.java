import java.util.Scanner;

public class Main {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		StringBuilder sb = new StringBuilder();
		int x = 14;
		String[] lyrics = {
				"baby", "sukhwan", "tururu", "turu",
				"very", "cute", "tururu", "turu",
				"in", "bed", "tururu", "turu",
				"baby", "sukhwan"
		};
		
		int n = sc.nextInt()-1;
		int mok = n / x;
		int remain = n % x;

		if(remain == 2 || remain == 6 || remain == 10) {
			int ru = mok + 2;
			if(ru >= 5) {
				sb.append("tu+ru*"+ru);
			}else {
				sb.append(lyrics[remain]);
				for(int i = 0; i < mok; ++i) {
					sb.append("ru");
				}
			}
		}else if(remain == 3 || remain == 7 || remain == 11) {
			int ru = mok + 1;
			if(ru >= 5) {
				sb.append("tu+ru*"+ru);
			}else {
				sb.append(lyrics[remain]);
				for(int i = 0; i < mok; ++i) {
					sb.append("ru");
				}
			}
			
		}else {
			sb.append(lyrics[remain]);
		}
		
		System.out.println(sb);
	}

}