import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	static int n, m, t, k;
	static int[][] A;
	static int[] ans = new int[3];
	
	
	public static void main(String[] args) throws Exception{
		input();
		pro();
	}

	private static void pro() {
		
		for(int i = 0; i < t; i++) {
			for(int j = i; j < t; ++j) {
				determination(i, j);
			}
		}
		
		System.out.println(ans[0] + " " + ans[1]);
		System.out.println(ans[2]);
	}

	private static void determination(int i, int j) {
		
		int x = Math.min(A[i][0], A[j][0]);
		int y = Math.max(A[i][1], A[j][1]);
		
		if(x + k > n ) {
			x = n - k;
		}
		if(y - k < 0) {
			y = k;
		}
		
		int count = 0;
		for(int[] pos : A) {
			if(pos[0] >= x && pos[0] <= x + k
					&& pos[1] <= y && pos[1] >= y - k) ++count;
		}
		
		if(count > ans[2]) {
			ans[0] = x;
			ans[1] = y;
			ans[2] = count;
		}
		
	}

	private static void input() throws Exception{

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		t = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());
		
		A = new int[t][2];
		for(int i = 0; i < t; ++i) {
			st = new StringTokenizer(br.readLine());
			
			A[i][0] = Integer.parseInt(st.nextToken());
			A[i][1] = Integer.parseInt(st.nextToken());
		}
		
	}

}