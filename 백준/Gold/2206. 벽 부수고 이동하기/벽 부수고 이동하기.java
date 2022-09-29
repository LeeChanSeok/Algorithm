import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	static class Info{
		int x, y;
		char s;
		
		public Info(int x, int y, char s) {
			super();
			this.x = x;
			this.y = y;
			this.s = s;
		}
		
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		char[][] map = new char[N][M];
		
		for(int i = 0; i < N; i++) {
			map[i] = br.readLine().toCharArray();
		}
		
		int length = solution(map, N, M);
		
		System.out.println(length);

	}

	private static int solution(char[][] map, int N, int M) {
		
		final int [] dx = {0, 1, 0, -1};
		final int [] dy = {1, 0, -1, 0};
		
		int length = 0;
		int x, y;
		char s;
		int nx, ny;
		Info cur;
		
		char[][] visit = new char[N][M];
		for(int i = 0; i < N; i++)
			visit[i] = map[i].clone();
		
		Queue<Info> q = new LinkedList<>();
		q.add(new Info(0, 0, '3'));
		visit[0][0] = '3';
		
		while(!q.isEmpty()) {
			int qSize = q.size();
			++length;
			
			while(qSize-- >0) {
				cur = q.poll();
				x = cur.x; y = cur.y; s = cur.s;
				if(x == N-1 && y == M-1) {
					return length;
				}
				
				if(cur.s < visit[x][y]) continue;
				
				for(int d = 0; d < 4; d++) {
					nx = x + dx[d];
					ny = y + dy[d];
					if(nx < 0 || nx >= N || ny < 0 || ny >= M) continue;
					
					if(map[nx][ny] == '1' && visit[nx][ny] != '0') {
						if(s == '3') {
							q.add(new Info(nx, ny, '2'));
							visit[nx][ny] = '2';
						}
					}
					else if(map[nx][ny] == '0'){
						if(visit[nx][ny] < s)
						{
							q.add(new Info(nx, ny, s));
							visit[nx][ny] = s;							
						}
					}
				}
				
			}// while 종료
			
		}// q is empty
		
		return -1;
	}

}