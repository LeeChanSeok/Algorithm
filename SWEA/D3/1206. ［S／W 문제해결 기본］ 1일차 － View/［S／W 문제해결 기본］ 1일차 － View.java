import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
	static int N;
	static int[] height;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int T = 10;
		for (int tc = 1; tc <= T; tc++) {

			N = Integer.parseInt(br.readLine());
			height = new int[N + 4];

			st = new StringTokenizer(br.readLine());
			for (int i = 2; i < N + 2; i++) {
				height[i] = Integer.parseInt(st.nextToken());
			}

			int res = solution();
			System.out.println("#" + tc + " " + res);

		} // tc 종료
	}

	private static int solution() {
		int ans = 0;
		for (int i = 2; i < N + 2; i++) {
			int min = Math.min(diff(i, i - 2), diff(i, i - 1));
			min = Math.min(min, diff(i, i + 1));
			min = Math.min(min, diff(i, i + 2));
			
			if(min > 0) ans += min;

		}

		return ans;
	}

	private static int diff(int c, int n) {
		return height[c] - height[n];
	}

}