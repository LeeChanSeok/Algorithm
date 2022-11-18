import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int K = Integer.parseInt(st.nextToken());
		int N = Integer.parseInt(st.nextToken());
		
		int[] cables = new int[K];
		int len;
		long s = 0, e = 0;
		for(int i = 0; i < K; ++i) {
			len = Integer.parseInt(br.readLine());
			cables[i] = len;
			e = Math.max(e, len);
		}
		e *=2;
		
		int cnt, ans = 0;
		while(s < e) {
			
			len = (int)((s + e) / 2);
			if(len <= ans) break;
			cnt = 0;
			for(int cable : cables)
				cnt+=cable/len;
			
			if(cnt>=N) {
				s = len;
				ans = len;
			}
			else e = len;
		}
		
		System.out.println(ans);

	}

}
