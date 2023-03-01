import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
			
		int A, B, V;
		A = Integer.parseInt(st.nextToken());
		B = Integer.parseInt(st.nextToken());
		V = Integer.parseInt(st.nextToken());
		
		int ans = 0;
		
		if(A >= V) ans = 1;
		else {
			int top = (V - A);
			int step = (A - B);
			ans = top/ step + 1;
			if(top % step != 0) ++ans;
		}
		
		System.out.println(ans);
		
	}

}