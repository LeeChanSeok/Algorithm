import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws Exception {
		int MAX = 26;

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		String[] poem = br.readLine().split(" ");

		int space = Integer.parseInt(br.readLine());

		int[] key = new int[MAX];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < MAX; ++i) {
			key[i] = Integer.parseInt(st.nextToken());
		}

		String title = "";
		boolean isWrite = true;

		int[] in = new int[MAX];
		int N = 0;

		for (String str : poem) {
			if (str.equals(""))
				continue;
			++N;
			str = str.toUpperCase();
			title += str.substring(0, 1);
			in[(int) (str.charAt(0) - 'A')] += 2;
			for (int i = 1; i < str.length(); ++i) {
				if (str.charAt(i) != str.charAt(i - 1)) {
					++in[str.charAt(i) - 'A'];
				}
			}
		}

		for (int i = 0; i < MAX; ++i) {
			if (key[i] < in[i]) {
				isWrite = false;
				break;
			}
		}

		if (N - 1 > space)
			isWrite = false;

		if (!isWrite)
			System.out.println(-1);
		else
			System.out.println(title);

	}

}