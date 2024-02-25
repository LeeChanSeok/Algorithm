import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int T = 3;
		for(int i = 0; i < T; ++i) {
			
			int cnt = 0;
			for(int j = 0; j < 4; ++j) {
				cnt += (sc.nextInt() == 0)? 1 :0;
			}
			
		
			char answer;
			if(cnt == 1) answer = 'A';
			else if(cnt == 2) answer = 'B';
			else if(cnt == 3) answer = 'C';
			else if(cnt == 4) answer = 'D';
			else answer = 'E';
			
			System.out.println(answer);
		}
		
	}

}