import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		
		int cnt = 0;
		int num = 666;
		while(true) {
			if(String.valueOf(num).contains("666")) {
				++cnt;
				if(cnt == N) break;
			}
			++num;
		}
		System.out.println(num);
	}
}