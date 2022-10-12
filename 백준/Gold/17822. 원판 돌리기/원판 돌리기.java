import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		
		final int[] dx = {-1, 1, 0, 0};
		final int[] dy = {0, 0, -1, 1};
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int T = Integer.parseInt(st.nextToken());
		
		List<Integer>[] circleBoard= new ArrayList[N+1];
		
		for(int i = 1; i <= N; ++i) {
			st = new StringTokenizer(br.readLine());
			circleBoard[i] = new ArrayList<>(M);
			for(int j = 0; j < M; ++j) {
				circleBoard[i].add(Integer.parseInt(st.nextToken()));
			}
		}
		
		int remain = N * M;
		int x, d, k, num;
		int nx, ny;
		Queue<int[]> q = new LinkedList<>();
		int[] cur;
		int before;
		
		while(T-- > 0) {
			st = new StringTokenizer(br.readLine());
			
			x = Integer.parseInt(st.nextToken());
			d = Integer.parseInt(st.nextToken());
			k = Integer.parseInt(st.nextToken());
			
			// 원판 돌리기
			for(int i = x; i <= N; i += x) {
				if(d == 0) {
					for(int j = 0; j < k; ++j) {
						num = circleBoard[i].remove(M-1);						
						circleBoard[i].add(0, num);
					}
				}
				else {
					for(int j = 0; j < k; ++j) {
						num = circleBoard[i].remove(0);
						circleBoard[i].add(num);

					}
				}
			}
			before = remain;
			// 같은 수 지우기
			for(int i = 1; i <= N; ++i) {
				for(int j = 0; j < M; ++j) {
					num = circleBoard[i].get(j);
					if(num == 0) continue;
					q.clear();
					q.offer(new int[] {i, j});
					
					while(!q.isEmpty()) {
						cur = q.poll();
						
						for(int dir = 0; dir < 4; ++dir) {
							nx = cur[0] + dx[dir];
							ny = cur[1] + dy[dir];
							ny = (ny + M) % M;
							
							if(nx <= 0 || nx > N || circleBoard[nx].get(ny) != num) continue;
							
							--remain;
							circleBoard[nx].set(ny, 0);
							q.offer(new int[] {nx, ny});
							
						}
					}

				}
			}
			
			if(remain == 0) break;
			if(before == remain) {
				something(N, M, circleBoard, remain);
			}
			
		}
		
		if(remain == 0) System.out.println(0);
		else System.out.println(calcNum(N, M, circleBoard));

	}

	private static void something(int N, int M, List<Integer>[] circleBoard, int remain) {
		double avg = (double)calcNum(N, M, circleBoard) / remain;
		
		int num;
		for(int i = 1; i <= N; ++i) {
			for(int j = 0; j < M; ++j) {
				num = circleBoard[i].get(j);
				if(num == 0 || (double)num == avg) continue;
				
				if(num > avg) circleBoard[i].set(j, num - 1);
				else circleBoard[i].set(j, num + 1);
			}
		}
		
	}

	private static int calcNum(int N, int M, List<Integer>[] circleBoard) {
		int sum = 0;
		for(int i = 1; i <= N; ++i) {
			for(int j = 0; j < M; ++j) {
				sum += circleBoard[i].get(j);
			}
		}
		
		return sum;
	}

}