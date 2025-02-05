import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb;
		StringTokenizer st;
		
		Map<String, Integer> map = new HashMap<>();
		map.put("A", 0);
		map.put("A#", 1);
		map.put("B", 2);
		map.put("C", 3);
		map.put("C#", 4);
		map.put("D", 5);
		map.put("D#", 6);
		map.put("E", 7);
		map.put("F", 8);
		map.put("F#", 9);
		map.put("G", 10);
		map.put("G#", 11);
		
		String[] arr = {"A", "A#", "B", "C", "C#", "D", "D#", "E", "F", "F#", "G", "G#"};

		String str = "";
		List<String> list;
		while(true) {
			str = br.readLine();
			if(str.equals("***")) break;
			
			list = new ArrayList<>();
			st = new StringTokenizer(str);
			while(st.hasMoreElements()) {
				String res = st.nextToken();
				
				if(res.length() == 2) {
					if(res.charAt(1) == 'b') {
						res = arr[(map.get(String.valueOf(res.charAt(0))) - 1 + 12) % 12];
					} else {
						if(!map.containsKey(res)) {
							res = arr[(map.get(String.valueOf(res.charAt(0))) + 1) % 12];
						}
					}
				}
				
				list.add(res);
			}
			
			int cmd = Integer.parseInt(br.readLine());
			sb = new StringBuilder();
			
			for(String in : list) {				
				sb.append(arr[(map.get(in) + cmd + 12) % 12] + " ");
			}
			
			bw.write(sb.toString() + "\n");
		}
		
		bw.flush();

	}

}