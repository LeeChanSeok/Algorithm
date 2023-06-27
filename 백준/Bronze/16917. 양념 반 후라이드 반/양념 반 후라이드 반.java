import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int A = Integer.parseInt(st.nextToken());
		int B = Integer.parseInt(st.nextToken());
		int C = Integer.parseInt(st.nextToken());
		int X = Integer.parseInt(st.nextToken());
		int Y = Integer.parseInt(st.nextToken());

		int price = 0;
		if((A + B) > C * 2) {
			int min = Math.min(X, Y);
			price = min * C * 2;
			X -= min;
			Y -= min;
		}
		
		if(X != 0) {
			if(A > C * 2) {
				price += X * 2 * C;
			}else price += X * A;
		}
		if(Y != 0) {
			if(B > C * 2) {
				price += Y * 2 * C;
			}else price += Y * B;
		}
		
		System.out.println(price);
	}

}