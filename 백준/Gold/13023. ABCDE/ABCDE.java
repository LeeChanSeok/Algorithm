import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {
	static int N, M;
	static Map<Integer, List<Integer>> graph;
	static boolean[] visit;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		graph = new HashMap<>();		
		for(int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			
			if(!graph.containsKey(from)) graph.put(from, new ArrayList<>());
			if(!graph.containsKey(to)) graph.put(to, new ArrayList<>());
			
			graph.get(from).add(to);
			graph.get(to).add(from);
		}
		
		int ans = 0;
		for(int v = 0; v < N; v++) {
			visit = new boolean[N];
			if(!graph.containsKey(v)) continue;
			if(dfs(v, 1)) {
				ans = 1;
				break;
			}			
		}
		
		sb.append(ans);
		bw.write(sb.toString());
		bw.close();
		
	}
	private static boolean dfs(int v, int length) {
		if(length == 5) return true;
		visit[v] = true;
		
		List<Integer> vertexs = graph.get(v);
		
		for(int nv : vertexs) {
			if(!visit[nv]) 
				if(dfs(nv, length + 1)) return true;
		}
		
		visit[v] = false;
		return false;
		
	}

}