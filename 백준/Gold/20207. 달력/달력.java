import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int N = Integer.parseInt(br.readLine());
		int[] days = new int[367];
		
		int S, E;
		for(int i = 0; i < N; ++i) {
			st = new StringTokenizer(br.readLine());
			S = Integer.parseInt(st.nextToken());
			E = Integer.parseInt(st.nextToken());
			
			days[S] += 1;
			days[E+1] -= 1;
		}
		
		for(int i = 1; i <= 365; ++i) {
			days[i] += days[i-1];
		}
		days[366] = 0;
		
		int answer = 0;
		int max = 0;
		int length = 0;
		for(int i = 1; i <= 366; ++i) {
			if(days[i] == 0) {
				answer += max * length;
				max = length = 0;
			}else {
				++length;
				max = Math.max(max, days[i]);
			}
		}
		
		System.out.println(answer);
	}

}
