import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int N, K, ans;
	static boolean[] visit;
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		
		visit = new boolean[200001];
		visit[N] = true; 
		System.out.println(bfs());
		
	}

	private static int bfs() {
		Queue<Integer> q = new ArrayDeque<>();
		q.add(N);
		int time = 0;
		int min = Integer.MAX_VALUE;
		
		while(!q.isEmpty()) {
			
			int qSize = q.size();
			
			for(int i = 0; i < qSize; i++) {
				int cur = q.poll();
				if( cur == K)  return time;
				if( cur > K) {
					min = Math.min(min, time + cur - K);
				}
				
				if( cur > 0 && !visit[cur - 1] ) {
					visit[cur - 1] = true;
					q.add(cur - 1);
				}
				
				if( cur < 200000 && !visit[cur + 1] ) {
					visit[cur + 1] = true;
					q.add(cur + 1);
				}
				
				if( cur <= 100000 && !visit[cur*2] ) {
					visit[cur*2] = true;
					q.add(cur*2);
				}
				
			}
			if(time >= min) break;
			time++;
		}
		return min;
		
	}

}