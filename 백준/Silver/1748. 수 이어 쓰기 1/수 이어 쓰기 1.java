import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String N = br.readLine();
		int k = N.length();
		long total_length = 0l;
		int delta = 9;
		for(int i = 1; i < k; i++) {
			total_length = total_length + (delta * i);
			delta *= 10;
		}
		total_length += (Integer.parseInt(N) - delta/9 + 1) * k;
		System.out.println(total_length);
	}
}