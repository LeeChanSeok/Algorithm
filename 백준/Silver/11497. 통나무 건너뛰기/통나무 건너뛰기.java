import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		
		int T = Integer.parseInt(br.readLine());
		while(T-- > 0) {
			int N = Integer.parseInt(br.readLine());
			PriorityQueue<Integer> pq = new PriorityQueue<>();
			
			st = new StringTokenizer(br.readLine());
			for(int i = 0; i < N; ++i) {
				pq.offer(Integer.parseInt(st.nextToken()));
			}
			
			int[] res = new int[N];
			res[N/2] = pq.poll();
			int l = N/ 2 - 1;
			int r = N/ 2 + 1;
			
			while(!pq.isEmpty()) {
				if(r < N) res[r++] = pq.poll();
				if(l >= 0) res[l--] = pq.poll();
			}
			
			int max = Math.abs(res[0] - res[N - 1]);
			for(int i = 0; i < N - 1; ++i) {
				max = Math.max(max, Math.abs(res[i] - res[i + 1]));
			}
			
			sb.append(max).append("\n");
		}
		
		System.out.println(sb);

	}

}