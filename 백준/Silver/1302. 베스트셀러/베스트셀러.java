import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Map.Entry;
import java.util.TreeMap;

public class Main {

	public static void main(String[] args) throws Exception{

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		
		TreeMap<String, Integer> best = new TreeMap<>((t1, t2) -> t1.compareTo(t2));
		
		for(int i = 0; i < N; ++i) {
			String title = br.readLine();
			
			best.put(title, best.getOrDefault(title, 0) + 1);
		}

		String title = "";
		int count = 0;
		
		for(Entry<String, Integer> entry : best.entrySet()) {
			
			if(entry.getValue() > count) {
				title = entry.getKey();
				count = entry.getValue();
			}
		}
		
		System.out.println(title);
		
	}

}