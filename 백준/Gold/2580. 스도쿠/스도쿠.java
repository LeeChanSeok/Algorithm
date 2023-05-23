import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
	static final int full = (1 << 10) - 1;
	static final int N = 9;
	static int[][] board;
	static List<int[]> blanks;
	static int blank_cnt;
	static int[] row, col;
	static int[][] square;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuffer sb = new StringBuffer();
		StringTokenizer st;
	
		row = new int[N];
		col = new int[N];
		square = new int[N/3][N/3];
		
		board = new int[N][N];
		
		blanks = new ArrayList<>();
		int num, bit;
		for(int i = 0; i < N; ++i) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < N; ++j) {
				num = Integer.parseInt(st.nextToken());
				bit = (1 << num);
				board[i][j] = num;
				if(num == 0) blanks.add(new int[] {i, j});
				else {
					row[i] |= bit;
					col[j] |= bit;
					square[i/3][j/3] |= bit;
				}
			}
		}
		blank_cnt = blanks.size();
		
		dfs(0);
		
		for(int i = 0; i < N; ++i) {
			for(int j = 0; j < N; ++j) {
				sb.append(board[i][j] + " ");
			}
			sb.append("\n");
		}
		
		bw.write(sb.toString());
		bw.flush();
		bw.close();
		br.close();
	}
	
	private static boolean dfs(int idx) {
		if(idx == blank_cnt) return true;
		
		int[] pos = blanks.get(idx);
		int x = pos[0];
		int y = pos[1];
		int bit;
		for(int i = 1; i <= 9; ++i) {
			bit = (1 << i);
			if( ((row[x] & bit) == 0) 
					&& ((col[y] & bit) == 0)
					&& ((square[x/3][y/3] & bit) == 0)
					) {
				
				row[x] |= bit;
				col[y] |= bit;
				square[x/3][y/3] |= bit;
				board[x][y] = i;
				
				if(dfs(idx+1)) return true;
				
				row[x] &= (bit ^ full);
				col[y] &= (bit ^ full);
				square[x/3][y/3] &= (bit ^ full);
				board[x][y] = 0;
			}
		}
		
		return false;
	}

}
