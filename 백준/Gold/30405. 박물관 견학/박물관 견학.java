import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());

		int[] arr = new int[N * 2];
		int idx = 0;
		for (int i = 0; i < N; ++i) {
			st = new StringTokenizer(br.readLine());
			int k = Integer.parseInt(st.nextToken());
			arr[idx++] = Integer.parseInt(st.nextToken());
			for (int j = 1; j < k - 1; ++j)
				st.nextToken();
			arr[idx++] = Integer.parseInt(st.nextToken());
		}

		Arrays.sort(arr);

		System.out.println(arr[N - 1]);

	}

}