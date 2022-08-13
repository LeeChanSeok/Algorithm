import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static int cnt;
	public static void recursice(int[] numbers, int N, int sum) {
		if(sum > N) return;
		if(sum == N) {
			cnt++;
			return;
		}
		for(int i = 0; i < numbers.length; i++) {
			recursice(numbers, N, sum+numbers[i]);
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		
		int N;
		int numbers[] = {3,2,1};
		for(int tc = 1; tc <= T; tc++) {
			N = Integer.parseInt(br.readLine());
			cnt = 0;
			recursice(numbers, N, 0);
			System.out.println(cnt);
		}
	}
}