import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	
	static int N, Hatk;
	static int[][] arr;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		Hatk = Integer.parseInt(st.nextToken());
		
		arr = new int[N][3];
		for(int i = 0; i < N; ++i) {
			st = new StringTokenizer(br.readLine());
			
			arr[i][0] = Integer.parseInt(st.nextToken());
			arr[i][1] = Integer.parseInt(st.nextToken());
			arr[i][2] = Integer.parseInt(st.nextToken());
		}
		
		long ans = binarySearch();
		System.out.println(ans);

	}


	private static long binarySearch() {
		
		long l = 0, r = Long.MAX_VALUE;
		long res = Long.MAX_VALUE;
		while(l <= r) {
			
			long mid = (l + r) / 2;
			if(simulation(mid)) {
				res = mid;
				r = mid - 1;
			} else {
				l = mid + 1;
			}
		}
		
		return res;
		
	}


	private static boolean simulation(long Hmax) {

		long cur = Hmax;
		long atk = Hatk;
		
		for(int i = 0; i < N; ++i) {
			int t = arr[i][0];
			int a = arr[i][1];
			int h = arr[i][2];
			
			if(t == 1) {
				
				long x = (long)Math.ceil((double)h / atk);
				long y = (long)Math.ceil((double)cur / a);
				if(x > y) return false;
				
				cur -= a * (x - 1);
				
			} else {
				cur = Math.min(Hmax, cur + h);
				atk += a;
			}
			
		}
		
		return true;
	}

}