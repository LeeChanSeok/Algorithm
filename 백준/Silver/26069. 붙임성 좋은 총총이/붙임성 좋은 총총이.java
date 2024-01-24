import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int n = Integer.parseInt(br.readLine());
		Set<String> dance = new HashSet<>();
		
		dance.add("ChongChong");
		
		int cnt = 1;
		while(n-- > 0) {
			st = new StringTokenizer(br.readLine());
			
			String p1 = st.nextToken();
			String p2 = st.nextToken();
			
			if(dance.contains(p1) && !dance.contains(p2)) {
				dance.add(p2);
				++cnt;
			}
			else if(!dance.contains(p1) && dance.contains(p2)) {
				dance.add(p1);
				++cnt;
			}
			
		}
		
		System.out.println(cnt);

	}

}