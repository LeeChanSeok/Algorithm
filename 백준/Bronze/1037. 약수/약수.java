import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int N = Integer.parseInt(br.readLine());
		int min = Integer.MAX_VALUE;
		int max = Integer.MIN_VALUE;
		int number;
		
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i < N; i++) {
			number = Integer.parseInt(st.nextToken());
			min = Math.min(min, number);
			max = Math.max(max, number);
		}
		System.out.println(min * max);
	}
}