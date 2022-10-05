import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	static class Person implements Comparable<Person>{
		int x, y, keySet, time;

		public Person(int x, int y, int keySet, int time) {
			super();
			this.x = x;
			this.y = y;
			this.keySet = keySet;
			this.time = time;
		}

		@Override
		public int compareTo(Person o) {
			return this.time - o.time;
		}
        
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		char[][] maze = new char[N][M];
		String str;
		char c;
		
		PriorityQueue<Person> q = new PriorityQueue<>();
		for(int i = 0; i < N; ++i) {
			str = br.readLine();
			for(int j = 0; j < M; ++j) {
				c = str.charAt(j);
				maze[i][j] = c;
				if(c == '0') {
					maze[i][j] = '.';
					q.offer(new Person(i, j, 0, 0));
				}
			}
		}
		
		System.out.println(solution(q, maze, N, M));
		
	}

	private static int solution(Queue<Person> q, char[][] maze, int N, int M) {
		int[] dx = {-1, 1, 0, 0};
		int[] dy = {-0, 0, -1, 1};
		int maxKey = (int)Math.pow(2, 6);
		boolean[][][] keyMap = new boolean[N][M][maxKey]; // 0 : 이동 횟수, 1 : keySet
				
		keyMap[q.peek().x][q.peek().y][0] = true;
				
		Person cur;
		int nx, ny, keyset;
		while(!q.isEmpty()) {
			cur = q.poll();
			if(maze[cur.x][cur.y] == '1') return cur.time;
			
			for(int d = 0; d < 4; ++d) {
				nx = cur.x + dx[d];
				ny = cur.y + dy[d];
				keyset = cur.keySet;
				
				// 경계 밖, 벽
				if(nx < 0 || nx >= N || ny < 0 || ny >=M || maze[nx][ny] == '#') continue;
				
				// 이동하려는 위치를 이미 방문하였다면
				if(keyMap[nx][ny][keyset]) continue;

				// 이동하려는 곳에 문이 있고 열쇠가 없는 경우
				if((maze[nx][ny] >= 'A' && maze[nx][ny] <= 'F') 
						&& (keyset & 1 << (maze[nx][ny] - 'A')) == 0) continue;
				
				// 이동하려는 곳에 열쇠가 있는 경우
				if(maze[nx][ny] >= 'a' && maze[nx][ny] <= 'f')
					keyset |= 1<<(maze[nx][ny] - 'a');
				
				keyMap[nx][ny][keyset] = true;
				q.offer(new Person(nx, ny, keyset, cur.time+1));
				
			}
			
		}
		
		return -1;
	}

}