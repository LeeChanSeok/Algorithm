import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	static int n, m;
	static int flag;
	static int ans;
	
	public static void main(String[] args) throws Exception{
		input();
		
		if(m == 0) ans = (int)Math.pow(10, n);
		else recursive(0, 0, 0);
		
		System.out.println(ans);
	}

	private static void recursive(int idx, int select, int cnt) {

		if(cnt + (n - idx) < m) return;
		
		if(idx == n) {
			++ans;
			return;
		}
		
		for(int i = 0; i <= 9; ++i) {
			
			if((flag & (1 << i)) != 0 && (select & (1 << i)) == 0 ) recursive(idx + 1, select | (1 << i), cnt + 1);
			else recursive(idx + 1, select | (1 << i), cnt);
		}
		
	}

	private static void input() throws Exception{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		
		flag = 0;
		if(m != 0) {
			st = new StringTokenizer(br.readLine());
			for(int i = 0; i < m; ++i) {
				int k = Integer.parseInt(st.nextToken());
				flag |= (1 << k);
			}
		}
		
	}

}