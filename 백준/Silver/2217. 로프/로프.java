import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;

public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		Integer[] rope = new Integer[N];
		for(int i = 0; i < N; ++i) rope[i] = Integer.parseInt(br.readLine());
		
		Arrays.sort(rope, Collections.reverseOrder());
		
		int answer = 0;
		int result;
		for(int i = 0; i < N; ++i) {
			result = (i+1) * rope[i];
			if(result > answer) answer = result;
		}
		
		System.out.println(answer);
	}

}
