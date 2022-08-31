import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Solution {
	
	static final int size = 100;
	static int[][] graph;
	static boolean[] visit;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int T = 10;
		for(int tc = 1; tc <= T; tc++) {
			st = new StringTokenizer(br.readLine());
			st.nextToken();
			int N = Integer.parseInt(st.nextToken());
			
			graph = new int[2][size];
			st = new StringTokenizer(br.readLine());
			for(int i = 0; i < N; i++) {
				int from = Integer.parseInt(st.nextToken());
				int to = Integer.parseInt(st.nextToken());
				
				if(graph[0][from] == 0) graph[0][from] = to;
				else graph[1][from] = to;
			}
			// 입력 완룍
			visit = new boolean[size];
			Stack<Integer> stack = new Stack<>();
			stack.add(0);
			boolean isPath = false;
			while(!stack.isEmpty()) {
				int cur = stack.pop();
				if(cur == 99) {
					isPath = true;
					break;
				}
				visit[cur] = true;
				
				for(int d = 0; d < 2; d++) {
					int next = graph[d][cur];
					if(next != 0 && !visit[next]) {
						stack.add(next);
					}
				}
			}
			
			int res = 0;
			if(isPath) res = 1; 
			System.out.println("#" + tc + " " + res);
			
		}

	}

}