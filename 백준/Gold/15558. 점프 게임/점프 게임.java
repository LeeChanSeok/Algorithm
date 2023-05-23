import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	static class Info {
		int x;
		boolean isLeft;

		public Info(int x, boolean isLeft) {
			super();
			this.x = x;
			this.isLeft = isLeft;
		}

	}

	static char[] left, right;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());

		left = br.readLine().toCharArray();
		right = br.readLine().toCharArray();

		System.out.println(solution(N, K));
	}

	private static char solution(int n, int k) {
		char answer = '0';
		
		boolean[] visited_l = new boolean[n];
		boolean[] visited_r = new boolean[n];
		visited_l[0] = true;

		Queue<Info> q = new LinkedList<>();
		q.offer(new Info(0, true));

		Info cur;

		int next;
		int qSize;
		int bound = -1;
		while (!q.isEmpty()) {
			qSize = q.size();
			
			while(qSize-- > 0) {
				cur = q.poll();
				
				if (cur.x == bound)
					continue;
				
				// 1. 앞
				next = cur.x + 1;
				if (next >= n)
					return '1';
				
				if (cur.isLeft) {
					if (left[next] == '1' && !visited_l[next]) {
						q.offer(new Info(next, cur.isLeft));
						visited_l[next] = true;
					}
				} else {
					if (right[next] == '1' && !visited_r[next]) {
						q.offer(new Info(next, cur.isLeft));
						visited_r[next] = true;
					}
				}
				
				// 2. 뒤
				next = cur.x - 1;
				if(next >= 0) {
					if (cur.isLeft) {
						if (left[next] == '1' && !visited_l[next]) {
							q.offer(new Info(next, cur.isLeft));
							visited_l[next] = true;
						}
					} else {
						if (right[next] == '1' && !visited_r[next]) {
							q.offer(new Info(next, cur.isLeft));
							visited_r[next] = true;
						}
					}
				}
				
				// 3. 옆
				next = cur.x + k;
				if (next >= n)
					return '1';
				
				if (cur.isLeft) {
					if (right[next] == '1' && !visited_r[next]) {
						q.offer(new Info(next, !cur.isLeft));
						visited_r[next] = true;
					}
				} else {
					if (left[next] == '1' && !visited_l[next]) {
						q.offer(new Info(next, !cur.isLeft));
						visited_l[next] = true;
					}
				}
				
			}
			++bound;
		}

		return answer;
	}

}
