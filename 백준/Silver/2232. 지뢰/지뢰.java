import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;

public class Main {

	static class Mine implements Comparable<Mine> {
		int v, p;

		public Mine(int v, int p) {
			super();
			this.v = v;
			this.p = p;
		}

		@Override
		public int compareTo(Mine o) {
			// TODO Auto-generated method stub
			return o.v - this.v;
		}

	}

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int N = Integer.parseInt(br.readLine());
		int[] arr = new int[N + 1];

		PriorityQueue<Mine> pq = new PriorityQueue<>();
		boolean[] visited = new boolean[N + 1];
		int visit = 0;

		for (int i = 1; i <= N; ++i) {
			int num = Integer.parseInt(br.readLine());
			arr[i] = num;
			pq.offer(new Mine(num, i));
		}

		List<Integer> ans = new LinkedList<>();
		while (visit != N) {
			Mine mine = pq.poll();
			int v = mine.v;
			int p = mine.p;
			if (visited[p])
				continue;

			ans.add(p);
			visited[p] = true;
			++visit;

			// left
			v = mine.v;
			p = mine.p - 1;
			while (p > 0 && arr[p] < v) {
				if (visited[p])
					break;
				++visit;
				visited[p] = true;
				v = arr[p];
				--p;
			}
			// right
			v = mine.v;
			p = mine.p + 1;
			while (p <= N && arr[p] < v) {
				if (visited[p])
					break;
				++visit;
				visited[p] = true;
				v = arr[p];
				++p;
			}

		}

		Collections.sort(ans);
		for (int num : ans) {
			sb.append(num).append('\n');
		}
		
		System.out.println(sb);

	}

}