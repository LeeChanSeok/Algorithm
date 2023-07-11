import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	static int N;
	static int[][] info;
	
	public static void main(String[] args) throws Exception {
		
		input();
		pro();
		
	}

	private static void pro() {

		long L = 1, R = Integer.MAX_VALUE, ans = 0, ansCnt = 0;
		
		while(L <= R ) {
			long mid = (L + R) / 2;
			
			if(determination((int)mid)) {
				ans = mid;
				R = mid - 1;
			}else {
				L = mid + 1;
			}
		}
		
		if(ans == 0) System.out.println("NOTHING");
		else {
			for(int i = 0; i < N; ++i) {
				if(info[i][0] <= ans && ans <= info[i][1] && (ans - info[i][0]) % info[i][2] == 0) ++ansCnt;
			}
			System.out.println(ans + " " + ansCnt);
		}
		
	}

	private static boolean determination(int candidate) {

		long cnt = 0;
		for(int i = 0; i < N; ++i) {
			cnt += count(info[i][0], info[i][1], info[i][2], candidate);
		}
		
		return cnt % 2 == 1;
	}

	private static int count(int A, int C, int B, int X) {
		if(X < A) return 0;
		if(C < X) return (C - A) / B + 1;
		return (X - A) / B + 1;
	}

	private static void input() throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		N = Integer.parseInt(br.readLine());
		
		info = new int[N][3];
		for(int i = 0; i < N; ++i) {
			st = new StringTokenizer(br.readLine());
			
			info[i][0] = Integer.parseInt(st.nextToken());
			info[i][1] = Integer.parseInt(st.nextToken());
			info[i][2] = Integer.parseInt(st.nextToken());
		}
		
	}

}