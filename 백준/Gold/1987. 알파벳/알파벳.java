import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;

public class Main {
	static int R, C;
	static int max;
	static int[] dx = {0, 1, 0, -1};
	static int[] dy = {1, 0, -1, 0};
	static char[][] map;
	static Set<Character> alpabet;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] input = br.readLine().split(" ");
		R = Integer.parseInt(input[0]);
		C = Integer.parseInt(input[1]);
		
		map = new char[R][C];
		for(int i = 0; i < R; i++)
			map[i] = br.readLine().toCharArray();
		
		max = 0;
		alpabet = new HashSet<>();
		alpabet.add(map[0][0]);
		dfs(0, 0, 1, alpabet);
		System.out.println(max);
	}
	
	public static void dfs(int x, int y, int move, Set<Character> alpabet) {
		
		for(int d = 0, dSize = dx.length; d < dSize; d++) {
			int nx = x + dx[d];
			int ny = y + dy[d];
			if(nx < 0 || nx >= R || ny < 0 || ny >=C || alpabet.contains(map[nx][ny])) continue;
			alpabet.add(map[nx][ny]);
			dfs(nx, ny, move+1, alpabet);
			alpabet.remove(map[nx][ny]);
		}
		max = Math.max(max, move);
	}
}