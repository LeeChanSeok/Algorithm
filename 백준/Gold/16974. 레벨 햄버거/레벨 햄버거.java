import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	static int N;
	static long X;
	static long ans;
	static Long[][] hamberger;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		X = Long.parseLong(st.nextToken());
		

		hamberger = new Long[N+1][2];
		hamberger[0][0] = 0l; hamberger[0][1] = 1l;
		for(int i = 1; i <= N; ++i) {
			long B = hamberger[i-1][0];
			long P = hamberger[i-1][1];
			
			hamberger[i][0] = 2 + B*2;
			hamberger[i][1] = 1 + P*2;
		}
		
		recursive(N);
		System.out.println(ans);
	}

	private static boolean recursive(int L) {
		
		long B = hamberger[L-1][0];
		long P = hamberger[L-1][1];
		long total = B + P;
		
		// B
		--X; if(X == 0) return true;
		
		// L-1
		if(X >= total) {
			X -= total;
			ans += P;
			if(X == 0) return true;
		}else {
			if(recursive(L-1)) return true;
		}
		
		// P
		--X; ++ans; if(X == 0) return true;
		
		// L-1
		if(X >= total) {
			X -= total;
			ans += P;
			if(X == 0) return true;
		}else {
			if(recursive(L-1)) return true;
		}
		
		// B
		--X; if(X == 0) return true;
		
		return false;
		
	}


}