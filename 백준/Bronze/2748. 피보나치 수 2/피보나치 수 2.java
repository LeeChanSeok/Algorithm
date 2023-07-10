import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		long F1 = 0, F2 = 1;
		
		long answer = -1;
		
		if(N == 1) answer = F2;
		else {
			for(int i = 2; i <= N; ++i) {
				answer = F1 + F2;
				
				F1 = F2;
				F2 = answer;
				
			}
		}

		System.out.println(answer);
		
	}

}