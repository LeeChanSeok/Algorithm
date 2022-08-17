import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class Solution {

	static class Point {
		int x, y;

		public Point(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}

	static class Person extends Point {
		int moveIdx;
		int[] moveList;
		
		int[] dx = { 0, -1, 0, 1, 0 };
		int[] dy = { 0, 0, 1, 0, -1 };

		public Person(int x, int y, int moveIdx, int[] moveList) {
			super(x, y);
			this.moveList = moveList;
		}
		
		public void move() {
			x = x + dx[moveList[moveIdx]];
			y = y + dy[moveList[moveIdx]];
			moveIdx++;
		}

	}

	static class BC extends Point implements Comparable<BC>{
		int idx;
		int C, P;

		public BC(int x, int y, int idx, int C, int P) {
			super(x, y);
			this.idx = idx;
			this.C = C;
			this.P = P;
		}

		@Override
		public int compareTo(BC o) {
			return o.P - this.P;
		}
	}

	public static int calc_dist(Person p, BC bc) {
		return Math.abs(p.x - bc.x) + Math.abs(p.y - bc.y);
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuffer sb = new StringBuffer();

		int N = 10; // 맵의 크기
		int T = Integer.parseInt(br.readLine()); // Test-case

		int M, A; // 이동 시간, BC의 개수

		// 사용자 정보
		Person p1, p2; // 두 사용자에 대한 정보
		int[] move; // 사용자 이동 정보
		List<BC> bc1, bc2;
		
		// BC 정보
		BC[] bc;
		int x, y, c, p;
		
		//
		int totalCharge;
		int maxCharge;
		for (int tc = 1; tc <= T; tc++) {
			st = new StringTokenizer(br.readLine());
			M = Integer.parseInt(st.nextToken()); // 이동 시간
			A = Integer.parseInt(st.nextToken()); // BC의 개수
			totalCharge = 0;
			
			// 1. 사용자 정보 입력
			// 1-1.첫번째 사용자에 대한 정보 입력
			st = new StringTokenizer(br.readLine());
			move = new int[M];
			for (int i = 0; i < M; i++) {
				move[i] = Integer.parseInt(st.nextToken());
			}
			// x,  y,  moveIdx, int[] moveList
			p1 = new Person(0, 0, 0, move);

			// 1-2.두번째 사용자에 대한 정보 입력
			st = new StringTokenizer(br.readLine());
			move = new int[M];
			for (int i = 0; i < M; i++) {
				move[i] = Integer.parseInt(st.nextToken());
			}
			p2 = new Person(N - 1, N - 1, 0, move);

			// 2. BC의 정보 입력
			// BC = new int[N][N][A];
			bc = new BC[A];

			for (int n = 0; n < A; n++) {
				st = new StringTokenizer(br.readLine());
				y = Integer.parseInt(st.nextToken())-1;
				x = Integer.parseInt(st.nextToken())-1;
				c = Integer.parseInt(st.nextToken());
				p = Integer.parseInt(st.nextToken());
				
				bc[n] = new BC(x, y, n, c, p);
			}
			
			// 3. simulation
			int t = 0;
			while(true) {
				bc1 = new ArrayList<>();
				bc2 = new ArrayList<>();
				// 3-1.  사용자별 충전 가능한 BC 구하기
				for(BC b : bc) {
					if(calc_dist(p1, b) <= b.C) bc1.add(b);
					if(calc_dist(p2, b) <= b.C) bc2.add(b);
				}
				// 3-2. 충전성능을 내림차순으로 정렬
				Collections.sort(bc1);
				Collections.sort(bc2);

				// 두 사용자중 한명이라도 충전할 수 없는 경우
				if(bc1.size() == 0 && bc2.size() == 0) {}				
				else if(bc1.size() == 0 && bc2.size() != 0) totalCharge += bc2.get(0).P;
				else if(bc1.size() != 0 && bc2.size() == 0) totalCharge += bc1.get(0).P;
				else { // 두 사용자 모두 충전 가능한 경우
					
					if(bc1.get(0).idx != bc2.get(0).idx) {// 사용자별 가장 성능좋은 충전기가 서로 다른 경우, 각자의 충전기로 충전
						totalCharge += bc1.get(0).P;
						totalCharge += bc2.get(0).P;
					}else { // 사용자별 가장 성능좋은 충전기가 서로 다른 경우, 각자의 충전기로 충전
						if(bc1.size() == 1 && bc2.size() == 1) totalCharge += bc1.get(0).P;
						else if(bc1.size() == 1 && bc2.size() > 1) {
							totalCharge += bc1.get(0).P + bc2.get(1).P;
						}else if(bc1.size() > 1 && bc2.size() == 1) {
							totalCharge += bc1.get(1).P + bc2.get(0).P;
						}else {	// 두 사용자의 최대 성능의 충전기가 같은 경우
							maxCharge = Math.max(bc1.get(1).P, bc2.get(1).P);
							totalCharge += bc1.get(0).P + maxCharge;
						}
					}
					
				}
				if(t >= M) break;
				// 3-2 다음 위치로 이동
				p1.move();
				p2.move();
				t++;
			}
			sb.append("#").append(tc).append(" ").append(totalCharge).append("\n");
			
		} // test-case 종료
		System.out.println(sb.toString());
	}

}