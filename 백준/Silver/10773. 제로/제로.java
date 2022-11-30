import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int K = Integer.parseInt(br.readLine());
		int[] numbers = new int[K];
		int sum = 0, idx = 0, num;
		
		for(int i = 0; i < K; ++i) {
			num = Integer.parseInt(br.readLine());
			
			if(num == 0) {
				sum -= numbers[--idx];
			}
			else {
				numbers[idx++] = num;
				sum += num;
			}
		}
		
		System.out.println(sum);

	}

}