import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		
		int N = Integer.parseInt(br.readLine());

		List<Integer> A = new LinkedList<>();
		List<Integer> B = new LinkedList<>();
		List<Integer> C = new LinkedList<>();
		
		Queue<int[]> q = new LinkedList<>();
		for(int i = 0; i < N; ++i) {
			st = new StringTokenizer(br.readLine());
			
			int cmd = Integer.parseInt(st.nextToken());
			if(cmd == 1) {
				int a = Integer.parseInt(st.nextToken());
				int b = Integer.parseInt(st.nextToken());
				q.offer(new int[] {a, b});
			} else {
				int[] cur = q.poll();
				int b = Integer.parseInt(st.nextToken());
				
				if(cur[1] == b) {
					A.add(cur[0]);
				} else {
					B.add(cur[0]);
				}
			}
		}
		
		while(!q.isEmpty()) {
			C.add(q.poll()[0]);
		}
		
		if(A.isEmpty()) sb.append("None\n");
		else {
			Collections.sort(A);
			for(int num : A) {
				sb.append(num + " ");
			}
			sb.append("\n");
		}
		
		if(B.isEmpty()) sb.append("None\n");
		else {
			Collections.sort(B);
			for(int num : B) {
				sb.append(num + " ");
			}
			sb.append("\n");
		}
		
		if(C.isEmpty()) sb.append("None\n");
		else {
			Collections.sort(C);
			for(int num : C) {
				sb.append(num + " ");
			}
			sb.append("\n");
		}

		System.out.println(sb);
	}

}