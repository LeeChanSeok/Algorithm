import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	static boolean[][] graph;
	static int[] dijkstra;
	static int n, m;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(br.readLine());

		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		
		graph = new boolean[n][n];
		int k, a ,b;
		for(int i = 0; i < m; ++i) {
			st = new StringTokenizer(br.readLine());
			
			a = Integer.parseInt(st.nextToken())-1;
			b = Integer.parseInt(st.nextToken())-1;
			
			graph[a][b] = graph[b][a] = true;
		}
		
		int q = Integer.parseInt(br.readLine());
		
		for(int i = 0; i < q; ++i) {
			st = new StringTokenizer(br.readLine());
			
			k = Integer.parseInt(st.nextToken());
			a = Integer.parseInt(st.nextToken())-1;
			b = Integer.parseInt(st.nextToken())-1;
			
			if(k == 1) graph[a][b] = graph[b][a] = true;
			else graph[a][b] = graph[b][a] = false;
			
			dijkstra = new int[n];
			Arrays.fill(dijkstra, -1);
			solution();
			
			for(int j = 0; j < n; ++j) sb.append(dijkstra[j] + " ");
			sb.append("\n");
		}
		
		bw.write(sb.toString());
		bw.flush();
		
		bw.close();
		br.close();
	}

	private static void solution() {

		Queue<Integer> q = new LinkedList<>();
		q.offer(0);
		
		dijkstra[0] = 0;
		
		int cur;
		int qSize;
		int move = 1;
		while(!q.isEmpty()) {
			
			qSize = q.size();
			while(qSize-- > 0){
				cur = q.poll();
				
				for(int i = 0; i < n; ++i) {
					if(graph[cur][i] && dijkstra[i] == -1) {
						q.offer(i);
						dijkstra[i] = move;
					}
				}
			}
			++move;
		}
		
	}

}