import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
	static int N, cx, cy, hx, hy;
	static int min;
	static int[][] point;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int T = Integer.parseInt(br.readLine());

		for (int tc = 1; tc <= T; tc++) {
			N = Integer.parseInt(br.readLine());
			point = new int[N][2];

			st = new StringTokenizer(br.readLine());
			cx = Integer.parseInt(st.nextToken());
			cy = Integer.parseInt(st.nextToken());

			hx = Integer.parseInt(st.nextToken());
			hy = Integer.parseInt(st.nextToken());

			for (int i = 0; i < N; i++) {
				point[i][0] = Integer.parseInt(st.nextToken());
				point[i][1] = Integer.parseInt(st.nextToken());
			}
			min = Integer.MAX_VALUE;
			permutation(cx, cy, 0, 0, 0);
			
			System.out.printf("#%d %d\n",tc, min);
		} // test-case 종료

	}

	private static void permutation(int cx, int cy, int cnt, int flag, int sum) {
		if (sum >= min) return;
		if(cnt == N) {
			sum += Math.abs(cx- hx) + Math.abs(cy - hy);
			min = Math.min(min, sum);
			return;
		}
		
		for(int i = 0; i < N; i++) {
			if((flag & 1 << i) != 0) continue;
			int dist = Math.abs(cx- point[i][0]) + Math.abs(cy - point[i][1]);
			permutation(point[i][0], point[i][1], cnt+1, flag | 1 << i, sum + dist);
		}
	}
}