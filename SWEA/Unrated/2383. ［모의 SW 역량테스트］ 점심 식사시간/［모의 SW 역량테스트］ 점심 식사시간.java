import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Solution {
	static class Person {
		int x, y, stair, dist, time;
		boolean inStair;

		public Person(int x, int y, int stair, int dist, int time, boolean inStair) {
			super();
			this.x = x;
			this.y = y;
			this.stair = stair;
			this.dist = dist;
			this.time = time;
			this.inStair = inStair;
		}

	}

	static class Stair {
		int x, y, num, useCnt;

		public Stair(int x, int y, int num, int useCnt) {
			super();
			this.x = x;
			this.y = y;
			this.num = num;
			this.useCnt = useCnt;
		}
		
	}

	static int N, min, personCnt;
	static List<Person> persons;
	static int[] stairOrder;
	static Stair[] stairs = new Stair[2];

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;

		int T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= T; tc++) {

			// 1. input
			N = Integer.parseInt(br.readLine());
			persons = new ArrayList<>();
			int stairCnt = 0;
			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < N; j++) {
					int num = Integer.parseInt(st.nextToken());
					if (num == 1) {
						persons.add(new Person(i, j, -1, -1, -1, false));
					} else if (num > 1) {
						stairs[stairCnt++] = new Stair(i, j, num, 0);
					}
				}
			}

			// 2. solution
			min = Integer.MAX_VALUE;
			personCnt = persons.size();
			stairOrder = new int[personCnt];
			solution(0);
			sb.append("#" + tc + " " + min + "\n");

		} // tc종료
		bw.write(sb.toString());
		bw.close();
	}

	private static void solution(int cnt) {
		if(cnt == personCnt) {
			simulation();
			return;
		}
		
		stairOrder[cnt] = 0;
		solution(cnt+1);
		stairOrder[cnt] = 1;
		solution(cnt+1);
		
	}

	private static void simulation() {
		int idx = 0;
		for(Person person : persons) {
			person.stair = stairOrder[idx++];
			person.dist = calc_dist(person);
			person.time = stairs[person.stair].num;
			person.inStair = false;
		}
		stairs[0].useCnt = 0;
		stairs[1].useCnt = 0;
		int time = 0;
		int exit = 0;
		while(time++ < min) {
			// 1. 계산의 사람 이동
			//		계단 이동 완료시 계단 사용 여부 및 사용자 정보 갱신
			for(Person person : persons) {
				// 사용자가 계단에 있는 경우
				if(person.inStair) {
					// 계단 끝 도착 시
					if(--person.time < 0) {
						person.inStair = false;
						exit++;
						stairs[person.stair].useCnt--;
					}
				}
			}
			
			// 2. 사용자 이동 및 계단 사용 확인
			for(Person person: persons) {
				// 계단 위치에 도착 하였는지 확인
				if(person.dist >= 0) person.dist--;
				
				if(person.dist < 0 && !person.inStair && person.time > 0 && stairs[person.stair].useCnt < 3) {
					person.inStair = true;
					person.time--;
					stairs[person.stair].useCnt++;
				}
			}
			
			// 3. 이동 완료 여부 확인
			if(exit == personCnt) {
				min = Math.min(min, time);
			}
		}
	}

	private static int calc_dist(Person person) {
		// TODO Auto-generated method stub
		return Math.abs(person.x - stairs[person.stair].x) + Math.abs(person.y - stairs[person.stair].y);
	}

}
