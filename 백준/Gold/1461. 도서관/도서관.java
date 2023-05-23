import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());

		List<Integer> nagative = new ArrayList<>();
		List<Integer> positive = new ArrayList<>();

		int num;
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; ++i) {
			num = Integer.parseInt(st.nextToken());
			if (num < 0)
				nagative.add(num);
			else
				positive.add(num);
		}

		Collections.sort(nagative);
		Collections.sort(positive, Collections.reverseOrder());

		int posSize = positive.size();
		int nagSize = nagative.size();

		int posIdx = 0;
		int nagIdx = 0;

		int posSteps = Integer.MAX_VALUE;
		if (!positive.isEmpty()) {
			posSteps = 0;
			posSteps += positive.get(posIdx);
			posIdx += M;

			while (posIdx < posSize || nagIdx < nagSize) {
				if (posIdx < posSize) {
					posSteps += positive.get(posIdx) * 2;
					posIdx += M;
				}

				if (nagIdx < nagSize) {
					posSteps -= nagative.get(nagIdx) * 2;
					nagIdx += M;
				}
			}

		}
		posIdx = 0;
		nagIdx = 0;

		int nagSteps = Integer.MAX_VALUE;
		if (!nagative.isEmpty()) {
			nagSteps = 0;
			nagSteps -= nagative.get(posIdx);
			nagIdx += M;

			while (posIdx < posSize || nagIdx < nagSize) {
				if (posIdx < posSize) {
					nagSteps += positive.get(posIdx) * 2;
					posIdx += M;
				}

				if (nagIdx < nagSize) {
					nagSteps -= nagative.get(nagIdx) * 2;
					nagIdx += M;
				}
			}
		}
		
		System.out.println(Math.min(posSteps, nagSteps));

	}

}