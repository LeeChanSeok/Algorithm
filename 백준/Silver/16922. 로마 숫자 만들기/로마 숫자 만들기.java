import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;

public class Main {

	static final int[] number = {1, 5, 10, 50};
	static final int[] DELTA = {1, 20, 400, 8000};
	static Set<Integer> visited, answer;
	static int N, res;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine()); 

		res = 0;
		visited = new HashSet<>(); 
		answer = new HashSet<>(); 
		
		recursive(0, 0, 0);
		
		System.out.println(res);

	}
	private static void recursive(int idx, int flag, int total) {

		if(visited.contains(flag)) return;
		visited.add(flag);
	
		if(idx == N) {
			if(!answer.contains(total)) {
				++res;
				answer.add(total);
			}
			return;
		}
		
		for(int i = 0; i < 4; ++i) {
			recursive(idx+1, flag + number[i]*DELTA[i], total+number[i]);
		}
		
	}

}