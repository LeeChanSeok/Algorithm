import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static int N, M;
	static int[] board;
	
	public static void main(String[] args) throws Exception {
		
		input();
		pro();

	}

	private static void pro() throws Exception {

		int pos = 1, cnt = 0;
		for(int i = 1; i <= M; ++i, ++cnt) {
			
			if(pos >= N) break;
			int x = Integer.parseInt(br.readLine());
			
			pos = Math.min(N, pos + x);
			pos += board[pos];
			
		}
		System.out.println(cnt);
		
	}

	private static void input() throws Exception {

		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		board = new int[N+1];
		for(int i = 1; i <= N; ++i) board[i] = Integer.parseInt(br.readLine());
		
	}

}
