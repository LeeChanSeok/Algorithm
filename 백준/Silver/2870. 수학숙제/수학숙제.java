import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int N = Integer.parseInt(br.readLine());

		List<String> list = new LinkedList<>();

		for (int i = 0; i < N; ++i) {
			String str = br.readLine();
			str += ".";

			String tmp = "";
			for (int j = 0; j < str.length(); ++j) {
				char c = str.charAt(j);
				if (c >= '0' && c <= '9') {
					tmp += c;
				} else {
					if (tmp.equals(""))
						continue;
					list.add(trimZero(tmp));
					tmp = "";
				}
			}
		}

		Collections.sort(list, (a, b) -> {
			if (a.length() == b.length()) {
				return a.compareTo(b);
			}
			return a.length() - b.length();
		});

		for (String num : list) {

			if (num.equals("0"))
				System.out.println(0);
			else
				System.out.println(num);
		}

	}

	private static String trimZero(String str) {

		int len = str.length();
		int i = 0;
		while (i < len && str.charAt(i) == '0')
			++i;

		if(i == len) return "0";

		return str.substring(i);
	}

}