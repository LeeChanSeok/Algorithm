import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuffer sb = new StringBuffer();
		
		int A = Integer.parseInt(st.nextToken());
		int B = Integer.parseInt(st.nextToken());

		int GCD = (A > B ? GCD(A, B): GCD(B, A));
		int LCM = (A * B) / GCD;
		sb.append(GCD).append("\n");
		sb.append(LCM);
		System.out.println(sb);
	}
	
	public static int GCD(int A, int B) {
		if(B == 0) return A;
		else return GCD(B, A%B);
	}
}