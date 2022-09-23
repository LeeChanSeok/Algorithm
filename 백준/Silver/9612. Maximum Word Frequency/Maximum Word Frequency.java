import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
	
		Map<String, Integer> map = new HashMap<>();
		
		String str;
		int cnt = 0;
		for(int i = 0; i< N; i++) {
			str = br.readLine();
		
			cnt = map.getOrDefault(str, 0);
			if(cnt == 0) map.put(str, 1);
			else map.put(str, cnt+1);
			
		}
		
		int max = 0; String maxWord = "";
		
		for(String key : map.keySet()) {
			cnt = map.get(key);
			if(cnt > max) {
				max = cnt;
				maxWord = key;
			}else if(cnt == max){
				if(key.compareTo(maxWord) > 0){
					maxWord = key;
				}
			}
		}

		System.out.println(maxWord + " " + cnt);
	}

}