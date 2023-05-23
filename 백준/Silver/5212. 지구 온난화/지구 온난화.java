import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
	static int[] dx = {-1, 1, 0, 0};
	static int[] dy = {0, 0, -1, 1};
	static int N, M;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
	
		int minX, maxX, minY, maxY;
		minX = minY = 10;
		maxX = maxY = -1;
		
		List<int[]> list = new LinkedList<>();
	
		char[][] board = new char[N][M];
		for(int i = 0; i < N; ++i) {
			board[i] = br.readLine().toCharArray();
		}
		
		int nx, ny;
		for(int i = 0; i < N; ++i) {
			for(int j = 0; j < M; ++j) {
				if(board[i][j] == 'X') {
					int cnt = 0;
					for(int d = 0; d < 4; ++d) {
						nx = i + dx[d];
						ny = j + dy[d];
						if(nx < 0 || nx >= N || ny < 0 || ny>=M || board[nx][ny] == '.') ++cnt;
					}
					
					if(cnt < 3) {
						minX = Math.min(minX, i);
						minY = Math.min(minY, j);
						maxX = Math.max(maxX, i);
						maxY = Math.max(maxY, j);
						list.add(new int[] {i, j});
					}
				}
			}
		}
		
		int n = maxX - minX+1;
		int m = maxY - minY+1;
		char[][] new_board = new char[n][m];
		for(int i = 0; i < n; ++i) Arrays.fill(new_board[i], '.');
		for(int[] pos : list) {
			nx = pos[0] - minX;
			ny = pos[1] - minY;
			new_board[nx][ny] = 'X';
		}
		
		for(int i = 0; i < n; ++i) {
			sb.append(new String(new_board[i])).append("\n");
		}
		
		bw.write(sb.toString());
		bw.flush();
		
		bw.close();
		br.close();
	}

}
