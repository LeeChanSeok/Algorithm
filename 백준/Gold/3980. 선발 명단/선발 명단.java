import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {
	static final int MAX_NUM = 11;
	static int[][] availity;
	static int res;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		
		int T = Integer.parseInt(br.readLine());
		availity = new int[MAX_NUM][MAX_NUM];
		for(int tc = 1; tc <= T; ++tc) {
			
			for(int i = 0; i < MAX_NUM; ++i) {
				st = new StringTokenizer(br.readLine());
				for(int j = 0; j < MAX_NUM; ++j) {
					availity[i][j] = Integer.parseInt(st.nextToken());
				}				
			}
			
			res = 0;
			recursive(0, 0, 0);
			sb.append(res + "\n");
			
		}
		
		bw.write(sb.toString());
		bw.flush();
		
		bw.close();
		br.close();
	}
	private static void recursive(int idx, int flag, int total) {
		if(idx == MAX_NUM) {
			res = Math.max(res, total);
			return;
		}
		
		for(int i = 0; i < MAX_NUM; ++i) {
			if(availity[idx][i] != 0 && (flag & (1 << i)) == 0) {
				recursive(idx + 1, flag | (1 << i), total + availity[idx][i]);
			}
		}
		
		
	}

}
