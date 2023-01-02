import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		
		int T = Integer.parseInt(br.readLine());
		
		int n, answer;
		String name, part;
		Map<String, Integer> map = new HashMap<>();
		for(int tc = 1; tc <= T; ++tc) {
			map.clear();
			
			n = Integer.parseInt(br.readLine());
			
			for(int i = 0; i < n; ++i) {
				st = new StringTokenizer(br.readLine());
				name = st.nextToken();
				part = st.nextToken();
				
				map.put(part, map.getOrDefault(part, 0)+1);
			}
			
			answer = 1;
			for(String key : map.keySet()) {
				answer *= (map.get(key)+1);
			}
			--answer;
			sb.append(answer + "\n");
		}

		bw.write(sb.toString());
		bw.close();

	}

}