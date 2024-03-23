import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {

	static class Time {
		int p, q;

		public Time(int p, int q) {
			super();
			this.p = p;
			this.q = q;
		}

	}

	static class Info {
		int id, q;

		public Info(int id, int q) {
			super();
			this.id = id;
			this.q = q;
		}

	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;

		int N = Integer.parseInt(br.readLine());
		int[] arr = new int[N];

		Time[] time = new Time[N];
		for (int i = 0; i < N; ++i) {
			st = new StringTokenizer(br.readLine());

			int p = Integer.parseInt(st.nextToken());
			int q = Integer.parseInt(st.nextToken());

			time[i] = new Time(p, q);
		}

		Arrays.sort(time, (t1, t2) -> t1.p - t2.p);

		PriorityQueue<Info> pq = new PriorityQueue<>((a1, a2) -> {
			return a1.q - a2.q;
		});

		PriorityQueue<Integer> candi = new PriorityQueue<>();
		
		int cnt = 0;
		for (Time t : time) {
			
			while(!pq.isEmpty() && pq.peek().q < t.p) {
				candi.offer(pq.poll().id);
			}

			if (candi.isEmpty()) {
				pq.offer(new Info(cnt, t.q));
				arr[cnt++] = 1;
			} else {

				int id = candi.poll();

				pq.offer(new Info(id, t.q));
				++arr[id];

			}
		}

		sb.append(cnt).append('\n');
		for (int i = 0; i < cnt; ++i) {
			sb.append(arr[i] + " ");
		}

		System.out.println(sb);

	}

}