import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	
	static class Data{
		int num;
		int cnt;
		
		public Data(int num, int cnt) {
			super();
			this.num = num;
			this.cnt = cnt;
		}

		@Override
		public String toString() {
			return "[num=" + num + ", cnt=" + cnt + "]";
		}
		
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		
		int maxV = 100;
		
		int N = Integer.parseInt(br.readLine());
		int[] A = new int[N];
		int[] cntA = new int[maxV + 1];
		
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i < N; ++i) {
			int num = Integer.parseInt(st.nextToken());
			A[i] = num;
			++cntA[num];
		}
		
		int M = Integer.parseInt(br.readLine());
		int[] B = new int[M];
		int[] cntB = new int[maxV + 1];
		
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i < M; ++i) {
			int num = Integer.parseInt(st.nextToken());
			B[i] = num;
			++cntB[num];
		}
		
		
		Map<Integer, Queue<Integer>> mapA = new HashMap<>();
		for(int i = 0; i < N; ++i) {
			int num = A[i];
			if(cntB[num] == 0) continue;
			
			if(!mapA.containsKey(num)) {
				Queue<Integer> q = new LinkedList<>();
				mapA.put(num, q);
			}
			
			mapA.get(num).add(i);
		}

		Map<Integer, Queue<Integer>> mapB = new HashMap<>();
		for(int i = 0; i < M; ++i) {
			int num = B[i];
			if(cntA[num] == 0) continue;
			
			if(!mapB.containsKey(num)) {
				Queue<Integer> q = new LinkedList<>();
				mapB.put(num, q);
			}
			
			mapB.get(num).add(i);
		}
		
		
		Queue<Data> q = new LinkedList<>();
		for(int i = maxV; i > 0; --i) {
			int cnt = Math.min(cntA[i], cntB[i]);
			if(cnt == 0) continue;
			
			q.offer(new Data(i, cnt));
		}
		
		List<Integer> ans = new LinkedList<>();
		
		int aPos = -1;
		int bPos = -1;
		while(!q.isEmpty()) {
			Data data = q.poll();
			
			int num = data.num;
			int cnt = data.cnt;
			
			while(cnt-- > 0) {
				
				int ap = -1;
				Queue<Integer> aq = mapA.get(num);
				while(!aq.isEmpty() && (ap = aq.poll()) <= aPos);
				
				int bp = -1;
				Queue<Integer> bq = mapB.get(num);
				while(!bq.isEmpty() && (bp = bq.poll()) <= bPos);
				
				if(ap > aPos && bp > bPos) {
					aPos = ap;
					bPos = bp;
					ans.add(num);
				}
				
			}
		}
		
		sb.append(ans.size()).append('\n');
		for(int v : ans) {
			sb.append(v + " ");
		}
	
		System.out.println(sb);		
	}

}