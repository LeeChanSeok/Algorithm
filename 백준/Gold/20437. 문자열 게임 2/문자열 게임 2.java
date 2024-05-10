import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		int T = Integer.parseInt(br.readLine());
		int alphaCnt = (int) ('z' - 'a') + 1;

		while (T-- > 0) {
			List<Integer>[] list = new List[alphaCnt];
			for (int i = 0; i < alphaCnt; ++i) {
				list[i] = new ArrayList<>();
			}

			char[] str = br.readLine().toCharArray();
			int k = Integer.parseInt(br.readLine());

			int len = str.length;
			for (int i = 0; i < len; ++i) {
				list[(int) (str[i] - 'a')].add(i);
			}

			int min = Integer.MAX_VALUE;
			int max = -1;
			for (int i = 0; i < alphaCnt; ++i) {
				int size = list[i].size();

				for (int j = k - 1; j < size; ++j) {
					int res = list[i].get(j) - list[i].get(j - k + 1) + 1;
					min = Math.min(min, res);
					max = Math.max(max, res);

				}
			}

			if (max == -1)
				sb.append("-1\n");
			else
				sb.append(min + " " + max).append('\n');
		}

		System.out.println(sb);

	}

}