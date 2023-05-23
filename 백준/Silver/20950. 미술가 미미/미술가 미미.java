import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static final int MAX_PICK = 7;
	static int[][] rgb;
	static int N;
	static int rg, gg, bg;
	static int min;
	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		N = Integer.parseInt(br.readLine());
		rgb = new int[N][3];
		
		for(int i = 0; i < N; ++i) {
			st = new StringTokenizer(br.readLine());
			
			rgb[i][0] = Integer.parseInt(st.nextToken());
			rgb[i][1] = Integer.parseInt(st.nextToken());
			rgb[i][2] = Integer.parseInt(st.nextToken());
		}
		
		st = new StringTokenizer(br.readLine());
		rg = Integer.parseInt(st.nextToken());
		gg = Integer.parseInt(st.nextToken());
		bg = Integer.parseInt(st.nextToken());
		
		min = Integer.MAX_VALUE;
		recursive(0, 0, 0, 0, 0, false);
		
		System.out.println(min);
		
	}
	private static void recursive(int idx, int r, int g, int b, int pick, boolean isPick) {

		int rs, gs, bs;
		if(isPick && pick >= 2) {
			rs = r / pick;
			gs = g / pick;
			bs = b / pick;
			
			int diff = Math.abs(rg - rs) + Math.abs(gg - gs) + Math.abs(bg - bs);
			if(diff < min) min = diff;
		}
		
		if(pick == MAX_PICK || idx == N) return;
		
		recursive(idx + 1, r + rgb[idx][0], g + rgb[idx][1], b + rgb[idx][2], pick+1, true);
		recursive(idx + 1, r, g, b, pick, false);
		
	}

}