import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {

	static int N;
	static int[] Dy = new int[2];
	public static void main(String[] args) throws Exception {
		input();
		pro();
	}

	private static void pro() {

		if(N == 0) System.out.println(0);
		else if(N == 1) System.out.println(1);
		else {
			Dy[1] = 1;
			for(int i = 2; i <= N; ++i) {
				int temp = Dy[1];
				Dy[1] += Dy[0];
				Dy[0] = temp;
			}
			System.out.println(Dy[1]);
		}
		
	}

	private static void input() throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
	}

}