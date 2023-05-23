import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

	static int N, M;
	static char[][] board;
	static List<int[]> meteao_bottom;
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		board = new char[N][M];
		for(int i = 0; i < N; ++i) board[i] = br.readLine().toCharArray();
		
		// 1. 유성우 밑 부분 좌표 구하기
		List<int[]> meteao = new LinkedList<>();
		for(int i = 0; i < N; ++i) {
			for(int j = 0; j < M; ++j) {
				if(board[i][j] == 'X') {
					meteao.add(new int[] {i, j});
				}
			}
		}
		
		// 2. 유성우 밑 부분 좌표 구하기
		meteao_bottom = new LinkedList<>();
		for(int j = 0; j < M; ++j) {
			for(int i = N-1; i >= 0; --i) {
				if(board[i][j] == 'X') {
					meteao_bottom.add(new int[] {i, j});
					break;
				}
			}
		}
		
		// 3. 바텀과 땅 사이의 거리 구하기
		int dist = 2;
		while(true) {
			
			if(isDuplicate(dist)) {
				--dist;
				break;
			}
			++dist;
			
		}
		
		// 4. 새로운 맵 구하기 
		char[][] new_board = new char[N][M];
		for(int i = 0; i < N; ++i) {
			for(int j = 0; j < M; ++j) {
				if(board[i][j] == '#') new_board[i][j] = '#';
				else new_board[i][j] = '.';
			}
		}
		
		for(int[] pos : meteao) {
			new_board[pos[0]+dist][pos[1]] = 'X';
		}
			
		// 5. 출력
		for(int i = 0; i < N; ++i) {
			for(int j = 0; j < M; ++j) sb.append(new_board[i][j]);
			sb.append("\n");
		}
		
		bw.write(sb.toString());
		bw.flush();
		
		bw.close();
		br.close();
		
	}

	private static boolean isDuplicate(int dist) {
		
		for(int[] pos : meteao_bottom) {
			int nx = pos[0] + dist;
			int ny = pos[1];
			if(nx >= N || board[nx][ny] == '#') return true;
		}
		
		return false;
	}

}
