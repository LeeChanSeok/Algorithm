import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int N = Integer.parseInt(br.readLine());

		int[] A = new int[N * 3];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N * 3; ++i) {
			A[i] = Integer.parseInt(st.nextToken());
		}

		Arrays.sort(A);
		System.out.println(A[N]);

	}

}