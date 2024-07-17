import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());

		int dist = 0;

		int row = 1;
		int min = 100;

		for (int i = 1; i < N; ++i) {
			dist = Integer.parseInt(br.readLine());
			if (dist < min) {
				min = dist;
				row = i;
			}
		}

		st = new StringTokenizer(br.readLine());
		dist = Integer.parseInt(st.nextToken());
		if (dist < min) {
			min = dist;
			row = N;
		}

		int col = 1;
		min = dist;
		for (int i = 2; i <= M; ++i) {
			dist = Integer.parseInt(st.nextToken());
			if (dist < min) {
				min = dist;
				col = i;
			}
		}

		System.out.println(row + " " + col);
	}

}