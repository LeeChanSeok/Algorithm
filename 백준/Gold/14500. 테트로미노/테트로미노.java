import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

class tetromino{// 도형을 관리하기 위한 class
	public List<shape> sList;

	public tetromino() {
		sList = new ArrayList<>(19);
	}
	public void add(shape s) {
		sList.add(s);
	}
}

class shape {
	int N, M;
	boolean[][] tf;

	public shape(int N, int M, boolean[][] tf) {
		super();
		this.N = N;
		this.M = M;
		this.tf = tf;
	}
}

public class Main {
	public static void init(tetromino t) {	// 도형 초기값
		int n, m;
		boolean[][] tf;
		// #1 : 1-1.
		n = 1;		m = 4;
		tf = new boolean[][] { { true, true, true, true } };
		t.add(new shape(n, m, tf));

		// #2 : 1-2.
		n = 4;		m = 1;
		tf = new boolean[][] { { true }, { true }, { true }, { true } };
		t.add(new shape(n, m, tf));

		// #3 : 2.
		n = 2;		m = 2;
		tf = new boolean[][] { { true, true }, { true, true } };
		t.add(new shape(n, m, tf));

		// #4 : 3-1.
		n = 3;		m = 2;
		tf = new boolean[][] { { true, false }, { true, false }, { true, true } };
		t.add(new shape(n, m, tf));

		// #5 : 3-2.
		n = 3;		m = 2;
		tf = new boolean[][] { { false, true }, { false, true }, { true, true } };
		t.add(new shape(n, m, tf));

		// #6 : 3-3.
		n = 3;		m = 2;
		tf = new boolean[][] { { true, true }, { true, false }, { true, false } };
		t.add(new shape(n, m, tf));

		// #7 : 3-4.
		n = 3;		m = 2;
		tf = new boolean[][] { { true, true }, { false, true }, { false, true } };
		t.add(new shape(n, m, tf));

		// #8 : 3-5.
		n = 2;		m = 3;
		tf = new boolean[][] { { true, true, true }, { true, false, false } };
		t.add(new shape(n, m, tf));
		
		// #9 : 3-6.
		n = 2;		m = 3;
		tf = new boolean[][] { { true, true, true }, { false, false, true } };
		t.add(new shape(n, m, tf));
		
		// #10 : 3-7.
		n = 2;		m = 3;
		tf = new boolean[][] { { false, false, true }, { true, true, true } };
		t.add(new shape(n, m, tf));
		
		// #11 : 3-8.
		n = 2;		m = 3;
		tf = new boolean[][] { { true, false, false }, { true, true, true } };
		t.add(new shape(n, m, tf));
		
		// #12 : 4-1.
		n = 3;		m = 2;
		tf = new boolean[][] { { true, false }, { true, true }, { false, true } };
		t.add(new shape(n, m, tf));

		// #13 : 4-2.
		n = 3;		m = 2;
		tf = new boolean[][] { { false, true }, { true, true }, { true, false } };
		t.add(new shape(n, m, tf));

		// #14 : 4-3.
		n = 2;		m = 3;
		tf = new boolean[][] { { false, true, true }, { true, true, false } };
		t.add(new shape(n, m, tf));

		// #15 : 4-4.
		n = 2;		m = 3;
		tf = new boolean[][] { { true, true, false }, { false, true, true } };
		t.add(new shape(n, m, tf));

		// #16 : 5-1.
		n = 2;		m = 3;
		tf = new boolean[][] { { true, true, true }, { false, true, false } };
		t.add(new shape(n, m, tf));

		// #17 : 5-2.
		n = 2;		m = 3;
		tf = new boolean[][] { { false, true, false }, { true, true, true } };
		t.add(new shape(n, m, tf));

		// #18 : 5-3.
		n = 3;		m = 2;
		tf = new boolean[][] { { false, true }, { true, true }, { false, true } };
		t.add(new shape(n, m, tf));

		// #19 : 5-4.
		n = 3;		m = 2;
		tf = new boolean[][] { { true, false }, { true, true }, { true, false } };
		t.add(new shape(n, m, tf));
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());

		int[][] arr = new int[N][M];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++)
				arr[i][j] = Integer.parseInt(st.nextToken());
		}

		tetromino t = new tetromino();
		init(t);
		
		int max = 0;
		int sum;
		for(int n = 0 ; n < t.sList.size(); n++) {	// 모든 도형에 대해서
			shape s = t.sList.get(n);
			for(int i = 0; i <= N - s.N; i++) {	//주어진 종이에서의 시작 위치
				for(int j = 0; j <= M - s.M; j++) {
					sum = 0;
					for(int i2 = 0; i2 < s.N; i2++) { // 시작위치에서 도형이 차지하는 공간 만큼의 숫자 합
						for(int j2 = 0; j2< s.M; j2++) {
							if(s.tf[i2][j2]) sum += arr[i+i2][j+j2];
						}
					}
					max = Math.max(max, sum);
				}
			}
		}
		System.out.println(max);
	}
}