import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {
	
	static int N;
	static int mp, mf, ms, mv;
	static int[][] gradient;
	static int pick;
	static int minPrice;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		
		N = Integer.parseInt(br.readLine());
		
		st = new StringTokenizer(br.readLine());
		mp = Integer.parseInt(st.nextToken());
		mf = Integer.parseInt(st.nextToken());
		ms = Integer.parseInt(st.nextToken());
		mv = Integer.parseInt(st.nextToken());
		
		gradient = new int[N+1][5];
		for(int i = 1; i <= N; ++i) {
			st = new StringTokenizer(br.readLine());

			gradient[i][0] = Integer.parseInt(st.nextToken());
			gradient[i][1] = Integer.parseInt(st.nextToken());
			gradient[i][2] = Integer.parseInt(st.nextToken());
			gradient[i][3] = Integer.parseInt(st.nextToken());
			gradient[i][4] = Integer.parseInt(st.nextToken());
		}
		minPrice = Integer.MAX_VALUE;
		subSet(1, 0, 0, 0, 0, 0, 0);
		
		if(minPrice == Integer.MAX_VALUE) sb.append("-1");
		else {
			sb.append(minPrice + "\n");
			for(int i = 1; i <= N; ++i) {
				if((pick & (1 << i)) != 0) sb.append(i + " ");
			}
		}
		
		bw.write(sb.toString());
		bw.flush();
		
		bw.close();
		br.close();
	}

	private static void subSet(int idx, int flag, int p, int f, int s, int v, int c) {
		
		if(c >= minPrice) return;
		
		if(p >= mp && f >= mf && s >= ms && v >= mv) {
			minPrice = c;
			pick = flag;
			return;
		}
		
		if(idx == N+1) return;
		
		subSet(idx + 1, flag | (1 << idx)
				, p + gradient[idx][0]
				, f + gradient[idx][1]
				, s + gradient[idx][2]
				, v + gradient[idx][3]
				, c + gradient[idx][4]);
		
		subSet(idx + 1, flag, p, f, s, v, c);
		
	}

}
