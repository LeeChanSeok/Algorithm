import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	static long A, B, res;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		A = Integer.parseInt(st.nextToken());
		B = Integer.parseInt(st.nextToken());
		
		res = -1;
		dfs(A, 1);
		System.out.println(res);
		
	}
	private static void dfs(long num, long cnt) {
		if(num > B) return;
		if(num == B) {
			res = cnt;
			return;
		}
		dfs(num * 2, cnt+1);
		dfs(num * 10 + 1, cnt+1);
	}

}