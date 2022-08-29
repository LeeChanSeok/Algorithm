import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

	
	static int N, M, min;
	static int[] move;
	static int[] visit;
	static final int INF = Integer.MAX_VALUE;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		move = new int[101];
		for(int i = 0, Size = N + M; i < Size; i++) {
			st = new StringTokenizer(br.readLine());
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			
			move[from] = to;
		}
		
		visit = new int[101];
		Arrays.fill(visit, INF);
		min = INF;
		dfs(1, 0);
		System.out.println(min);
	}

	private static void dfs(int idx, int cnt) {
		
		if(cnt >= min) return;
		
		if(move[idx] != 0) {
			idx = move[idx];
			if(cnt >= visit[idx]) return;
			visit[idx] = cnt;
		}
		
		if(idx == 100) {
			min = cnt;
			return;
		}
		
		for(int i = 6; i > 0; i--) {
			if(idx+ i > 100 || cnt+1 >= visit[idx+i])continue;
			
			visit[idx + i] = cnt+1;
			dfs(idx + i, cnt+1);
		}
		
	}

}