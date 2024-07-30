import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		int N = Integer.parseInt(br.readLine());
		char[] S = new char[N];

		for (int i = 0; i < N; ++i) {
			S[i] = br.readLine().charAt(0);
		}

		int s = 0, e = N - 1;
		while (s <= e) {
			if (s == e) {
				sb.append(S[s++]);
			} else if (S[s] < S[e]) {
				sb.append(S[s++]);
			} else if (S[e] < S[s]) {
				sb.append(S[e--]);
			} else {
				int ss = s, ee = e;
				for (; ss <= ee; ss++, ee--) {
					if (S[ss] < S[ee]) {
						sb.append(S[s++]);
						break;
					} else if (S[ss] > S[ee]) {
						sb.append(S[e--]);
						break;
					}
				}
				
				if(ss > ee) sb.append(S[s++]);
			}
		}

		int DIV = 80;
		int m = N / DIV;
		for (int i = 1; i <= N; ++i) {
			System.out.print(sb.charAt(i - 1));
			if (i % DIV == 0)
				System.out.println();
		}

	}

}