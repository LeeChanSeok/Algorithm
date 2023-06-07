import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		int answer = 0;
		if(N != 0) {
			Integer[] level = new Integer[N];
			for(int i = 0; i < N; ++i) level[i] = Integer.parseInt(br.readLine());
			
			Arrays.sort(level);
			
			int A = (int)Math.round(N*0.15);
			
			double sum = 0;
			for(int i = A; i < N-A; ++i) {
				sum += level[i];
			}
			
			answer = (int)Math.round(sum / (N-A*2));
		}
		
		System.out.println(answer);
	}

}