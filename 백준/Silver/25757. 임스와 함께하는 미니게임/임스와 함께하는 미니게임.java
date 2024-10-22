import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());
		char c = st.nextToken().charAt(0);

		Set<String> set = new HashSet<>();
		for (int i = 0; i < N; ++i) {
			set.add(br.readLine());

		}

		int ans = 0;
		int size = set.size();

		if (c == 'Y')
			ans = size;
		else if (c == 'F')
			ans = size / 2;
		else
			ans = size / 3;

		System.out.println(ans);

	}

}