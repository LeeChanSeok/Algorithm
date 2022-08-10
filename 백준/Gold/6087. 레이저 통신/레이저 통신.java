import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

class Info{
	int x, y;
	int dir;
	int turn;
	
	public Info(int x, int y, int dir, int turn) {
		super();
		this.x = x;
		this.y = y;
		this.dir = dir;
		this.turn = turn;
	}
	public Info(Info info) {
		super();
		this.x = info.x;
		this.y = info.y;
		this.dir = info.dir;
		this.turn = info.turn;
	}
	
}

public class Main {

	public static int min, W, H;
	public static int[] dx = { -1, 0, 1, 0 };
	public static int[] dy = { 0, 1, 0, -1 };


	public static void bfs(char[][] map, int[][] cntMap, Info[] info) {
		int N = map.length;
		int M = map[0].length;
		
		Queue<Info> q = new LinkedList<>();
		q.add(new Info(info[0]));
		cntMap[info[0].x][info[0].y]= 0; 
		int nx, ny;
		while(!q.isEmpty()) {
			Info cur = q.poll();
			if(cur.turn > min) continue;
			
			if(cur.x == info[1].x && cur.y == info[1].y ) {
				min = Math.min(min, cntMap[cur.x][cur.y]);
				continue;
			}
			for(int d = 0; d < dx.length; d++) {
				nx = cur.x + dx[d];
				ny = cur.y + dy[d];
				
				if(nx < 0 || nx >= N || ny < 0 || ny >= M || map[nx][ny] =='*' ) continue;
				
				if(cur.dir != -1 && cur.dir == d &&cur.turn > cntMap[nx][ny]) continue;
				if(cur.dir != -1 && cur.dir != d &&cur.turn+1 > cntMap[nx][ny]) continue;
				
				Info new_info;
				if(cur.dir == -1) {
					new_info = new Info(nx, ny, d, 0);
				}else {
					if(cur.dir == d)
						new_info = new Info(nx, ny, d, cur.turn);
					else
						new_info = new Info(nx, ny, d, cur.turn+1);
				}
				cntMap[nx][ny] = new_info.turn;
				q.add(new_info);
			}
			
		}

	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		W = Integer.parseInt(st.nextToken());
		H = Integer.parseInt(st.nextToken());
		String str;
		char[][] map = new char[H][W];
		int[][] cntMap = new int[H][W];
		Info[] info = new Info[2];
		int icnt = 0;
		for (int i = 0; i < H; i++) {
			str = br.readLine();
			for (int j = 0; j < W; j++) {
				map[i][j] = str.charAt(j);
				cntMap[i][j] = Integer.MAX_VALUE;
				if (map[i][j] == 'C')
					info[icnt++] = new Info(i, j, -1, 0);
			}
		}
		min = Integer.MAX_VALUE;
		bfs(map, cntMap, info);
		System.out.println(min);
	}

}