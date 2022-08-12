import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int L = Integer.parseInt(br.readLine());
		int N = Integer.parseInt(br.readLine());
		
		int max_cake = -1;
		int max_cake_idx = -1;
		
		int[] cake = new int[L+1];
		int[] Person = new int[N+1];
		int p, k;
		for(int i = 1; i<=N; i++) {
			st = new StringTokenizer(br.readLine());
			p = Integer.parseInt(st.nextToken());
			k = Integer.parseInt(st.nextToken());
			
			if(k - p + 1 > max_cake) {
				max_cake = k - p + 1;
				max_cake_idx = i;
			}
			
			for(int j = p ; j <= k; j++) {
				if(cake[j] == 0) {
					cake[j] = i;
					Person[i]++;
				}
			}
			
		}
		
		System.out.println(max_cake_idx);
		max_cake = -1;
		max_cake_idx = -1;
		for(int i = 1; i <= N; i++) {
			if(Person[i] > max_cake) {
				max_cake = Person[i];
				max_cake_idx = i;
			}
		}
		
		System.out.println(max_cake_idx);
	}
}
