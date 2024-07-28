import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int T = Integer.parseInt(br.readLine());
		for(int tc = 1; tc <= T; ++tc) {
			int N = Integer.parseInt(br.readLine());
			
			int[] arr = new int[N+1];
			st = new StringTokenizer(br.readLine());
			for(int i = 1; i <= N; ++i) {
				arr[i] = Integer.parseInt(st.nextToken());
			}
			
			int[] D = new int[N+1];
			int max = 0;
			for(int i = 1; i <= N; ++i) {

				for(int j = i - 1; j >= 0; --j) {
					if(arr[i] > arr[j]) {
						D[i] = Math.max(D[i], D[j] + 1);
						if(D[i] == max + 1) {
							++max;
							break;
						}
					}
				}

			}
			
			System.out.printf("Case #%d: %d\n", tc, N - max);

		}

	}

}