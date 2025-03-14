import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

	static int N;
	static int[] A;
	static int K;
	static boolean[] visited;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		N = Integer.parseInt(br.readLine());
		A = new int[N];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; ++i) {
			A[i] = Integer.parseInt(st.nextToken());
		}

		K = Integer.parseInt(br.readLine());
		Arrays.sort(A);
		int MAX = A[N - 1] * K + 2;
		visited = new boolean[MAX];

		recursive(N - 1, 0, 0);

		int idx = 1;
		while (idx < MAX && visited[idx])
			++idx;
		if (idx % 2 == 0)
			System.out.println("holsoon win at " + idx);
		else
			System.out.println("jjaksoon win at " + idx);

	}

	private static void recursive(int idx, int cnt, int sum) {

		if (cnt == K)
			return;

		for (int i = idx; i >= 0; --i) {
			int next = sum + A[i];
			if (visited[next])
				continue;
			visited[next] = true;
			recursive(i, cnt + 1, next);
		}

	}

}