import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

	static int N, ans;
	static int[] num;
	
	public static void main(String[] args) throws Exception{
		input();
		pro();

	}

	private static void pro() {
		
		ans = 0;
		Arrays.sort(num);
		subset(0, 0, 0);
		System.out.println(ans);
		
	}

	private static void subset(int idx, int x, int y) {

		if(idx == N) {
			++ans;
			return;
		}
		
		int a = num[idx];
		if(x == a) subset(idx + 1, x + 1, y);
		if(y == a) subset(idx + 1, x, y + 1);
		
	}

	private static void input() throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		N = Integer.parseInt(br.readLine());
		
		num = new int[N];
		st = new StringTokenizer(br.readLine());		
		for(int i = 0; i < N; ++i) num[i] = Integer.parseInt(st.nextToken());
		
	}

}