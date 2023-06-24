import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		
		int T = Integer.parseInt(br.readLine());
		int N, M;
		int[] A, B;
		while(T-- > 0) {
			st = new StringTokenizer(br.readLine());
			
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			
			A = new int[N];
			st = new StringTokenizer(br.readLine());
			for(int i = 0; i < N; ++i) A[i] = Integer.parseInt(st.nextToken());
			
			B = new int[M];
			st = new StringTokenizer(br.readLine());
			for(int i = 0; i < M; ++i) B[i] = Integer.parseInt(st.nextToken());
			Arrays.sort(B);
			
			int answer = 0;
			int l, r, mid, cand;
			for(int a : A) {
				
				l = 0; r = M-1;				
				cand = -1;
				while( l <= r) {
					mid = (l + r) / 2;
					
					if(a > B[mid]) {
						cand = mid;
						l = mid + 1;
					}else {
						r = mid - 1;
					}
				}
				answer += cand + 1;
			}
			
			sb.append(answer).append("\n");
		
		}
		
		bw.write(sb.toString());
		bw.flush();
		
		bw.close();
		br.close();
	}

}