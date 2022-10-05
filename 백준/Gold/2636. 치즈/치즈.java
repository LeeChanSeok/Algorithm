import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	static class Point{
		int x, y;

		public Point(int x, int y) {
			super();
			this.x = x;
			this.y = y;
		}
	
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		int[] dx = {0, 1, 0, -1};
		int[] dy = {1, 0, -1, 0};
		
		char[][] board = new char[N][M];
		char c;
		int cheeseCnt = 0;
		for(int i = 0; i < N; ++i) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < M; ++j) {
				c = st.nextToken().charAt(0);
				board[i][j] = c;
				if(c == '1') ++cheeseCnt;
			}
		}
		
		// 외부 공기 처리
		Queue<Point> air = new LinkedList<>();
		air.offer(new Point(0, 0));
		board[0][0] = '2';
		
		//치즈 구멍의 좌표 정보
		Queue<Point> hole = new LinkedList<>();
		
		Point cur;
		int nx, ny;
		
		// 치즈 처리
		int time = 0;

		do {
			// 남아있는 치즈의 수와 구멍이 있는 치즈의 수가 같을 경우 종료
			if(cheeseCnt - hole.size() == 0) break;
			cheeseCnt -= hole.size();
			hole.clear();
			
			++time;
			// 외부 공기 처리
			while(!air.isEmpty()) {
				cur = air.poll();
				 
				for(int d = 0; d < 4; ++d) {
					nx = cur.x + dx[d];
					ny = cur.y + dy[d];
					
					if(nx < 0 || nx >= N || ny < 0 || ny >= M || board[nx][ny] == '2') continue;
					
					// 치즈가 있으면 hole에 저장, 그렇지 않으면 air에 저장하여 계속해서 bfs 탐색
					if(board[nx][ny] == '1') hole.offer(new Point(nx, ny));
					else air.offer(new Point(nx, ny));
					
					board[nx][ny] = '2';
				}
				
			}
			
			// 구멍이 있는 치즈를 중심으로 다시 외부 공기 처리
			air = new LinkedList<>(hole);
			
		}while(true);
		
		System.out.println(time);
		System.out.println(cheeseCnt);
		
	}

}