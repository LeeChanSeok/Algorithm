import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		
		int N = Integer.parseInt(br.readLine());
		int M = Integer.parseInt(br.readLine());
		int INF = 10_000_000;
		int[][] graph = new int[N][N];
		for(int i = 0; i < N; ++i) {
			Arrays.fill(graph[i], INF);
		}
		
		int a, b, c;
		while(M-- >0){
			st = new StringTokenizer(br.readLine());

			a = Integer.parseInt(st.nextToken())-1;
			b = Integer.parseInt(st.nextToken())-1;
			c = Integer.parseInt(st.nextToken());
			
			graph[a][b] = Math.min(graph[a][b], c);
		}

		for(int k = 0; k < N; ++k) {
			for(int i = 0; i < N; ++i) {
				if(i == k) continue;
				for(int j = 0; j < N; ++j) {
					if(j == k || i == j) continue;
					graph[i][j] = Math.min(graph[i][j], graph[i][k] + graph[k][j]);
					
				}
			}
		}
		
		int dist;
		for(int i = 0; i < N; ++i) {
			for(int j = 0; j < N; ++j) {
				dist = graph[i][j];
				if(dist == INF) sb.append("0 ");
				else sb.append(dist + " ");
			}
			sb.append("\n");
		}
		
		bw.write(sb.toString());
		bw.close();
	}

}