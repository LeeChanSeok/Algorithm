import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int M = Integer.parseInt(st.nextToken());
		int N = Integer.parseInt(st.nextToken());

		Map<Integer, String> int2str = new HashMap<>();
		int2str.put(0, "zero");
		int2str.put(1, "one");
		int2str.put(2, "two");
		int2str.put(3, "three");
		int2str.put(4, "four");
		int2str.put(5, "five");
		int2str.put(6, "six");
		int2str.put(7, "seven");
		int2str.put(8, "eight");
		int2str.put(9, "nine");

		Map<String, Integer> str2int = new HashMap<>();
		str2int.put("zero", 0);
		str2int.put("one", 1);
		str2int.put("two", 2);
		str2int.put("three", 3);
		str2int.put("four", 4);
		str2int.put("five", 5);
		str2int.put("six", 6);
		str2int.put("seven", 7);
		str2int.put("eight", 8);
		str2int.put("nine", 9);

		PriorityQueue<String> pq = new PriorityQueue<>();
		for (int i = M; i <= N; ++i) {
			String str = "";
			int num = i;
			if (num >= 10) {
				str += int2str.get(num / 10) + " " + int2str.get(num % 10);
			} else
				str += int2str.get(num);

			pq.offer(str);
		}

		int cnt = 0;

		while (!pq.isEmpty()) {
			String str = pq.poll();
			int num = 0;
			st = new StringTokenizer(str);
			while (st.hasMoreTokens()) {
				num = num * 10 + str2int.get(st.nextToken());
			}

			++cnt;
			bw.write(num + " ");
			if (cnt % 10 == 0)
				bw.write('\n');

		}

		bw.flush();
	}

}