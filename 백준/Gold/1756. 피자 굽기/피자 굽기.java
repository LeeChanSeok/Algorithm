import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	static int[] oven;
	static int H, radius;
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int D = Integer.parseInt(st.nextToken());
		int N = Integer.parseInt(st.nextToken());
		
		int INF = Integer.MAX_VALUE;
		
		oven = new int[D];
		st = new StringTokenizer(br.readLine());
		int prev = INF;
		for(int i = 0; i < D; ++i) {
			int H = Integer.parseInt(st.nextToken());
			oven[i] = (H > prev) ? prev : H;
			prev = oven[i];
		}
		
		int L = 0, R = D;
		int answer = 0;
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i < N; ++i) {
			
			int d = Integer.parseInt(st.nextToken());
			
			R = binarySearch(L, R, d);			
			if(R == 0) {
				answer = 0;
				break;
			}else {
				answer = R;
			}
			--R;
			
		}
		
		System.out.println(answer);
	}
	
	private static int binarySearch(int l, int r, int d) {
		
		while( l < r ) {
			int mid = (l + r) / 2;
			
			if(oven[mid] < d) {
				r = mid;
			}else {
				l = mid + 1;
			}
			
		}
		return r;

	}

}