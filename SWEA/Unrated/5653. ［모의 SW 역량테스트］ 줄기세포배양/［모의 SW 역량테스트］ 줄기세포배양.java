import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution {
	
	static class Cell implements Comparable<Cell>{
		int x, y, life, time;

		public Cell(int x, int y, int life, int time) {
			super();
			this.x = x;
			this.y = y;
			this.life = life;
			this.time = time;
		}

		@Override
		public int compareTo(Cell o) {
			return o.life - this.life;
		}
		
	}

	static List<Cell> nActiveL, ActiveL;
	static PriorityQueue<Cell> pq;

	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int N, M, K;
		int maxNM = 400;
		boolean[][] map;
		int T = Integer.parseInt(br.readLine());
		
		for(int tc = 1; tc <= T; tc++) {
			st = new StringTokenizer(br.readLine());
				
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			K = Integer.parseInt(st.nextToken());
			
			map = new boolean[400][400];
			ActiveL = new LinkedList<>();
			nActiveL = new LinkedList<>();
			
			int x, y, life;
			for(int i = 0; i < N; ++i) {
				st = new StringTokenizer(br.readLine());
				for(int j = 0; j < M; ++j) {
					life = Integer.parseInt(st.nextToken());
					if(life == 0) continue;
					
					x = i + 165;
					y = j + 165;
					
					nActiveL.add(new Cell(x, y, life, 0));
					map[x][y] = true;
					
				}
			}
			
			System.out.printf("#%d %d\n",tc, solution(ActiveL, nActiveL, map, N, M, K));
			
		}// tc 종료
		
	}

	private static int solution(List<Cell> ActiveL, List<Cell> nActiveL, boolean[][] map, int N, int M, int K) {

		final int[] dx = {-1, 0, 1, 0};
		final int[] dy = {0, 1, 0, -1};
		
		Cell cell;
		pq = new PriorityQueue<>();
		ListIterator<Cell> iter;
		int nx, ny;
		
		while(K-- > 0) {
			
			// 1. 비활성 상태의 세포들의 시간을 증가시킨다
			// x시간이 지난 후, 번식을 위해 pq 담고 active queue에 담는다.
			iter = nActiveL.listIterator();
			while(iter.hasNext()) {
				cell = iter.next();
				if(cell.life == cell.time) {
					pq.add(cell);
					ActiveL.add(new Cell(cell.x, cell.y, cell.life, 1));
					iter.remove();
				}else {
					++cell.time;
				}
			}
			
			// 2. 활성 상태의 세포들의 시간을 증가시킨다
			// x시간이 지난 후, 삭제시킨다
			iter = ActiveL.listIterator();
			while(iter.hasNext()) {
				cell = iter.next();
				if(cell.life == cell.time) {
					iter.remove();
				}else {
					++cell.time;
				}
			}
			
			// 3. 번식할 cell들을 번식 후, nActiveL에 담는다.
			while(!pq.isEmpty()) {
				cell = pq.poll();
				
				for(int d = 0; d <4; ++d) {
					nx = cell.x + dx[d];
					ny = cell.y + dy[d];
					
					if(!map[nx][ny]) {
						map[nx][ny] = true;
						nActiveL.add(new Cell(nx, ny, cell.life, 0));
					}
					
				}
				
			}
			
		}
		
		return ActiveL.size() + nActiveL.size();
	}


}
