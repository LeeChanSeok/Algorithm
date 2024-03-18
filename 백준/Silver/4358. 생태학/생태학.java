import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Map.Entry;
import java.util.TreeMap;

public class Main {

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		TreeMap<String, Integer> map = new TreeMap<>();
		String str = null;
		int total = 0;
		while ((str = br.readLine()) != null) {

			int cnt = map.getOrDefault(str, 0);
			map.put(str, cnt + 1);

			++total;
		}

		for (Entry<String, Integer> entry : map.entrySet()) {
			double rate = (double) entry.getValue() / total * 100;
			sb.append(String.format("%s %.4f\n", entry.getKey(), rate));
		}

		System.out.println(sb);

	}

}