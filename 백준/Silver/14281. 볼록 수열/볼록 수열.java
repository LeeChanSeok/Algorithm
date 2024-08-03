import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int N = Integer.parseInt(br.readLine());
		int[] arr = new int[N];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; ++i) {
			arr[i] = Integer.parseInt(st.nextToken());
		}

		boolean sorted = true;
		long cnt = 0;

		do {
			sorted = true;
			for (int i = 1; i < N - 1; ++i) {
				int sum = arr[i - 1] + arr[i + 1];

				if (arr[i] * 2 > sum) {
					sorted = false;
					
					int diff = sum / 2;
					cnt += (arr[i] - diff);
					arr[i] = sum / 2;

				}

			}

		} while (!sorted);

		System.out.println(cnt);

	}

}