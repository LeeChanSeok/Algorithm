import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		int M = Integer.parseInt(br.readLine());
		String S = br.readLine();
		
		char[] IO = {'I', 'O'};
		int answer = 0;
		int i = 0, j, k;
		while(i < M) {
			if(S.charAt(i) == 'I') {
				j = 0;
				k = i;
				while(true) {
					while(j < 2*N + 1 && k < M) {
						if(S.charAt(k) != IO[j%2]) break;
						++k; ++j;
					}
					
					if(j == 2*N + 1) {
						j -=2;
						++answer;
					}else {
						i = k;
						break;
					}
				}
			}else {
				++i;
			}
			
		}
		
		System.out.println(answer);

	}

}