import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int N = Integer.parseInt(br.readLine());
		Set<String> set = new HashSet<>();

		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; ++i) {
			String str = st.nextToken();

			if (str.endsWith("Cheese"))
				set.add(str);
		}

		String ans = "sad";
		if (set.size() >= 4)
			ans = "yummy";

		System.out.println(ans);

	}

}