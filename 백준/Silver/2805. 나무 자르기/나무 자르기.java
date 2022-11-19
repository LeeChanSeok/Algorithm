import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());

		int[] heights = new int[N];
		int h, maxH = 0;
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; ++i) {
			h = Integer.parseInt(st.nextToken());
			heights[i] = h;
			maxH = (h > maxH) ? h : maxH;
		}
		Arrays.sort(heights);

		int hs, he;
		int ts, te, idx;
		int mIdx;
		long sum;
		// 1. 높이에 대해서 이분탐색
		hs = 0;
		he = maxH;

		int ans = 0;

		while (hs < he) {
			h = (hs + he) >> 1;

			ts = 0;
			te = N;
			mIdx = 0;
			// 2. 해당 높이보다 큰 높이의 인덱스를 찾는 이분 탐색
			while (ts < te) {
				idx = (ts + te) / 2;

				if (heights[idx] <= h) {
					ts = idx + 1;
					mIdx = idx;
				} else
					te = idx;
			}

			sum = 0;
			for (int i = te; i < N; ++i)
				sum += (heights[i] - h) > 0 ? (heights[i] - h) : 0;

			if (sum >= M) {
				hs = h + 1;
				ans = h;
			} else
				he = h;

		}

		System.out.println(ans);

	}

}