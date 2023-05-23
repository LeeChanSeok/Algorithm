import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	static int K, minCut;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		K = Integer.parseInt(br.readLine());

		int chocolate = 1;
		while (chocolate < K)
			chocolate *= 2;

		minCut = 0;
		recursive(0, chocolate, 0);

		System.out.println(chocolate + " " + minCut);

	}

	private static void recursive(int fix, int piece, int cut) {

		int total = fix + piece;

		if (total == K) {
			minCut = cut;
			return;
		} else if (total < K) {
			recursive(fix + piece, piece, cut);
		} else {
			recursive(fix, piece / 2, cut + 1);
		}

	}

}
