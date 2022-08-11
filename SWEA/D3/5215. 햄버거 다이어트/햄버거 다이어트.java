import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

class Ingredient {
	int score, cal;
	double rate;

	public Ingredient(int score, int cal) {
		this.score = score;
		this.cal = cal;
		this.rate = (double) score / cal;
	};

}

public class Solution {
	public static int max;
	public static PriorityQueue<Ingredient> pq;
	public static void combination(List<Ingredient> list, int N, int L, int cnt, int score, int cal) {
		if (cal > L)
			return;
		if (cnt == N) {
			max = Math.max(max, score);
			return;
		}
		combination(list, N, L, cnt + 1, score+ list.get(cnt).score, cal + list.get(cnt).cal);
		combination(list, N, L, cnt + 1, score, cal);

	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int T;
		int N, L;
		int[][] ingredient;
		
		T = Integer.parseInt(br.readLine());
		for(int tc = 1; tc<=T; tc++) {
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			L = Integer.parseInt(st.nextToken());
			
			pq = new PriorityQueue<Ingredient>(
					(a, b) -> Double.compare(b.rate, a.rate)
					);
			
			for(int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				pq.add(new Ingredient(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())));
			}
			
			max = Integer.MIN_VALUE;
			//Ingredient[] list = (Ingredient[])pq.toArray();
			List<Ingredient> list = new ArrayList<Ingredient>(pq);
			combination(list, N, L, 0, 0, 0);
			System.out.printf("#%d %d\n",tc, max);
			
		} // test-case 종료

	}

}