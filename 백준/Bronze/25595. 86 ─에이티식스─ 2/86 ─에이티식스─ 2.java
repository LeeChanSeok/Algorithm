import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int N = Integer.parseInt(br.readLine());
		boolean pos = false;
		boolean even = false, odd = false;
		
		for (int i = 0; i < N; ++i) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; ++j) {
				char c = st.nextToken().charAt(0);

				if (c == '1') {

					if ((i + j) % 2 == 0)
						even = true;
					else
						odd = true;
				} else if (c == '2') {
					if ((i + j) % 2 == 0)
						pos = true;
				}
			}
		}

		String ans = null;
		if ((pos && even) || (!pos && odd)) {
			ans = "Kiriya";
		} else {
			ans = "Lena";
		}
		
		System.out.println(ans);
	}

}