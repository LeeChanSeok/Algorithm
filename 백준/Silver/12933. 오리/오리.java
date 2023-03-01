import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int[] quack = new int[5];

		int answer = -1;
		int duck = 0;
		char c;
		char[] Arr = br.readLine().toCharArray();
		for (int i = 0, len = Arr.length; i < len; ++i) {
			c = Arr[i];
			if (c == 'q') {
				++quack[0];
				++duck;
			} else if (c == 'u') {
				if (quack[0] != 0) {
					--quack[0];
					++quack[1];
				} else {
					answer = -1;
					break;
				}
			} else if (c == 'a') {
				if (quack[1] != 0) {
					--quack[1];
					++quack[2];
				} else {
					answer = -1;
					break;
				}
			} else if (c == 'c') {
				if (quack[2] != 0) {
					--quack[2];
					++quack[3];
				} else {
					answer = -1;
					break;
				}
			} else if (c == 'k') {
				if (quack[3] != 0) {
					--quack[3];
					answer = Math.max(answer, duck);
					--duck;
				} else {
					answer = -1;
					break;
				}
			}
		}

		for (int i = 0; i < 4; ++i)
			if (quack[i] != 0) {
				answer = -1;
				break;
			}

		System.out.println(answer);
	}

}