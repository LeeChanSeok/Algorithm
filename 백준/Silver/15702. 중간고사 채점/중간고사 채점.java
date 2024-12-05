import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    
	public static void main(String[] args) throws Exception {
        
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
        
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
        
		int[] score = new int[N];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; ++i) {
			score[i] = Integer.parseInt(st.nextToken());
		}
        
		int[] ans = { 100000, 0 };
        
		for (int i = 0; i < M; ++i) {
			st = new StringTokenizer(br.readLine());
			int idx = Integer.parseInt(st.nextToken());
			int sum = 0;
			for (int j = 0; j < N; ++j) {
				sum += (st.nextToken().charAt(0) == 'O' ? score[j] : 0);
			}
			if (sum > ans[1])
				ans = new int[] { idx, sum };
			else if (sum == ans[1] && idx < ans[0])
				ans[0] = idx;
		}
        
		System.out.println(ans[0] + " " + ans[1]);
        
	}
    
}