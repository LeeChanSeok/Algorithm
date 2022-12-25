import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;
import java.util.StringTokenizer;

public class Main {

	static class Info{
		int pos;
		char[] board = new char[9];
		
		public Info(int pos) {
			super();
			this.pos = pos;
		}
		
		public Info(int pos, char[] board ) {
			super();
			this.pos = pos;
			this.board = board;
		}

	}
	
	static final int N = 3;
	
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		char num;
		char[] ans = new char[9];
		int idx = 0;
		Info zero = null;
		for(int i = 0; i < N; ++i) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < N; ++j) {
				num = st.nextToken().charAt(0);
				if(num == '0') zero = new Info(i * N +  j); 
				ans[idx++] = num;
			}
		}
		zero.board = ans;
		
		System.out.println(bfs(N, zero));

	}

	private static int bfs(int N, Info zero) {
		final int[] dx = {-1, 1, 0, 0};
		final int[] dy = { 0, 0, -1, 1};
		final String ans = "123456780";
		
		Queue<Info> q = new LinkedList<>();
		Set<String> visit = new HashSet<>();
		visit.add(String.valueOf(zero.board));
		q.offer(zero);
		
		Info cur;
		String strboard;
		int cnt = 0, qSize, x, y, nx, ny;
		int nPos;
		char[] next;
		while(!q.isEmpty()) {
			qSize = q.size();
			
			while(qSize-- > 0) {
				cur = q.poll();
				
				if(String.valueOf(cur.board).compareTo(ans)==0) return cnt;
				x = cur.pos /N; y = cur.pos % N;
				
				for(int d = 0; d < 4; ++d ) {
					nx = x + dx[d];
					ny = y + dy[d];
					if(nx < 0 || nx >= N || ny < 0 || ny>= N) continue;
					nPos = nx * N + ny;
					
					next = cur.board.clone();
					next[cur.pos] = next[nPos];
					next[nPos] = '0';
					
					strboard = String.valueOf(next);
					if(visit.contains(strboard)) continue;
					visit.add(strboard);
					q.offer(new Info(nPos, next));
					
				}
			}
			
			++cnt;
		}
		
		return -1;
	}

}