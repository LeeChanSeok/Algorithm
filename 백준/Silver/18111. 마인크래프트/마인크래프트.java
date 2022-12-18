import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N, M, B;
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		B = Integer.parseInt(st.nextToken());
		
		int[] block = new int[259];
		
		int num;
		int max = Integer.MIN_VALUE, min = Integer.MAX_VALUE;
		for(int i = 0; i < N; ++i) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < M; ++j) {
				num = Integer.parseInt(st.nextToken()) + 1;
				++block[num];
				
				max = Math.max(max, num);
				min = Math.min(min, num);
			}
					
		}
		
		int[] prefix_sum = new int[259];
		for(int i = min; i <= max+1; ++i) {
			prefix_sum[i] = prefix_sum[i-1] + block[i];
		}
		
		int L = 0, R = 0;
		for(int i = min; i <= max; ++i) {
			L += (max + 1 - i)*block[i];
		}
		
		int t, minT = Integer.MAX_VALUE, maxH = 0;
		int needBlock = L;
		for(int i = max; i >= min; --i) {
			
			L -= (prefix_sum[i-1] + block[i]);
			R += (prefix_sum[max] - prefix_sum[i+1] + block[i+1])*2;
			
			needBlock -= (prefix_sum[i-1] + block[i]);
			if(needBlock <= B) {
				t = L + R;
				if(t < minT) {
					minT = t; maxH = i-1;
				}else break;
			};
			B += (prefix_sum[max] - prefix_sum[i-1]);
		}
		System.out.println(minT + " " + maxH);

	}

}