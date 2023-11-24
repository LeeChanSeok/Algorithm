import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	
	static int L;
	static int[] S;
	static int n;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		L = Integer.parseInt(br.readLine());
		S = new int[L+1];

		
		st = new StringTokenizer(br.readLine());
		for(int i = 1; i <= L; ++i) S[i] = Integer.parseInt(st.nextToken());
		Arrays.sort(S);
		
		n = Integer.parseInt(br.readLine());
		
		int ans = pro();
		System.out.println(ans);
	}

	private static int pro() {

		int res = 0;
		for(int i = 0; i <= L ; ++i) {
			if(S[i] == n) return 0;
			if(S[i] <= n && n < S[i+1]) {
				
				return (n - S[i]) * (S[i+1] - n) - 1;
			}
		}
		
		return res;
	}
	

}