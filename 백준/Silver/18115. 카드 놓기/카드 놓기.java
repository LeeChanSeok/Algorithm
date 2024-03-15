import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Collections;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		
		int n = Integer.parseInt(br.readLine());
		
		Deque<Integer> deque = new ArrayDeque<>();
		for(int i = 1; i <= n; ++i) {
			deque.offer(i);
		}
		
		List<int[]> list = new LinkedList<>();
		st = new StringTokenizer(br.readLine());
		for(int i = n; i >= 1; --i) {
			int cmd = Integer.parseInt(st.nextToken());
			
			int num;
			if(cmd == 1) {
				num = deque.pollFirst();
			}else if(cmd == 2) {
				int temp = deque.pollFirst();
				num = deque.pollFirst();
				deque.offerFirst(temp);
			} else {
				num = deque.pollLast();
			}
			
			list.add(new int[] {num, i});
		}
		
		Collections.sort(list, (a1, a2)-> a1[0] - a2[0]);
		for(int[] card : list) {
			sb.append(card[1] + " ");
		}

		System.out.println(sb);
	}

}