import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		
		String str = br.readLine();
		String explore = br.readLine();
		
		int N = str.length();
		int M = explore.length();
		
		char[] result = new char[N];
		boolean isMatch;
		int idx = 0;
		for(int i = 0; i < N; ++i) {
			
			char c = str.charAt(i);
			isMatch = false;
			
			if(c == explore.charAt(M-1)) {
				if(idx >= M-1) {
					int j = M-2;
					int k = idx-1;
					for(; j >= 0; --j) {
						if(result[k--] != explore.charAt(j)) break;
					}
					if(j == -1) isMatch = true;
				}
			}
			
			if(isMatch) {
				idx = idx - M + 1;
			}else{
				result[idx++] = c;
			}
			
		}
		
		if(idx == 0) sb.append("FRULA");
		else {
			for(int i = 0; i < idx; ++i) {
				char c = result[i];
				if(c == '\0') break;
				sb.append(c);
			}
		}
		
		bw.write(sb.toString());
		bw.flush();
		
		bw.close();
		br.close();
		
	}

}