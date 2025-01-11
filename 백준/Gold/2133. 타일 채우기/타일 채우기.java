import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		
		int MAX = 30;
		int[] D =new int[MAX + 1];
		
		D[2] = 3;
		for(int i = 4; i <= MAX; i += 2) {
			D[i] = D[i-2] * 3 + 2;
			for(int j = i - 2; j >= 4; j -= 2) {
				D[i] += D[i - j] * 2;
			}
		}

		System.out.println(D[N]);
	}

}