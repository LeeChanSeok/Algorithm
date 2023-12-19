import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int A, B, C;
		A = Integer.parseInt(st.nextToken());
		B = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		
		int ans = 0;
		
		if(C-B <= 0) ans = -1;
		else {
			double res = (double)A / (C - B);
			
			int delta = 0;
			if(A % (C - B) == 0) delta = 1;
			
			ans = (int)Math.ceil(res + delta);
		}
		
		System.out.println(ans);
	}
}