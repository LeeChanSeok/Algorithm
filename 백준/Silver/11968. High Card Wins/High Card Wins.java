import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {

	static int n;
	static int[] A, B;
	static boolean[] cards;
	
	public static void main(String[] args) throws Exception{
		input();
		pro();
	}

	private static void pro() {
		
		Arrays.sort(A);
		Arrays.sort(B);
		
		int ans = 0;
		int j = n;
		for(int i = n; i > 0; --i) {
			int num = B[i];
			while(num < A[j] && j > 0) --j;
			
			if(j == 0) break;
			++ans;
			--j;
		}
		
		System.out.println(ans);
		
	}

	private static void input() throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		n = Integer.parseInt(br.readLine());
		
		A = new int[n+1];
		B = new int[n+1];
		
		cards = new boolean[2*n+1];
		int aCnt = 1;
		for(int i = 1; i <= n; ++i) {
			int num = Integer.parseInt(br.readLine());
			A[aCnt++] = num;
			cards[num] = true;
		}
		
		int bCnt = 1;
		for(int i = 1; i <= 2 *n; ++i) {
			if(!cards[i]) B[bCnt++] = i; 
		}
	}

}