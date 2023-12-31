import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int n = 9;
		
		int r = 0, c = 0;
		int max = -1;
		for(int i = 1; i <= n; ++i) {
			st = new StringTokenizer(br.readLine());
			for(int j = 1; j <= n; ++j) {
				int num = Integer.parseInt(st.nextToken());
				if(num > max) {
					max = num;
					r = i; c = j;
				}
			}
		}
		
		System.out.println(max);
		System.out.println(r + " " + c);

	}

}