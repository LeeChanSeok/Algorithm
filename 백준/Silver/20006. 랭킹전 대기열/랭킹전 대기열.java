import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

	static class Player implements Comparable<Player> {
		int level;
		String name;

		public Player(int level, String name) {
			super();
			this.level = level;
			this.name = name;
		}

		@Override
		public int compareTo(Player o) {

			return this.name.compareTo(o.name);
		}

	}

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int p = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());

		List<List<Player>> list = new LinkedList<>();

		while (p-- > 0) {

			st = new StringTokenizer(br.readLine());
			Player player = new Player(Integer.parseInt(st.nextToken()), st.nextToken());

			boolean isEnter = false;
			Iterator<List<Player>> iter = list.iterator();
			while (iter.hasNext()) {
				List<Player> plist = iter.next();
				if (plist.size() == m)
					continue;

				Player host = plist.get(0);
				if (player.level >= host.level - 10 && player.level <= host.level + 10) {
					isEnter = true;
					plist.add(player);

					break;
				}
			}

			if (!isEnter) {
				List<Player> plist = new LinkedList<>();
				plist.add(player);
				list.add(plist);
			}
		}

		for (List<Player> plist : list) {
			if (plist.size() == m) {
				bw.write("Started!\n");
			} else {
				bw.write("Waiting!\n");
			}

			Collections.sort(plist);
			for (Player pl : plist) {
				bw.write(pl.level + " " + pl.name + "\n");
			}
		}

		bw.flush();
		bw.close();
		br.close();

	}

}