import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
	static int R, C, ans;
	static int nr, nc;
	static char[][] map;
	static int[] building;
	static int[] dr = {-1, 0, 1};
	static boolean isFull;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] input = br.readLine().split(" ");
		R = Integer.parseInt(input[0]);
		C = Integer.parseInt(input[1]);
		
		map = new char[R][C];
		for(int i = 0; i < R; i++)
			map[i] = br.readLine().toCharArray();
		
		building = new int[C];
		for(int i = 0; i < R; i ++) {
			for(int j = 0; j < C; j++) {
				if(map[i][j] == 'x') {
					building[j]++;
				}
			}
		}
		
		if(isConnect()) System.out.println(0);
		else {
			isFull = false;
			for(int i = 0; i < R; i++) {
				dfs(i, 0);
				if(isFull) break;
			}
		}
		System.out.println(ans);
	}
	

	public static boolean isConnect() {
		for(int j = 0, bSize = building.length; j < bSize; j++) {
			if(building[j] == R) return true;
		}
		return false;
	}
	
	public static boolean dfs(int r, int c) {
		
		map[r][c] = 'x';
		if(c == C-1) {
			ans++;
			building[c]++;
			if(building[c] == R) isFull = true;			
			return true;
		}
		
		for(int d = 0, dSize = dr.length; d < dSize; d++) {
			nr = r + dr[d]; nc = c + 1;
			if(nr < 0 || nr >= R || map[nr][nc] == 'x') continue;
			if(dfs(nr, nc)) {
				map[r][c] = 'x';
				building[c]++;
				if(building[c] == R) isFull = true;
				return true;
			}
		}
		return false;
	}

}