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
		
		String str;
		int s, e;
		boolean isPalindrome;
		while(!(str = br.readLine()).equals("0")) {
			s = 0;
			e = str.length() - 1;
			isPalindrome = true;
			while(s < e) {
				if(str.charAt(s) != str.charAt(e)) {
					isPalindrome = false;
					break;
				}
				++s; --e;
			}
			
			if(isPalindrome) sb.append("yes\n");
			else sb.append("no\n");
		}

		bw.write(sb.toString());
		bw.close();
	}

}