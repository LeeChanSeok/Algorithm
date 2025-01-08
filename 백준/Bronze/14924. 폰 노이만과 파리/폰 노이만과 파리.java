import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int S = Integer.parseInt(st.nextToken());
		int T = Integer.parseInt(st.nextToken());
		int D = Integer.parseInt(st.nextToken());

		int F = D / (2 * S) * T;
		System.out.println(F);
	}

}