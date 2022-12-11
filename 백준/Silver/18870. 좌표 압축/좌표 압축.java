import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;
import java.util.TreeSet;

public class Main {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		
		int N = Integer.parseInt(br.readLine());
		
		TreeSet<Integer> set = new TreeSet<>();
		
		int[] pnt = new int[N];
		int num;
		
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i < N; ++i) {
			num = Integer.parseInt(st.nextToken());
			pnt[i] = num;
			set.add(num);
		}
		
		Map<Integer, Integer> countMap = new HashMap<>();
		
		int idx = 0;
		while(!set.isEmpty()) {
			num = set.pollFirst();
			countMap.put(num, idx++);
		}
		
		for(int n : pnt) {
			sb.append(countMap.get(n) + " ");
		}
		
		bw.write(sb.toString());
		bw.close();
		
	}

}