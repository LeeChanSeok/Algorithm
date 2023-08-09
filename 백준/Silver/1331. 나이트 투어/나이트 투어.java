import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	
	static int[] dx = {-2, -2, -1, 1, 2, 2, 1, -1};
	static int[] dy = {-1, 1, 2, 2, 1, -1, -2, -2};
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int[][] pos = new int[37][2];
		for(int i = 0; i < 36; ++i) {
			char[] p = br.readLine().toCharArray();
			
			int y = p[0] - 'A'; 
			int x = 6 - (p[1] - '0');
			
			pos[i][0] = x;
			pos[i][1] = y;
		}

		pos[36][0] = pos[0][0];
		pos[36][1] = pos[0][1];
		
		boolean[][] visited = new boolean[6][6];
		
		boolean isValid = true;
		int x = pos[0][0]; int y = pos[0][1];
		for(int i = 1; i <= 36; ++i) {
			
			int nx = pos[i][0];	
			int ny = pos[i][1]; 
			
			if(visited[nx][ny]) {
				isValid = false;
				break;
			}
			if(!isMove(x, y, nx, ny)) {
				isValid = false;
				break;
			}
			
			visited[nx][ny] = true;
			x = nx; y = ny;
		}
		
		if(isValid) System.out.println("Valid");
		else System.out.println("Invalid");

	}

	private static boolean isMove(int x1, int y1, int x2, int y2) {

		for(int d = 0; d < 8; ++d) {
			int nx = x1 + dx[d];
			int ny = y1 + dy[d];
			
			if(nx == x2 && ny == y2) return true;
			
		}
		
		return false;
	}

}