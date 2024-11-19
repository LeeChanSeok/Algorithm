import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int N = Integer.parseInt(br.readLine());
		Queue<Integer> q = new LinkedList<>();

		int[] ans = new int[2];
		int num = 0;

		while (N-- > 0) {
			st = new StringTokenizer(br.readLine());

			int cmd = Integer.parseInt(st.nextToken());
			if (cmd == 1) {
				num = Integer.parseInt(st.nextToken());
				q.offer(num);

				if (ans[0] == q.size()) {
					if (ans[1] > num)
						ans[1] = num;
				} else if (q.size() > ans[0]) {
					ans[0] = q.size();
					ans[1] = num;
				}
			}

			else
				q.poll();

		}

		System.out.println(ans[0] + " " + ans[1]);

	}

}