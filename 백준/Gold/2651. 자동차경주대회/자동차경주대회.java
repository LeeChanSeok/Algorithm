import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int K = Integer.parseInt(br.readLine());
		int N = Integer.parseInt(br.readLine());

		int[] dist = new int[N + 1];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i <= N; ++i) {
			dist[i] = Integer.parseInt(st.nextToken());
		}

		int[] T = new int[N + 2];
		st = new StringTokenizer(br.readLine());
		for (int i = 1; i <= N; ++i) {
			T[i] = Integer.parseInt(st.nextToken());
		}

		int[] D = new int[N + 2];
		Arrays.fill(D, (int) 1e10);

		D[0] = 0;
		int[] P = new int[N + 2];
		Arrays.fill(P, (int) 1e10);
		P[0] = 0;

		for (int i = 1; i <= N + 1; ++i) {

			int sum = 0;
			for (int j = i - 1; j >= 0; --j) {
				sum += dist[j];
				if (sum > K)
					break;
				if (D[i] >= D[j] + T[i]) {
					D[i] = D[j] + T[i];
					P[i] = j;
				}

			}

		}

		System.out.println(D[N + 1]);

		int path = P[N + 1];
		List<Integer> list = new ArrayList<>();
		while (path != 0) {
			list.add(path);
			path = P[path];
		}

		System.out.println(list.size());
		for (int i = list.size() - 1; i >= 0; --i) {
			System.out.print(list.get(i) + " ");
		}

	}

}