import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int n = Integer.parseInt(br.readLine());
		
		int max = 0;
		String ans = null;
		
		for(int i = 0; i < n; ++i) {
			st = new StringTokenizer(br.readLine());
			
			int salary = Integer.parseInt(st.nextToken());
			String name = st.nextToken();
			String nation = st.nextToken();
			
			if(nation.equals("Russia")) {
				if(salary > max) {
					max = salary;
					ans = name;
				}
			}
		}
		
		System.out.println(ans);

	}

}