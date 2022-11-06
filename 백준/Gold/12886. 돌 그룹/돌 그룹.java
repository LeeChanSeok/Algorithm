import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int A, B, C;

		A = Integer.parseInt(st.nextToken());
		B = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		
		int[] stoneGroup = {A, B, C};
		Arrays.sort(stoneGroup);
		
		System.out.println(solution(stoneGroup));

	}

	static Set<Integer> visit;
	
	private static char solution(int[] stoneGroup) {
		visit = new HashSet<>();
		
		int stone = stoneGroup[0] * 1_000_000 +  stoneGroup[1] * 1_000 + stoneGroup[2];
		visit.add(stone);

		Queue<Integer> q = new LinkedList<>();
		q.offer(stone);
		int cur, A, B, C;
		
		while (!q.isEmpty()) {
			cur = q.poll();

			A = cur / 1_000_000;
			cur %= 1_000_000; 
			B = cur / 1_000;
			cur %= 1_000;
			C = cur;

			if(A == B && B == C) return '1';
			
			doGroup(A, B, C, q);
			doGroup(A, C, B, q);
			doGroup(B, C, A, q);

		}

		return '0';
	}

	private static void doGroup(int n1, int n2, int n3, Queue<Integer> q) {
		
		if(n1 == n2) return;
		
		if(n1 < n2) {
			n2 -= n1;
			n1 += n1;
		}else {
			n1 -= n2;
			n2 += n2;
		}
		
		int[] stoneGroup = {n1, n2, n3};
		Arrays.sort(stoneGroup);
		
		int stone = stoneGroup[0] * 1_000_000 +  stoneGroup[1] * 1_000 + stoneGroup[2];
		if(!visit.contains(stone)) {
			visit.add(stone);
			q.offer(stone);
		}
		
	}

}