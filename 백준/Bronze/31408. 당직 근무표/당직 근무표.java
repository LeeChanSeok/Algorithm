import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int N = Integer.parseInt(br.readLine());

		int MAX = 100000;
		int[] arr = new int[MAX + 1];

		int mIdx = 0;
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; ++i) {
			int num = Integer.parseInt(st.nextToken());

			++arr[num];
			if (arr[num] > arr[mIdx]) {
				mIdx = num;
			}
		}

		if (arr[mIdx] > N / 2 + N % 2)
			System.out.println("NO");
		else
			System.out.println("YES");

	}

}