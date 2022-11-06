import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {

	static class Info{
		int x, move;

		public Info(int x, int move) {
			super();
			this.x = x;
			this.move = move;
		}
		
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		int INF = Integer.MAX_VALUE;
		int ans = INF;
		
		Info cur;
		int pnt, next, move;
		
		if(K <= N) ans = N - K;		
		else {
			Map<Integer, Integer> history = new HashMap<>();
			history.put(N, 0);
			
			PriorityQueue<Info> q = new PriorityQueue<>((q1, q2)->q1.move - q2.move);
			q.add(new Info(N, 0));
			while(!q.isEmpty()) {
				cur = q.poll();
				pnt = cur.x; move = cur.move;
				
				if(move >= ans) break;
				
				if(pnt >= K) {
					ans = Math.min(ans, move + pnt-K);
					continue;
				}
				
				// 0초 후 2*X 위치 이동
				next = pnt*2;
				if(history.getOrDefault(next, INF) > move) {
					history.put(next, move);
					q.add(new Info(next, move));
				}
				
				// 1초 후 X+1  위치 이동
				next = pnt+1;
				if(history.getOrDefault(next, INF) > move+1) {
					history.put(next, move+1);
					q.add(new Info(next, move+1));
				}
				
				// 1초 후 X-1 위치 이동
				next = pnt-1;
				if(next < 0) continue;
				if(history.getOrDefault(next, INF) > move+1) {
					history.put(next, move+1);
					q.add(new Info(next, move+1));
				}
			}
			
		}
		
		System.out.println(ans);

	}

}