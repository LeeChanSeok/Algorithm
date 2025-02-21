import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		st = new StringTokenizer(br.readLine());
		int Wo = Integer.parseInt(st.nextToken());
		int lo = Integer.parseInt(st.nextToken());
		int T = Integer.parseInt(st.nextToken());

		st = new StringTokenizer(br.readLine());
		int D = Integer.parseInt(st.nextToken());
		int l = Integer.parseInt(st.nextToken());
		int A = Integer.parseInt(st.nextToken());

		int w1 = Wo + (l - lo - A) * D;

		if (w1 <= 0)
			System.out.println("Danger Diet");
		else
			System.out.println(w1 + " " + lo);

		int w2 = Wo;
		int b2 = lo;

		while (D-- > 0) {
			w2 = w2 + (l - b2 - A);

			if (Math.abs(l - b2 - A) > T) {
				b2 += Math.floor((float) (l - b2 - A) / 2);
			}
		}

		if (b2 <= 0 || w2 <= 0)
			System.out.println("Danger Diet");

		else {
			System.out.print(w2 + " " + b2);


			if ((lo - b2) > 0)
				System.out.println(" YOYO");
			else
				System.out.println(" NO");
		}
	}

}