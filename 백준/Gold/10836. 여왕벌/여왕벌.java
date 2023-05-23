import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {

	static BufferedReader br;
	static StringTokenizer st;
	static int N, M;
	static int[][] board, grow;
	
	public static void main(String[] args) throws IOException {
		
		br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		st = new StringTokenizer(br.readLine());
		
		M = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());
		
		board = new int[M][M];
		for(int i = 0; i < M; ++i) {
			for(int j = 0; j < M; ++j) {
				board[i][j] = 1;
			}
		}
		
		grow = new int[M][M];
		for(int i = 0; i < N; ++i) {
			self_grow();
			grow();
			add();
		}
		
		for(int i = 0; i < M; ++i) {
			for(int j = 0; j < M; ++j) {
				sb.append(board[i][j] + " ");
			}
			sb.append("\n");
		}
		
		bw.write(sb.toString());
		bw.flush();
		
		bw.close();
		br.close();
		
	}
	
	private static void add() {

		for(int i = 0 ; i < M; ++i) {
			for(int j = 0; j < M; ++j) {
				board[i][j] += grow[i][j];
			}
		}
		
	}
	
	private static void grow() {
		
		int max;
		for(int i = 1; i < M; ++i) {
			max = 0;
			for(int j = 1; j < M; ++j) {
				max = Math.max(grow[i][j-1], grow[i-1][j-1]);
				max = Math.max(max, grow[i-1][j]);
				
				grow[i][j] = max;
			}
		}
		
	}
	
	private static void self_grow() throws IOException {
		
		int[] count = new int[3];
		
		st = new StringTokenizer(br.readLine());
		for(int j = 0; j < 3; ++j) {
			count[j] = Integer.parseInt(st.nextToken());
		}
		
		int idx = 0;
		// 1. 아래서 위
		int j = M-1;
		while(j >= 0) {
			if(count[idx] == 0) {
				++idx;
				continue;
			}
			
			grow[j][0] = idx;
			--j;
			--count[idx];
			
		}
		
		j += 2; 
		// 2. 왼쪽에서 오른쪽
		while(j < M) {
			if(count[idx] == 0) {
				++idx;
				continue;
			}
			
			grow[0][j] = idx;
			++j;
			--count[idx];
		}
		
	}

}