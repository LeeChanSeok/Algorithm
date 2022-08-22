import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayDeque;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Queue;
import java.util.Set;
import java.util.StringTokenizer;

public class Solution {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		
		int T = 10;
		for(int tc = 1; tc <= T; tc++) {
			st = new StringTokenizer(br.readLine());
			
			int N = Integer.parseInt(st.nextToken());
			int S = Integer.parseInt(st.nextToken());
			
			Map<Integer, Set<Integer>> graph = new HashMap<>();
			st = new StringTokenizer(br.readLine());
			for(int i = 0, nSize = N/2; i < nSize; i++) {
				int from = Integer.parseInt(st.nextToken());
				int to = Integer.parseInt(st.nextToken());
				
				if(!graph.containsKey(from)) graph.put(from, new HashSet<Integer>());
				if(!graph.containsKey(to)) graph.put(to, new HashSet<Integer>());
				graph.get(from).add(to);
			}
			
			// BFS()
			boolean[] visit = new boolean[101];
			Queue<Integer> q = new ArrayDeque<>();
			q.add(S);
			visit[S] = true;
			int max = 0;
			while(!q.isEmpty()) {
				max = 0;
				
				int qSize = q.size();				
				for(int i = 0; i < qSize; i++) {
					int cur = q.poll();
					max = Math.max(max, cur);
					for(int next : graph.get(cur)) {
						if(visit[next]) continue;						
						visit[next] = true;
						q.add(next);
					}
				}
			}
			
			sb.append("#" + tc + " " + max + "\n");
			
		}//test-case 종료
		
		bw.write(sb.toString());
		bw.close();
	}

}
