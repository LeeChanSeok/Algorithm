import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {

	public static int max;
	public static void combination(int[] arr, int idx, int N, int M, int cnt, int sum) {
		if(cnt == 2) {
			if(sum <= M)
				max = Math.max(max, sum);
			return;
		}
		
		for(int i = idx; i < N; i++) {
			sum += arr[i];
			combination(arr, i + 1, N, M, cnt+1, sum);
			sum -= arr[i];
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int T = Integer.parseInt(br.readLine());
		int N, M;
		int[] arr;
		for(int tc = 1; tc <= T; tc++) {
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			arr = new int[N];
			
			st = new StringTokenizer(br.readLine());
			for(int i = 0; i < N; i++) 
				arr[i] = Integer.parseInt(st.nextToken());
			
			max = -1;					
			combination(arr, 0, N, M, 0, 0); 
			System.out.printf("#%d %d\n", tc, max);
		}// 테스트 케이스 종료
		
	}

}