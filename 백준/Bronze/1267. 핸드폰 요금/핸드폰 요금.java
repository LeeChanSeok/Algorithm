import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int n = Integer.parseInt(br.readLine());
		st = new StringTokenizer(br.readLine());

		int Y_sum = 0;
		int M_sum = 0;

		for (int i = 0; i < n; ++i) {
			int num = Integer.parseInt(st.nextToken());

			Y_sum += ((num / 30) + 1) * 10;
			M_sum += ((num / 60) + 1) * 15;
		}

		if (Y_sum < M_sum)
			System.out.printf("Y %d", Y_sum);
		else if (Y_sum > M_sum)
			System.out.printf("M %d", M_sum);
		else
			System.out.printf("Y M %d", Y_sum);
	}

}