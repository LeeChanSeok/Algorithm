import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int N = Integer.parseInt(br.readLine());
		int[] numbers = new int[N+1];
		st = new StringTokenizer(br.readLine());
		for(int i = 1; i <= N; ++i) numbers[i] = Integer.parseInt(st.nextToken());
		Arrays.sort(numbers, 1, N+1);
		
		int x = Integer.parseInt(br.readLine());
		
		int ai, aj, target;
		int answer = 0;
		for(int i = 1; i <= N - 1; ++i) {
			ai = numbers[i];
			if(ai >= x || (ai + numbers[i+1] > x)) break;
			
			target = x - ai; 
			int l = i + 1, r = N;
			while(l <= r) {
				int mid = ( l + r) / 2;
				
				aj = numbers[mid];
				if(aj == target) {
					++answer;
					break;
				}else if (aj < target) {
					l = mid + 1;
				}else {
					r = mid - 1;
				}
			}
			
		}
		
		System.out.println(answer);
	}

}