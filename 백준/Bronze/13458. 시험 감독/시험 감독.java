import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int N = Integer.parseInt(br.readLine());
		int[] count = new int[N];
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i < N; ++i)
			count[i] = Integer.parseInt(st.nextToken());
		
		st = new StringTokenizer(br.readLine());
		
		int B = Integer.parseInt(st.nextToken());
		int C = Integer.parseInt(st.nextToken());
		
		long ans = 0;
		int cnt;
		for(int i = 0; i < N; ++i) {
			++ans;
			cnt = count[i] - B;
			if(cnt > 0) {
				ans += cnt % C == 0? cnt/C : cnt/C + 1;
			}
		}
		
		System.out.println(ans);
	}

}