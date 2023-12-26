import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int t = Integer.parseInt(br.readLine());
		while(t-- >0) {
			String str = br.readLine();
			sb.append(str.charAt(0) +""+ str.charAt(str.length()-1)).append('\n');
		}

		System.out.println(sb);
	}

}