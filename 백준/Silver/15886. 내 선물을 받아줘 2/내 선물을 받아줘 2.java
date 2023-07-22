import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		char[] arrow = br.readLine().toCharArray();
		
		int step = arrow.length;
		int ans = 0;
		for(int i = 1; i < step; ++i) {
			if(arrow[i] == 'W' && arrow[i-1] == 'E') ++ans;
		}
		
		System.out.println(ans);
		
	}

}