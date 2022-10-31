import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = 64;
		int X = Integer.parseInt(br.readLine());
		int total = N;
		int L = N;
		
		int cnt = 1;
		int mid;
		
		while(true) {
			if(total == X) break;
			
			mid = L / 2;
			
			if(total - mid >= X) {
				total -= mid;
			}else {
				++cnt;
			}
			
			L = mid;
		}
		
		System.out.println(cnt);

	}

}