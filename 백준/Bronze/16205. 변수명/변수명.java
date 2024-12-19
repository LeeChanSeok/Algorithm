import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		List<String> words = new ArrayList<>();

		int cmd = Integer.parseInt(st.nextToken());
		String in = st.nextToken();

		split_string(words, cmd, in);

		System.out.println(change_word(1, words));
		System.out.println(change_word(2, words));
		System.out.println(change_word(3, words));

	}

	private static String change_word(int cmd, List<String> words) {

		StringBuilder sb = new StringBuilder();
		if (cmd == 1) {
			sb.append(words.get(0));
			for (int i = 1; i < words.size(); ++i) {
				sb.append(words.get(i).substring(0, 1).toUpperCase()).append(words.get(i).substring(1));
			}
			return sb.toString();
		} else if (cmd == 2) {

			for (int i = 0; i < words.size() - 1; ++i) {
				sb.append(words.get(i)).append("_");
			}
			sb.append(words.get(words.size() - 1));
			return sb.toString();
		} else if (cmd == 3) {
			for (int i = 0; i < words.size(); ++i) {
				sb.append(words.get(i).substring(0, 1).toUpperCase()).append(words.get(i).substring(1));
			}
			return sb.toString();
		}

		return null;
	}

	private static void split_string(List<String> words, int cmd, String in) {

		if (cmd == 1) {
			int prev = 0;
			for (int i = 0; i < in.length(); ++i) {
				if (isCapital(in.charAt(i))) {
					words.add(in.substring(prev, i).toLowerCase());
					prev = i;
				}
			}
			words.add(in.substring(prev).toLowerCase());
		} else if (cmd == 2) {
			int prev = 0;
			for (int i = 0; i < in.length(); ++i) {
				if (in.charAt(i) == '_') {
					words.add(in.substring(prev, i).toLowerCase());
					prev = i + 1;
				}
			}
			words.add(in.substring(prev).toLowerCase());
		} else if (cmd == 3) {
			in = in.substring(0, 1).toLowerCase() + in.substring(1);
			int prev = 0;
			for (int i = 0; i < in.length(); ++i) {
				if (isCapital(in.charAt(i))) {
					words.add(in.substring(prev, i).toLowerCase());
					prev = i;
				}
			}
			words.add(in.substring(prev).toLowerCase());
		}

	}

	private static boolean isCapital(char c) {
		if (c >= 'A' && c <= 'Z')
			return true;
		return false;
	}

}