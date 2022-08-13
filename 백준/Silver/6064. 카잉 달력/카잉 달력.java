import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int T= Integer.parseInt(br.readLine());
		int M, N, x, y;
		int ans;
		for(int tc = 1; tc <= T; tc++) {
			st = new StringTokenizer(br.readLine());
			M = Integer.parseInt(st.nextToken());
			N = Integer.parseInt(st.nextToken());
			x = Integer.parseInt(st.nextToken());
			y = Integer.parseInt(st.nextToken());
			
			ans = -1;
			if(x == y) ans = x;
			else ans = solution(M, N, x, y);
			System.out.println(ans);
		}
	}
	
	public static int solution(int M, int N, int x, int y) {
		int gcd = LCM(M, N);
		int i = 0, j = 0;
		int A, B;
		while (i < gcd/M && j < gcd/N) {
			A = M * i + x;
			B = N * j + y;
			if (A == B) return A;
			else if(A > B) j++;
			else i++;
		}
		return -1;
	}
	
	public static int LCM(int A, int B) {
		if (B > A) {
			int temp = A;
			A = B;
			B = temp;
		}
		
		return (A * B)/GCD(A, B);
	}
	
	public static int GCD(int A, int B) {
		if(B == 0)	return A;
		return GCD(B, A % B);
		
	}
	
}