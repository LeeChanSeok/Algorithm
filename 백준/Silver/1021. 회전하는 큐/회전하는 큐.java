import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class Main {
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		
		Deque<Integer> q = new ArrayDeque<>();
		for(int i = 1; i <= n; ++i) {
			q.offer(i);
		}
		
		int size = n;
		int total = 0;
		
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i < m; ++i) {
			int k = Integer.parseInt(st.nextToken());
			
			int idx = 0;
			for(int num : q) {
				if(num == k) break;
				++idx;
			}
			
			int cnt = idx;
			if(idx <= size - idx) {
				for(int j = 0; j < cnt; ++j)
					q.offer(q.poll());
			}
			else {
				cnt = size - idx;
				for(int j = 0; j < cnt; ++j)
					q.offerFirst(q.pollLast());
			}
			
			q.poll();
			size--;
			total += cnt;
		}
		
		System.out.println(total);
	}


}