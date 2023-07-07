import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	static BufferedReader br;
	static StringBuilder sb = new StringBuilder();
	static int N, Q;
	static boolean[] visited;
	
	public static void main(String[] args) throws IOException {
		
		input();
		pro();
	}

	private static void pro() throws NumberFormatException, IOException {
		
		while(Q-- > 0) {
			int x = Integer.parseInt(br.readLine());
			int y = x;
			int res = 0;
			
			while(y != 0) {
				if(visited[y]) res = y;
				y >>= 1;
			}
			
			visited[x] = true;
			sb.append(res).append("\n");
		}
		
		System.out.println(sb);
		
	}

	private static void input() throws IOException {
		br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		Q = Integer.parseInt(st.nextToken());
		
		visited = new boolean[N+1];
		
	}

}
