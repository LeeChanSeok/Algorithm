import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {
	
	static final int MAX_PLAYER = 6;
	static int[][] result = new int[MAX_PLAYER][3];
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;

		int T = 4;
		boolean answer;
		for(int tc = 1; tc <= T; ++tc) {
			st = new StringTokenizer(br.readLine());
			for(int i = 0; i < MAX_PLAYER; ++i) {
				for(int j = 0; j < 3; ++j) {
					result[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			if(isCheck()) 
				answer = recursive(0, 1);
			else
				answer = false;
			
			sb.append((answer)? "1 " : "0 ");
		}
		
		bw.write(sb.toString());
		bw.flush();
		
		bw.close();
		br.close();
		
	}

	private static boolean isCheck() {
		int sum;
		for(int i = 0; i < MAX_PLAYER; ++i) {
			sum = 0;
			for(int j = 0; j < 3; ++j) {
				sum += result[i][j];
			}
			if(sum != 5) return false;
		}
		return true;
	}

	private static boolean recursive(int p1, int p2) {

		if(p2 == MAX_PLAYER) {
			++p1;
			p2 = p1 + 1;
		}
		
		if(p1 == MAX_PLAYER - 1) {
			
			for(int i = 0; i < MAX_PLAYER; ++i) {
				for(int j = 0; j < 3; ++j) {
					if(result[i][j] != 0) return false;
				}
			}
			
			return true;
		}
		
		for(int i = p2; i < MAX_PLAYER; ++i) {
			
			// 1. p1 win
			if(result[p1][0] > 0 && result[p2][2] > 0) {
				--result[p1][0];
				--result[p2][2];
				if(recursive(p1, p2+1)) return true;
				++result[p1][0];
				++result[p2][2];
			}
				
			// 2. p1 draw
			if(result[p1][1] > 0 && result[p2][1] > 0) {
				--result[p1][1];
				--result[p2][1];
				if(recursive(p1, p2+1)) return true;
				++result[p1][1];
				++result[p2][1];
			}
			
			// 3. p1 lose
			if(result[p1][2] > 0 && result[p2][0] > 0) {
				--result[p1][2];
				--result[p2][0];
				if(recursive(p1, p2+1)) return true;
				++result[p1][2];
				++result[p2][0];
			}
		}
		
		return false;
		
	}

}
