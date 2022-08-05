import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {

	public static boolean Compare(int[] standard, int[] charCnt) {

		for (int i = 0; i < standard.length; i++)
			if (charCnt[i] < standard[i])
				return false;

		return true;
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int S = Integer.parseInt(st.nextToken());
		int P = Integer.parseInt(st.nextToken());

		String str = br.readLine();

		int[] standard = new int[4];
		int[] charCnt = new int[4];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < 4; i++)
			standard[i] = Integer.parseInt(st.nextToken());

		Map<Character, Integer> map = new HashMap<>();
		map.put('A', 0);
		map.put('C', 1);
		map.put('G', 2);
		map.put('T', 3);
		int ans = 0;

		for (int i = 0; i < P; i++) {
			char c = str.charAt(i);
			charCnt[map.get(c)]++;
		}
		if (Compare(standard, charCnt))
			ans++;

		for (int i = 1; i < S - P + 1; i++) {
			charCnt[map.get(str.charAt(i - 1))]--;
			charCnt[map.get(str.charAt(i + P - 1))]++;
			if (Compare(standard, charCnt))
				ans++;
		}

		System.out.println(ans);
	}

}