import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

public class Solution {

	static int N, totalWeight, w;
	static int res;
	static Integer[] weight;
	static int[] factorials, powof2, Count;
	
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuffer sb = new StringBuffer();
		initCount();

		int T = Integer.parseInt(br.readLine());
		for(int tc = 1; tc <= T; tc++) {
			
			N = Integer.parseInt(br.readLine());
			
			weight = new Integer[N];
			totalWeight = 0;
			st = new StringTokenizer(br.readLine());
			
			for(int i = 0; i < N; i++) {
				w = Integer.parseInt(st.nextToken());
				weight[i] = w;
				totalWeight += w;
			}
			
			Arrays.sort(weight, Collections.reverseOrder());
			
			res = 0;
			permutation(0, 0, 0, 0);
			sb.append("#").append(tc).append(" ").append(res).append("\n");
			
		} // test-case 종료
		System.out.println(sb.toString());
	}

	private static void permutation(int R, int L, int cnt, int flag) {
		
		if(L >= (double)totalWeight/2) {
			int rest = N - cnt;
			//res += Math.pow(2, rest) * factorials[rest];
			res += Count[rest];
			return;
		}
		
		if(cnt == N) {
			res++;
			return;
		}
		
		for(int i = 0; i < N; i ++) {
			if((flag & 1 << i) != 0) continue;
			int w = weight[i];
			
			// 왼쪽에 두는 경우
			permutation(R, L + w, cnt + 1, flag | 1 << i);
			
			// 오른쪽에 두는 경우
			if(R + w <= L)
				permutation(R + w, L, cnt + 1, flag | 1 << i);
			
		}
	}

	private static void initCount() {
		initFactorial();
		initPowOfTwo();
		
		int M = 10;
		Count = new int[M];
		for(int i = 0; i < M; i++) {
			Count[i] = powof2[i] * factorials[i];
		}
		
	}
	
	private static void initFactorial() {
		int M = 10;
		factorials = new int[M];
		factorials[0] = factorials[1] = 1;
		for(int i = 2; i < M; i++) {
			factorials[i] = factorials[i-1] * i;
		}
	}
	
	private static void initPowOfTwo() {
		int M = 10;
		powof2 = new int[M];
		powof2[0] = 1;
		for(int i = 1; i < M; i++) {
			powof2[i] = powof2[i-1] * 2;
		}
		
	}
	
}