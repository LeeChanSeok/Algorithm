import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	
	static int max;
	static int[] cards;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int N = Integer.parseInt(br.readLine());
		
		cards = new int[5];
		int[] answer = new int[2];
		for(int i = 1; i <= N; ++i) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < 5; ++j) cards[j] = Integer.parseInt(st.nextToken());
			
			max = 0;
			solution(0, 0, 0);
			
			if(max >= answer[1]) {
				answer[0] = i; 
				answer[1] = max;
			}
			
		}
		
		System.out.println(answer[0]);
	}

	private static void solution(int idx, int sum, int pick) {
		
		if(pick == 3) {
			max = Math.max(max, sum%10);
			return;
		}
		
		if(idx == 5) return;
		
		solution(idx + 1, sum + cards[idx], pick + 1);
		solution(idx + 1, sum, pick);
		
	}

}
