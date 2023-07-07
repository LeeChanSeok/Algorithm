import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

	static StringBuilder sb = new StringBuilder();
	
	static int N, M;
	static int[] parents;
	static List<Integer>[] tree;
	static int[] D;
	
	public static void main(String[] args) throws IOException {
		
		input();
		pro();

	}

	private static void pro() {

		dfs(1);			
		
		for(int i = 1; i <= N; ++i) sb.append(D[i]).append(' ');
		System.out.println(sb);
		
	}

	private static void dfs(int node) {
				
		for(int next : tree[node]) {
			D[next] += D[node];
			dfs(next);
		}
		
	}

	private static void input() throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		tree = new List[N+1];
		for(int i = 1; i <= N; ++i) tree[i] = new LinkedList<>();
		
		parents = new int[N+1];
		st = new StringTokenizer(br.readLine());
		for(int i = 1; i <= N; ++i) {
			int parents = Integer.parseInt(st.nextToken());
			
			if(parents == -1) continue;
			tree[parents].add(i);			
		}
				
		D = new int[N+1];
		for(int i = 0; i < M; ++i) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			D[x] += y;
		}
	}

}
