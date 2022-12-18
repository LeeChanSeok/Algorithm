import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		
		int i = 1, a = 1;
		while(true) {
			if(a >= N) break;
			a += 6*i;
			++i;
		}
		
		System.out.println(i);

	}

}