import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	static class Point{ 
		int x, y;
	}
	
	static int[][] scores = {
			{0, 2, 4, 6, 8, 10, 12, 14, 16, 18, 20, 22, 24, 26, 28, 30, 32, 34, 36, 38, 40},
			{10, 13, 16, 19, 25, 30, 35, 40},
			{20, 22, 24, 25, 30, 35, 40},
			{30, 28, 27, 26, 25, 30, 35, 40},
			{25, 30, 35, 40}
	};
	
	static int N = 4, M = 10, maxScore;
	static Point[] points;
	static int[] moves;
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		moves = new int[M];
		for(int i = 0; i < M; ++i)
			moves[i] = Integer.parseInt(st.nextToken());
				
		points = new Point[N];
		for(int i = 0; i < N; ++i)
			points[i] = new Point();
		
		maxScore = 0;
		dfs(0, 0);
		System.out.println(maxScore);
	}
	private static void dfs(int turn, int totalScore) {

		if(turn == M || isAllFinish()) {
			maxScore = Math.max(maxScore, totalScore);
			return;
		}
		
		Point cur;
		int next, score;
		int x, y;
		for(int i = 0; i < N; ++i) {
			
			cur = points[i];
			if(cur.x == -1) continue;
			
			x = cur.x;	y = cur.y;
			next = cur.y + moves[turn];
			
			// 도착지점에 도착하는 경우
			if(next >= scores[cur.x].length) {
				cur.x = -1;
				dfs(turn + 1, totalScore);
				cur.x = x;
				continue;
			}
			
			score = scores[cur.x][next];
			// 방향을 바꾸는 경우
			if(cur.x == 0 && score % 10 == 0 && score != 40) {
				cur.x = score/10;
				cur.y = 0;
			}
			else if(score == 40) {
				cur.x = 0;
				cur.y = 20;
			}
			else if((cur.x != 0 && cur.x != 4) && (next >= (3 + (cur.x & 1)))) {
				cur.y = next - (3 + (cur.x & 1));
				cur.x = 4;
			}
			// 일반 진행
			else {
				cur.y = next;
			}
			
			if(!isDuplicate(cur.x, cur.y, i)) {
				dfs(turn+1, totalScore + score);
			}
			
			cur.x = x;
			cur.y = y;
			
		}
		
	}
	
	private static boolean isAllFinish() {
		for(int i = 0; i < N; ++i)
			if(points[i].x != -1) return false;
		
		return true;
	}
	
	private static boolean isDuplicate(int x, int y, int idx) {

		for(int i = 0; i < N; ++i) {
			if(i != idx && points[i].x == x && points[i].y == y) return true;
		}
		return false;
	}

}