import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int T = Integer.parseInt(br.readLine());
		while(T-- > 0) {
			int N = Integer.parseInt(br.readLine());
			
			int W[] = new int[N];
			int C[] = new int[N];
			
			for(int i = 0; i < N; ++i) {
				st = new StringTokenizer(br.readLine());
				
				W[i] = (int)(Double.parseDouble(st.nextToken()) * 10);
				C[i] = (int)(Double.parseDouble(st.nextToken()) * 10);
						
			}
			
			int[] D = new int[N];
			Arrays.fill(D, 1);
			
			for(int j = 0; j < N; ++j) {
				
				int w1 = W[j]; int c1 = C[j];
				for(int k = j + 1; k < N; ++k) {
					int w2 = W[k]; int c2 = C[k];
					
					if(w1 < w2 && c1 > c2) {
						D[k] = Math.max(D[k], D[j] + 1);
					}
				}
				
			}
			
			int max = 0;
			for(int i = 0; i < N; ++i) {
				max = Math.max(max, D[i]);
			}
			
			System.out.println(max);
			
		}

	}

}