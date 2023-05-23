import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Map.Entry;
import java.util.TreeMap;

public class Main {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		
		int N = Integer.parseInt(br.readLine());
		TreeMap<String, Integer> file = new TreeMap<>();
			
		String type;
		for(int i = 0; i < N; ++i) {
			type = br.readLine().split("\\.")[1];
			
			if(!file.containsKey(type)) file.put(type, 0);
			file.put(type, file.get(type) + 1);
		}
		
		for(Entry<String, Integer> entry : file.entrySet()) {
			sb.append(entry.getKey() + " "  + entry.getValue() + "\n");
		}

		bw.write(sb.toString());
		bw.flush();
		
		bw.close();
		br.close();
	}

}