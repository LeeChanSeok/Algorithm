import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int A = Integer.parseInt(st.nextToken());
		int B = Integer.parseInt(st.nextToken());

		int[] A_ = new int[3];
		int[] B_ = new int[3];

		int N = 0;
		int total = 0;
		int idx = 0;
		while (B > idx) {

			idx += (++N);
			total += (N * N);

			if (A <= idx && A_[0] == 0)
				A_ = new int[] { N, idx, total };
			if (B <= idx)
				B_ = new int[] { N, idx, total };

		}

		int Bsum = B_[2] - (B_[1] - B) * B_[0];
		int Asum = A_[2] - (A_[1] - A + 1) * A_[0];

		System.out.println(Bsum - Asum);

	}

}