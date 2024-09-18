import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());

		int[] score = new int[N + 1];

		Integer[][] card = new Integer[N + 1][M];

		for (int i = 1; i <= N; ++i) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; ++j) {
				card[i][j] = Integer.parseInt(st.nextToken());
			}

			Arrays.sort(card[i], Collections.reverseOrder());
		}

		for (int j = 0; j < M; ++j) {
			int max = 0;
			List<Integer> list = new LinkedList<>();

			for (int i = 1; i <= N; ++i) {

				if (card[i][j] > max) {
					max = card[i][j];
					list.clear();
					list.add(i);
				} else if (card[i][j] == max) {
					list.add(i);
				}
			}

			for (int num : list) {
				++score[num];
			}

		}

		int max = 0;
		List<Integer> list = new LinkedList<>();

		for (int i = 1; i <= N; ++i) {

			if (score[i] > max) {
				max = score[i];
				list.clear();
				list.add(i);
			} else if (score[i] == max) {
				list.add(i);
			}
		}

		for (int num : list) {
			sb.append(num + " ");
		}

		System.out.println(sb);

	}

}