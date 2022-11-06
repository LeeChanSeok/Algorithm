import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	static class Virus{
		int num, x, y;

		public Virus(int num, int x, int y) {
			super();
			this.num = num;
			this.x = x;
			this.y = y;
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int[] dx = {-1, 1, 0, 0};
		int[] dy = {0, 0, -1, 1};
		
		int N, K;
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		
		int[][] board = new int[N][N];
		for(int i = 0; i < N; ++i) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < N; ++j) {
				board[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		int S, X, Y;
		st = new StringTokenizer(br.readLine());
		S = Integer.parseInt(st.nextToken());
		X = Integer.parseInt(st.nextToken())-1;
		Y = Integer.parseInt(st.nextToken())-1;

		List<Virus> list = new LinkedList<>();
		int num;
		for(int i = 0; i < N; ++i) {
			for(int j = 0; j < N; ++j) {
				num = board[i][j];
				if(num!=0) list.add(new Virus(num, i, j));
			}
		}
		
		Collections.sort(list, (v1, v2) -> v1.num - v2.num);
		Queue<Virus> q = new LinkedList<>(list);
		
		int qSize, nx, ny, x, y;
		Virus cur;
		while(S-- > 0 & !q.isEmpty()) {

			qSize = q.size();
			while(qSize-- > 0) {
				cur = q.poll();
				x = cur.x; y = cur.y; num = cur.num;
				for(int d = 0; d < 4; ++d) {
					nx = x + dx[d];
					ny = y + dy[d];
					
					if(nx < 0 || nx >= N || ny < 0 || ny >= N || board[nx][ny] != 0) continue;
					q.add(new Virus(num, nx, ny));
					board[nx][ny] = num;
				}
			}
			
		}
		
		System.out.println(board[X][Y]);

	}

}