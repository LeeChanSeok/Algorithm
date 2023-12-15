import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	
	static int h, w, n;
	static int[][] sticker;
	

	public static void main(String[] args) throws Exception {
		input();
		pro();
	}

	private static void pro() {

		int ans = 0;
		for(int i = 0; i < n - 1; ++i) {
			for(int j = i + 1; j < n; ++j) {
				int area = sticker[i][0]*sticker[i][1] + sticker[j][0]*sticker[j][1];
				if(area <= ans) continue;
				
				if(isStick(i, j)) {
					ans = Math.max(ans, area);
				}
			}
		}
		
		System.out.println(ans);
	}

	private static boolean isStick(int i, int j) {

		int[] s1 = sticker[i];
		int[] s2 = sticker[j];
		
		if(ischeck(s1, s2)) return true;
		
		// s1 회전
		swap(s1);
		if(ischeck(s1, s2)) return true;
		
		// s2 회전
		swap(s2);
		if(ischeck(s1, s2)) return true;
		
		// s1 회전
		swap(s1);
		if(ischeck(s1, s2)) return true;
		
		return false;
	}

	private static void swap(int[] s) {

		int temp = s[0];
		s[0] = s[1];
		s[1] = temp;
		
	}

	private static boolean ischeck(int[] s1, int[] s2) {
		int r, c;
		// 1. 행
		r = Math.max(s1[0], s2[0]); c = s1[1] + s2[1];
		if(inRange(r, c)) return true;
				
		// 2. 열
		r = s1[0] + s2[0]; c = Math.max(s1[1], s2[1]);
		if(inRange(r, c)) return true;

		return false;
	}


	private static boolean inRange(int r, int c) {

		if(r <= h && c <= w) return true;
		
		return false;
	}

	private static void input() throws Exception{

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		h = Integer.parseInt(st.nextToken());
		w = Integer.parseInt(st.nextToken());
		
		n = Integer.parseInt(br.readLine());
		sticker = new int[n][2];
		
		for(int i = 0; i < n; ++i) {
			st = new StringTokenizer(br.readLine());
			sticker[i][0] = Integer.parseInt(st.nextToken());
			sticker[i][1] = Integer.parseInt(st.nextToken());
		}

	}

}