import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int n, m, r;
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		r = Integer.parseInt(st.nextToken());
		
		int[] items = new int[n+1];
		st = new StringTokenizer(br.readLine());
		for(int i = 1; i <= n; ++i) items[i] = Integer.parseInt(st.nextToken());
		
		final int INF = (int)1e9;
		int[][] graph = new int[n+1][n+1];
		for(int i = 1; i <= n; ++i) {
			for(int j = 1; j <= n; ++j) {
				if(i == j) graph[i][j] = 0;
				else graph[i][j] = INF;
			}
		}
		
		int a, b, l;
		for(int i = 0; i < r; ++i) {
			st = new StringTokenizer(br.readLine());
			a = Integer.parseInt(st.nextToken());
			b = Integer.parseInt(st.nextToken());
			l = Integer.parseInt(st.nextToken());
			
			graph[a][b] = graph[b][a] = l;
		}
		
		for(int k = 1; k <= n; ++k) {
			for(int i = 1; i <= n; ++i) {
				for(int j = 1; j <=n; ++j) {
					graph[i][j] = Math.min(graph[i][j], graph[i][k] + graph[k][j]);
				}
			}
		}
		
		int max = 0;
		for(int i = 1; i<= n; ++i) {
			int sum = 0;
			for(int j = 1; j <= n; ++j) {
				if(graph[i][j] <= m) sum += items[j];
			}
			max = Math.max(max, sum);
		}
		
		System.out.println(max);
		
	}

}
