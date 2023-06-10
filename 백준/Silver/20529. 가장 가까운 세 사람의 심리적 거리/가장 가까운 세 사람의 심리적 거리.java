import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

	static int N;
	static int[] mbti;
	static int[] mbtiCount;
	static int[] char2i;
	static int[] countOne;

	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;

		init();

		int num, max;
		String str;
		int T = Integer.parseInt(br.readLine());
		while (T-- > 0) {
			max = 0;
			Arrays.fill(mbtiCount, 0);

			N = Integer.parseInt(br.readLine());
			mbti = new int[N];

			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < N; ++i) {
				str = st.nextToken();

				num = 0;
				for (int j = 0; j < 4; ++j) {
					num |= (char2i[(int) (str.charAt(j) - 'A')] << j);
				}

				mbti[i] = num;
				++mbtiCount[num];
				max = Math.max(max, mbtiCount[num]);

				if (mbtiCount[num] == 3)
					break;
			}

			if (max == 3)
				sb.append("0\n");
			else {
				sb.append(solution()).append("\n");
			}

		}

		bw.write(sb.toString());
		bw.flush();

		bw.close();
		br.close();

	}

	private static void init() {

		mbtiCount = new int[1 << 4];

		char2i = new int[(int) ('Z' - 'A')];
		char2i[(int) ('I' - 'A')] = char2i[(int) ('N' - 'A')] = char2i[(int) ('F' - 'A')] = char2i[(int) ('P' - 'A')] = 1;

		countOne = new int[1 << 4];
		for (int i = 0; i < (1 << 4); ++i) {
			countOne[i] = count1(i);
		}

	}

	private static int count1(int num) {
		int one = 0;
		for (int i = 0; i < 4; ++i) {
			if ((num & (1 << i)) != 0)
				++one;
		}
		return one;
	}

	private static int solution() {

		int min = Integer.MAX_VALUE;
		int score = 0;
		int mbti1, mbti2, mbti3;
		for (int i = 0; i < N - 2; ++i) {
			mbti1 = mbti[i];
			
			for (int j = i + 1; j < N - 1; ++j) {
				mbti2 = mbti[j];
				score = countOne[mbti1 ^ mbti2];

				for (int k = j + 1; k < N; ++k) {
					mbti3 = mbti[k];
					min = Math.min(min, score + countOne[mbti1 ^ mbti3] + countOne[mbti2 ^ mbti3]);
				}
			}

		}

		return min;
	}

}