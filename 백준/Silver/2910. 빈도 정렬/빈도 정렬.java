import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.StringTokenizer;

public class Main {

	static class Data implements Comparable<Data> {
		int num;
		int order;
		int cnt;

		public Data(int num, int order, int cnt) {
			super();
			this.num = num;
			this.order = order;
			this.cnt = cnt;
		}

		@Override
		public int compareTo(Data o) {
			if (this.cnt == o.cnt)
				return this.order - o.order;
			return o.cnt - this.cnt;
		}
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(br.readLine());

		int n = Integer.parseInt(st.nextToken());
		int c = Integer.parseInt(st.nextToken());

		Map<Integer, Data> map = new HashMap<>();

		int order = 0;
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < n; ++i) {
			int num = Integer.parseInt(st.nextToken());

			if (map.containsKey(num))
				++map.get(num).cnt;
			else {
				map.put(num, new Data(num, ++order, 1));
			}
		}

		int idx = 0;
		Data[] datas = new Data[order];
		for (Entry<Integer, Data> entry : map.entrySet()) {
			Data data = entry.getValue();
			datas[idx++] = data;
		}

		Arrays.sort(datas);

		for (Data data : datas) {
			int num = data.num;
			int cnt = data.cnt;

			for (int i = 0; i < cnt; ++i) {
				sb.append(num + " ");
			}
		}

		System.out.println(sb);

	}

}