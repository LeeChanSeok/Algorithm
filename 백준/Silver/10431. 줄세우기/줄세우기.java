import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		int P = Integer.parseInt(br.readLine());
		for(int tc = 1; tc <= P; ++tc) {
			st = new StringTokenizer(br.readLine());
			st.nextToken();

			int ans = 0;
			
			List<Integer> list = new ArrayList<>(20);
			for(int i = 0; i < 20; ++i) {
				int v = Integer.parseInt(st.nextToken());
				
				int idx = i;
				for(int j = 0; j < i; ++j) {
					if(list.get(j) > v) {
						idx = j;
						break;
					}
				}
				
				list.add(idx, v);
				
				if(idx != i) ans += (i - idx); 
				
			}
			
			sb.append(tc + " " + ans).append('\n');
			
		}
		
		System.out.println(sb);
	}

}