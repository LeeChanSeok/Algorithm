import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		
		int cnt = 0;
		for(int i = 0; i < N; ++i) {
			int num = Integer.parseInt(br.readLine());
			
			while(num > 0) {
				if(num % 2 != 0) break;
				++cnt;
				num /= 2;
			}
		}
		
		if(cnt >= K) System.out.println("1");
		else System.out.println("0");

	}

}