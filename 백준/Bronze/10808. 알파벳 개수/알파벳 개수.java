import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		String str = br.readLine();
		int alphaCnt = 'z' - 'a' + 1;
		int[] alpha = new int[alphaCnt];
		for(int i = 0, len = str.length(); i < len; ++i) {
			++alpha[str.charAt(i) -'a'];
		}
		
		for(int i = 0; i < alphaCnt; ++i) sb.append(alpha[i] + " ");
		System.out.println(sb);
	}

}