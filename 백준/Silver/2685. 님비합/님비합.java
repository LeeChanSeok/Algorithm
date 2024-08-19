import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int T = Integer.parseInt(br.readLine());
		while (T-- > 0) {
			st = new StringTokenizer(br.readLine());

			int B = Integer.parseInt(st.nextToken());
			int X = Integer.parseInt(st.nextToken());
			int Y = Integer.parseInt(st.nextToken());

			if (X < Y) {
				int tmp = X;
				X = Y;
				Y = tmp;
			}

			List<Integer> X_ = new ArrayList<>();
			List<Integer> Y_ = new ArrayList<>();

			change(X_, X, B);
			change(Y_, Y, B);

			for (int i = 0; i < Y_.size(); ++i) {
				X_.set(i, (X_.get(i) + Y_.get(i)) % B);
			}

			int sum = 0;
			int p = 1;
			for (int i = 0; i < X_.size(); ++i) {
				sum += X_.get(i) * p;
				p *= B;
			}

			System.out.println(sum);
		}

	}

	private static void change(List<Integer> list, int N, int B) {
		while (N != 0) {
			list.add(N % B);
			N /= B;
		}

	}

}