import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());
		int taesu = Integer.parseInt(st.nextToken());
		int P = Integer.parseInt(st.nextToken());
		Integer[] score = new Integer[N];

		int rank = -1;

		if (N == 0) rank = 1;
		else {
			st = new StringTokenizer(br.readLine());

			for (int i = 0; i < N; ++i)	score[i] = Integer.parseInt(st.nextToken());

			Arrays.sort(score, Collections.reverseOrder());
			if (N == P && taesu == score[N - 1]) rank = -1;
			else {
				
				int l = 0, r = N - 1;
				
				while (l <= r) {
					int mid = (l + r) / 2;
					
					if (taesu >= score[mid]) {
						rank = mid;
						r = mid - 1;
					} else {
						l = mid + 1;
					}
				}
				if (rank == -1) rank = N;
				++rank;
				
				if(rank > P) rank = -1;
			}

		}

		System.out.println(rank);

	}

}
