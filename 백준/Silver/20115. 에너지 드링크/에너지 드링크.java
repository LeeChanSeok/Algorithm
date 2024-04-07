import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int n = Integer.parseInt(br.readLine());
		
		int max = 0;
		float sum = 0;
		
		st = new StringTokenizer(br.readLine());		
		for(int i = 0; i < n; ++i) {
			int num = Integer.parseInt(st.nextToken());
			
			max = Math.max(max, num);
			sum += num/2.0;
			
		}
		
		sum += max/2.0;
		
		System.out.println(sum);

	}

}