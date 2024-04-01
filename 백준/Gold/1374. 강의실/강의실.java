import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int n = Integer.parseInt(br.readLine());
		
		int[][] time = new int[n][2];
		for(int i = 0; i < n; ++i) {
			st = new StringTokenizer(br.readLine());
			st.nextElement();
			
			time[i][0] = Integer.parseInt(st.nextToken());
			time[i][1] = Integer.parseInt(st.nextToken());
		}
		
		Arrays.sort(time, (t1, t2) -> t1[0] - t2[0]);
		
		PriorityQueue<Integer> pq = new PriorityQueue<>();
		
		int ans = 0;
		for(int[] t : time) {
			
			int s = t[0], e = t[1];
			
			while(!pq.isEmpty() && pq.peek() <= s) pq.poll();
			
			pq.offer(e);
			ans = Math.max(ans, pq.size());
			
		}

		System.out.println(ans);
	}

}