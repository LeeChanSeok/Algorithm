import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		
		String A, B;
		int max_digit;
		boolean flag;
		int[] digit;
		int T = Integer.parseInt(br.readLine());
		for(int tc = 1; tc <= T; ++tc) {
			st = new StringTokenizer(br.readLine());
			
			A = st.nextToken();
			B = st.nextToken();
			
			flag = false;
			for(int i = 0; i < A.length(); ++i) {
				if(A.charAt(i) == '1') {
					flag = true;
					A = A.substring(i);
					break;
				}
			}
			
			if(!flag) A = "0";
			
			flag = false;
			for(int i = 0; i < B.length(); ++i) {
				if(B.charAt(i) == '1') {
					flag = true;
					B = B.substring(i);
					break;
				}
			}
			if(!flag) B = "0";
			
			digit = new int[81];
			
			int idx = 0;
			for(int i = A.length() - 1; i >= 0; --i) {
				if(A.charAt(i) == '1') digit[idx] = 1;
				++idx;
			}
			
			idx = 0; 
			for(int i = B.length()-1; i >= 0; --i) {
				if(B.charAt(i) == '1') digit[idx] += 1;
				++idx;
			}
			
			max_digit = Math.max(A.length(), B.length());
			for(int i = 0; i < max_digit; ++i) {
				if(digit[i] >= 2) {
					digit[i] -= 2;
					digit[i+1] += 1;
				}
			}
			
			idx = max_digit;
			if(digit[idx] == 0) --idx;
			
			for(int i = idx; i >= 0; --i) sb.append(digit[i]);
			sb.append("\n");
			
		}
		
		bw.write(sb.toString());
		bw.flush();
		
		bw.close();
		br.close();
		
	}

}