import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

class Person {
	public int id;
	public int x, y;

	public Person(int x, int y, int id) {
		this.x = x;
		this.y = y;
		this.id = id;
	}
}

public class Main {

	public static List<Person> Enermys = new ArrayList<>();
	public static List<Person> Archers = new ArrayList<>();
	public static int max;
	public static int N, M, D;
	public static int nEnermy;
	public static int res;
	public static int INF = 987654321;
	static int[] isArcher;
	
	
	public static int playGame(int flag) {
		int cnt = 0;

		Archers.clear();
		for (int j = 0; j < M; j++) {
			if ((flag & 1 << j) != 0) {
				Archers.add(new Person(N, j, 0));
			}
		}
		
		List<Person> temp_Enermys = new ArrayList<>(Enermys.size());
		for(Person e : Enermys)
			temp_Enermys.add(new Person(e.x, e.y, e.id));

		for (int i = 0; i < N; i++) {			
			if(temp_Enermys.size() == 0) break;			

			List<Person> candis = new ArrayList<>();
			for (int a = 0; a < Archers.size(); a++) {
				Person archer = Archers.get(a);
				Person candi = new Person(INF, INF, -1);

				int min_dist = D;

				for (int e = 0; e < temp_Enermys.size(); e++) {
					Person enermy = temp_Enermys.get(e);
					Math.abs(archer.x - enermy.x);

					int diff = Math.abs(archer.x - enermy.x) + Math.abs(archer.y - enermy.y);
					if (diff == min_dist && enermy.y < candi.y) {
						min_dist = diff;
						candi = enermy;

					} else if (diff < min_dist) {
						min_dist = diff;
						candi = enermy;
					}

				}
				if(candi.id == -1) continue;
				candis.add(candi);
			}

			// 적 지우기
			for (Person p : candis) {
				for (int e = 0; e < temp_Enermys.size(); e++) {
					if (p.id == temp_Enermys.get(e).id) {
						temp_Enermys.remove(e);
						cnt++;
						break;
					}
				}
			}

			// 적 이동
			for (int e = 0; e < temp_Enermys.size(); e++) {
				int nx = temp_Enermys.get(e).x + 1;
				if (nx >= N) {
					temp_Enermys.remove(e);
					e--;
				}else {
					temp_Enermys.get(e).x = temp_Enermys.get(e).x + 1;					
				}
			}

		}

		return cnt;
	}

	public static void recursive(int idx, int cnt, int flag) {
		// 마지막에 도착한 경우
		if (cnt == 3) {
			max = Math.max(max, playGame(flag));
			return;
		}

		for(int i = idx; i < M; i++) {
			if((flag & 1 << i) != 0) continue;
			recursive(i + 1, cnt + 1, flag | 1 << i);
		}

	}

	public static void main(String[] args) throws IOException {
		//System.setIn(new FileInputStream("src/day3/input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			D = Integer.parseInt(st.nextToken());

			char[][] map = new char[N][M];

			max = 0;
			nEnermy = 0;
			Enermys.clear();
			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < M; j++) {
					map[i][j] = st.nextToken().charAt(0);
					if (map[i][j] == '1') {
						Enermys.add(new Person(i, j, ++nEnermy));
					}
				}
			}

			recursive(0, 0, 0);
			System.out.println(max);
	}

}