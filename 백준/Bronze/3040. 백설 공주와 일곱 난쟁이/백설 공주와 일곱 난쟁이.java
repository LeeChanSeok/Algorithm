import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	public static void combination(int[] score, int[] pick, int N, int idx, int cnt, int sum) {
		
		if(cnt == N-2) {
			if(sum == 100) {
				for(int a : pick)
					System.out.println(a);
			}
			return;
		}
		
		for(int i = idx; i < N; i++) {
			pick[cnt] = score[i]; 
			combination(score, pick, N, i+1, cnt+1, sum + score[i]);			
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = 9;
		int[] score = new int[N];
		int[] pick = new int[N-2];
		for(int i = 0; i < N; i++) {
			score[i] = Integer.parseInt(br.readLine());
		}
		combination(score, pick, N, 0, 0, 0);
	}

}