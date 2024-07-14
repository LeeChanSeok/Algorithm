import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int N = Integer.parseInt(br.readLine());
		int[] arr = new int[6];

		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < 6; ++i) {
			arr[i] = Integer.parseInt(st.nextToken());
		}

		st = new StringTokenizer(br.readLine());
		int T = Integer.parseInt(st.nextToken());
		int P = Integer.parseInt(st.nextToken());

		int res = 0;
		for (int i = 0; i < 6; ++i) {
			if (arr[i] != 0)
				res += (arr[i] - 1) / T + 1;
		}

		System.out.println(res);
		System.out.println((N / P) + " " + (N % P));

	}

}