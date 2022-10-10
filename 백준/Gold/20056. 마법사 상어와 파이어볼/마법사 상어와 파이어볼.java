import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
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

		@Override
		public int hashCode() {
			final int prime = 251;
			int result = 1;
			result = prime * result + x;
			result = prime * result + y;
			return result;
		}

		@Override
		public boolean equals(Object obj) {
			Point other = (Point) obj;
			if (x != other.x)
				return false;
			if (y != other.y)
				return false;
			return true;
		}

		@Override
		public String toString() {
			return "Point [x=" + x + ", y=" + y + "]";
		}
		
		
	}
	
	static class FireBall{
		int x, y, m, s, d;

		public FireBall(int x, int y, int m, int s, int d) {
			super();
			this.x = x;
			this.y = y;
			this.m = m;
			this.s = s;
			this.d = d;
		}

		public FireBall(FireBall fireBall) {
			this.x = fireBall.x;
			this.y = fireBall.y;
			this.m = fireBall.m;
			this.s = fireBall.s;
			this.d = fireBall.d;
		}

	}
			
	static int N, M, K;
	static final int[] dx = {-1, -1, 0, 1, 1, 1, 0, -1};
	static final int[] dy = {0, 1, 1, 1, 0, -1, -1, -1};
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
				
		int x, y, m, s, d;
		Queue<FireBall> q = new LinkedList<>();
		for(int i = 0 ; i < M; ++i) {
			st = new StringTokenizer(br.readLine());
			
			x = Integer.parseInt(st.nextToken())-1;
			y = Integer.parseInt(st.nextToken())-1;
			m = Integer.parseInt(st.nextToken());
			s = Integer.parseInt(st.nextToken());
			d = Integer.parseInt(st.nextToken());
			
			q.offer(new FireBall(x, y, m, s, d));
		}
		
		System.out.println(simulation(q));
		
	}

	private static int simulation(Queue<FireBall> q) {
		
		Map<Point, List<FireBall>> moveMap = new HashMap<>();
		FireBall cur;
		Point point;
		List<FireBall> list;
		while(K-- > 0) {
			moveMap.clear();
			// 1. 파이어볼 이동
			while(!q.isEmpty()) {
				cur = q.poll();
				
				cur.x = (cur.x + N + (dx[cur.d] * cur.s)%N) % N;
				cur.y = (cur.y + N + (dy[cur.d] * cur.s)%N) % N;
				point = new Point(cur.x, cur.y);
				
				list = moveMap.getOrDefault(point, new LinkedList<>());
				list.add(cur);
				
				moveMap.put(point, list);
				 
			}
			
			// 2. merge and divide
			int x, y, m, s, d;
			for(Entry<Point, List<FireBall>> entry : moveMap.entrySet()) {
				
				list = entry.getValue();
				if(list.size() == 1) {
					q.offer(new FireBall(list.get(0)));
					continue;
				}

				m = s = d = 0;
				
				for(FireBall fireball : list) {
					m += fireball.m;
					s += fireball.s;
					d |= 1 << (fireball.d & 1);
				}
				
				m /= 5;
				if(m == 0) continue;
				
				s /= list.size();
				
				if(d == 3) d = 1;
				else d = 0;
				
				x = entry.getKey().x;
				y = entry.getKey().y;
				
				for(int i = 0; i < 8; i += 2)
					q.offer(new FireBall(x, y, m, s, d + i));
			}
			
		}
		
		return sumM(q);
	}

	private static int sumM(Queue<FireBall> q) {
		int total = 0;
		while(!q.isEmpty())
			total += q.poll().m;
		return total;
	}

}