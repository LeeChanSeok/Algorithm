import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {

	static class Data implements Comparable<Data> {
		int num, pos;

		public Data(int num, int pos) {
			super();
			this.num = num;
			this.pos = pos;
		}

		@Override
		public int compareTo(Data o) {
			return o.num - this.num;
		}

	}

	static int n, k;
	static int[] arr;
	static PriorityQueue<Data> pq;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		n = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());

		arr = new int[n];
		pq = new PriorityQueue<>();

		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < n; ++i) {
			arr[i] = Integer.parseInt(st.nextToken());
			pq.offer(new Data(arr[i], i));
		}

		selection_sort();
	}

	private static void selection_sort() {
		StringBuilder sb = new StringBuilder();
		int change = 0;
		for (int last = n - 1; last >= 1; --last) {

			Data p = null;
			while ((p = pq.poll()).pos > last)
				;

			if (p.pos != last) {
				++change;

				Data q = new Data(arr[last], p.pos);
				arr[p.pos] = arr[last];
				arr[last] = p.num;
				pq.offer(q);

				if (change == k) {
					for (int num : arr) {
						sb.append(num + " ");
					}
					System.out.println(sb);
					return;
				}
			}

		}

		System.out.println(-1);
	}

}