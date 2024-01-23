import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int n = Integer.parseInt(br.readLine());
		Set<String> chat = new HashSet<>();
		int cnt = 0;
		
		while(n-- > 0) {
			String str = br.readLine();
			if(str.equals("ENTER")) chat.clear();
			else {
				if(!chat.contains(str)) {
					chat.add(str);
					++cnt;
				}
			}
		}
		
		System.out.println(cnt);

	}

}