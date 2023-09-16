import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		String str = br.readLine();
		for(int i = 0, len = str.length(); i < len; ++i) {
			char c = str.charAt(i);
			
			if(c >= 'A' && c <= 'Z') 
				sb.append((char)((c - 'A' + 13) % 26 + 'A'));
			else if(c >= 'a' && c <= 'z') 
				sb.append((char)((c - 'a' + 13) % 26 + 'a'));
			else sb.append(c);
		}
		
		System.out.println(sb);

	}

}