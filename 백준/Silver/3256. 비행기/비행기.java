import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Main {

	static class Info {
		int id, pos, time;

		public Info(int id, int pos, int time) {
			super();
			this.id = id;
			this.pos = pos;
			this.time = time;
		}

	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int MAX_R = 1000;

		int N = Integer.parseInt(br.readLine());
		List<Info> list = new ArrayList<>();

		list.add(new Info(0, MAX_R + 1, 0));
		for (int i = 1; i <= N; ++i) {
			int R = Integer.parseInt(br.readLine());
			list.add(new Info(R, 0, 0));
		}

		int cnt = 0;
		while (list.size() != 1) {
			++cnt;

			Iterator<Info> iter = list.iterator();
			Info prev = iter.next();
			while (iter.hasNext()) {

				Info data = iter.next();
				// 1. 해당행에 도착했는 경우
				if (data.id == data.pos) {
					++data.time;

					// 1-1. 5초가 지난 경우(짐을 다 넣은 경우)
					if (data.time == 5) {
						data.pos = MAX_R + 1;
						iter.remove();
					}
				}
				// 2. 이동이 가능한 경우
				else if (prev.pos != 0 && data.pos + 1 != prev.pos) {
					++data.pos;

				}
				prev = data;
			}
		}

		System.out.println(cnt - 1);

	}

}