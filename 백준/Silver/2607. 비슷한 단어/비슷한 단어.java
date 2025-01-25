import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		
		String S = br.readLine();
		int alpha_cnt = (int)('Z' - 'A') + 1;
		int[] A = new int[alpha_cnt];
		for(int i = 0; i < S.length(); ++i) {
			++A[(int)(S.charAt(i) - 'A')];
		}
		
		int ans = 0;
		for(int i = 0; i < N - 1; ++i) {
			String str = br.readLine();
			int[] B = new int[alpha_cnt];
			for(int j = 0; j < str.length(); ++j) {
				++B[(int)(str.charAt(j) - 'A')];
			}	
			
			int diff = 0;
			for(int j = 0; j < alpha_cnt; ++j) {
				diff += Math.abs(A[j] - B[j]);
			}
			
			if(S.length() == str.length()) {
				if(diff <= 2) ++ans;
			} else if(Math.abs(S.length()- str.length()) == 1) {
				if(diff == 1) ++ans;
			}
			
			
		}

		System.out.println(ans);
	}

}