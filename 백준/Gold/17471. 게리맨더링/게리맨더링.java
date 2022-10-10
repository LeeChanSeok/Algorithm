import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;
import java.util.StringTokenizer;

public class Main {

	static int N, M, min, num, INF = Integer.MAX_VALUE;
	static int total_population;
	static int[] population;
	static Set<Integer>[] graph;
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		N = Integer.parseInt(br.readLine());
		population = new int[N+1];
		
		total_population = 0;
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i < N; ++i) {
			num = Integer.parseInt(st.nextToken());
			population[i] = num;
			total_population += num;
		}
		
		graph = new HashSet[N];
		for(int i = 0; i < N; ++i) {
			
			st = new StringTokenizer(br.readLine());
			M = Integer.parseInt(st.nextToken());
			
			graph[i] = new HashSet<>();
			for(int j = 0; j < M; ++j)
				graph[i].add(Integer.parseInt(st.nextToken())-1);
		}

		min = INF;
		// 조합의 개수
		for(int c = 1; c <= N/2; ++c) {
			// 시작할 노드 위치
				dfs(0, 0, c, 0, 0);
		}
		if(min == INF)
			System.out.println(-1);
		else
			System.out.println(min);
	}
	private static void dfs(int cur, int cnt, int C, int flag, int popul) {

		if(cnt == C) {
			
			if(isLink(flag ^ ((1 << N)-1), flag)
					&& isLink(flag, flag ^ ((1 << N)-1))) {
					min = Math.min(min,Math.abs(total_population - popul*2));
			}
			return;
		}
		
		for(int i = cur; i < N; ++i) {
			dfs(i + 1, cnt + 1, C, flag | 1 << i, popul + population[i]);
		}
		
	}
	private static boolean isLink(int flagA, int flagB) {
		int visit = 0;
		Queue<Integer> q = new LinkedList<>();
		for(int i = 0; i < N; ++i) {
			if((flagB & 1 << i) != 0) {
				visit |= 1 << i; 
				q.add(i); break;
			}
		}
		
		int cur = 0;
		while(!q.isEmpty()) {
			cur = q.poll();
			
			for(int next : graph[cur]) {
				if( ((flagA & (1 << next)) != 0) ||
						((visit & (1 << next)) != 0)) continue;
				visit |= 1<< next;
				q.offer(next);
			}
		}
		
		if((visit & flagB) == flagB) return true;
		else return false;
	}

}