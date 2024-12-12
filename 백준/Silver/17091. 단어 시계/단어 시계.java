import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class Main {

	static Map<Integer, String> map;

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		init();

		int H = Integer.parseInt(br.readLine());
		int M = Integer.parseInt(br.readLine());

		String ans = "";

		if (M == 0)
			ans = String.format("%s o' clock", map.get(H));
		else if (M == 1)
			ans = String.format("%s minute past %s", map.get(M), map.get(H));
		else if (M == 15)
			ans = String.format("%s past %s", map.get(M), map.get(H));
		else if (M < 30)
			ans = String.format("%s minutes past %s", map.get(M), map.get(H));
		else if (M == 30)
			ans = String.format("%s past %s", map.get(M), map.get(H));
		else if (M == 45)
			ans = String.format("%s to %s", map.get(60 - M), map.get(H % 12 + 1));
		else if (M == 59)
			ans = String.format("%s minute to %s", map.get(60 - M), map.get(H % 12 + 1));
		else
			ans = String.format("%s minutes to %s", map.get(60 - M), map.get(H % 12 + 1));

		System.out.println(ans);
	}

	private static void init() {

		map = new HashMap<>();
		map.put(1, "one");
		map.put(2, "two");
		map.put(3, "three");
		map.put(4, "four");
		map.put(5, "five");
		map.put(6, "six");
		map.put(7, "seven");
		map.put(8, "eight");
		map.put(9, "nine");
		map.put(10, "ten");

		map.put(11, "eleven");
		map.put(12, "twelve");
		map.put(13, "thirteen");
		map.put(14, "fourteen");
		map.put(15, "quarter");
		map.put(16, "sixteen");
		map.put(17, "seventeen");
		map.put(18, "eighteen");
		map.put(19, "nineteen");
		map.put(20, "twenty");

		map.put(21, "twenty one");
		map.put(22, "twenty two");
		map.put(23, "twenty three");
		map.put(24, "twenty four");
		map.put(25, "twenty five");
		map.put(26, "twenty six");
		map.put(27, "twenty seven");
		map.put(28, "twenty eight");
		map.put(29, "twenty nine");
		map.put(30, "half");

	}

}