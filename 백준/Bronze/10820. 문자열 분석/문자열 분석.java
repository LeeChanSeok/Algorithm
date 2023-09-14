import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		String str = null;
		while((str = br.readLine()) != null) {
			int[] ans = new int[4];
			
			for(int i = 0, len = str.length(); i < len; ++i) {
				char c = str.charAt(i);
				if(c >= 'a' && c <= 'z') ++ans[0];
				else if(c >= 'A' && c <= 'Z') ++ans[1];
				else if(c >= '0' && c <= '9') ++ans[2];
				else++ans[3];
			}
			
			sb.append(ans[0] + " ").append(ans[1] + " ").append(ans[2] + " ").append(ans[3] + "\n");
		}

		System.out.println(sb);
	}

}