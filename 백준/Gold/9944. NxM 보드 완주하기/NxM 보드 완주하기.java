import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {
	
	static final int[] dx = {-1, 1, 0, 0};
	static final int[] dy = {0, 0, -1, 1};
	static final int DELTA = 100;
	
	static int N, M;
	static char[][] board;
	static int move;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		
		int tc = 1;
		String str;
		while((str = br.readLine()) != null && !str.isEmpty() && !str.equals("")) {
			st = new StringTokenizer(str);
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			
			board = new char[N][M];
			for(int i = 0; i < N; ++i) {
				board[i] = br.readLine().toCharArray();
			}
			
			sb.append("Case " + tc + ": " + solution(N, M) + "\n");
			++tc;
		}
		
		bw.write(sb.toString());
		bw.flush();
		
		bw.close();
		br.close();
	}

	private static int solution(int N, int M) {
		int answer = 1000000;
		
		for(int i = 0; i < N; ++i) {
			for(int j = 0; j < M; ++j) {
				if(board[i][j] == '.') {
					move = 10000000;
					board[i][j] = '*';
					recursive(i, j, 0);
					board[i][j] = '.';
					answer = Math.min(answer, move);
				}
			}
		}
		
		
		if (answer == 1000000) return -1;
		else return answer;
	}

	private static void recursive(int x, int y, int mv) {
		
		boolean isMove = false;
		
		int nx, ny;
		int[] result = new int[2];
		for(int d = 0; d < 4; ++d) {
			nx = x + dx[d];
			ny = y + dy[d];
			
			if(nx < 0 || nx >= N || ny < 0 || ny >=M || board[nx][ny] == '*') continue;
			
			isMove = true;
						

			result = move_dir(nx, ny, d);
			recursive(result[0] - dx[d], result[1] - dy[d], mv + 1);

			move_back(nx, ny, result, d);
		}
		
		if(!isMove || mv == 0) {
			if(isVisitAll()) {
				move = Math.min(move, mv);
			}
		}
		
	}

	private static void move_back(int x, int y, int[] result, int d) {

		while(x != result[0] || y != result[1]) {
			
			board[x][y] = '.';
			x += dx[d];
			y += dy[d];
		}
	}

	private static int[] move_dir(int x, int y, int d) {
		
		while(true) {
			if(x < 0 || x >= N || y < 0 || y >=M || board[x][y] == '*') {
				return new int[] {x, y};
			}
			
			board[x][y] = '*';
			x += dx[d];
			y += dy[d];
		}
		
	}

	private static boolean isVisitAll() {
		
		for(int i = 0; i < N; ++i) {
			for(int j = 0; j < M; ++j) {
				if(board[i][j] != '*') return false;
			}
				
		}
		
		return true;
	}

}
