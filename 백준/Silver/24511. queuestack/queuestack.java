import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		StringTokenizer st;

		int n = Integer.parseInt(br.readLine());
		int[] qs = new int[n];

		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < n; ++i) {
			qs[i] = Integer.parseInt(st.nextToken());
		}

		Deque<Integer> q = new ArrayDeque();
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < n; ++i) {
			int a = Integer.parseInt(st.nextToken());
			if(qs[i] == 0) {
				q.add(a);
			}
		}

		int m = Integer.parseInt(br.readLine());
		st = new StringTokenizer(br.readLine());

		int b;
		for (int i = 0; i < m; ++i) {
			b = Integer.parseInt(st.nextToken());
			q.addFirst(b);
			sb.append(q.pollLast() + " ");
		}
		
		System.out.println(sb);

	}

}