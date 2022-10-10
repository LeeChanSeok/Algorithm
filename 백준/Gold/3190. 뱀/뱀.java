import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.Map;
import java.util.Set;
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
			final int prime = 1013;
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
	}
	static class Command{
		int t; 
		char c;
		
		public Command(int t, char c) {
			super();
			this.t = t;
			this.c = c;
		}
	}
	
	static int[] dx = {0, 1, 0, -1};
	static int[] dy = {1, 0, -1, 0};
	static int N, K, L;
	static Set<Point> apple;
	static Command[] commands;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		N = Integer.parseInt(br.readLine());
		K = Integer.parseInt(br.readLine());
	
		int x, y;
		apple = new HashSet<>();
		for(int i = 0; i < K; ++i) {
			st = new StringTokenizer(br.readLine());
			x = Integer.parseInt(st.nextToken())-1;
			y = Integer.parseInt(st.nextToken())-1;
			
			apple.add(new Point(x, y));
		}
		
		L = Integer.parseInt(br.readLine());
		
		commands = new Command[L+1];
		
		int t; char c;
		for(int i = 0; i < L; ++i) {
			st = new StringTokenizer(br.readLine());
			t = Integer.parseInt(st.nextToken());
			c = st.nextToken().charAt(0);
			
			commands[i] = new Command(t, c);
		}
		commands[L] = new Command(N*N, '\0');
		
		int answer = simulation();
		System.out.println(answer);
	}


	private static int simulation() {
		
		Point point = new Point(0, 0);
		Set<Point> position = new HashSet<>();
		position.add(point);
		
		LinkedList<Point> snake = new LinkedList<>();
		snake.add(point);
		
		int time = 0; int dir = 0;
		int t; char c;
		Point head, next, tail;
		int nx, ny;
		for(int i = 0, cSize = L + 1; i < cSize; ++i) {
			t = commands[i].t;
			c = commands[i].c;
			
			while(time < t) {
				head = snake.get(0);
				
				nx = head.x + dx[dir];
				ny = head.y + dy[dir];
				
				next = new Point(nx, ny);
				
				if(nx < 0 || nx >= N || ny < 0 || ny >= N || position.contains(next)) return ++time;
				
				position.add(next);
				snake.addFirst(next);
				if(apple.contains(next)) {
					apple.remove(next);
				}else {
					tail = snake.removeLast();
					position.remove(tail);
				}
				
				++time;
			}
			
			if(c == 'L') dir = (dir + 3) % 4;
			else if(c == 'D') dir = (dir + 1) % 4;
			
		}
		
		return -1;
	}
}