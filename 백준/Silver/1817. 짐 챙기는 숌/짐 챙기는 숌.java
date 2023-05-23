import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		int backpack = 1;
		int weight = 0;
		int w;
		
		if(N == 0) backpack = 0;
		else {
			st = new StringTokenizer(br.readLine());
			
			for(int i = 0 ; i < N; ++i) {
				w = Integer.parseInt(st.nextToken());
				if(weight + w > M) {
					++backpack;
					weight = w;
				}else {
					weight += w;
				}
			}
			
		}
		
		System.out.println(backpack);
		
	}

}