import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int L = Integer.parseInt(st.nextToken());
		int N = Integer.parseInt(st.nextToken());
		int T = Integer.parseInt(st.nextToken());

		Set<Integer>[] set = new Set[L + 1];
		for(int i = 0; i <= L; ++i) {
			set[i] = new HashSet<Integer>();
		}
		
		int[][] arr = new int[N][2];
		for (int i = 0; i < N; ++i) {
			st = new StringTokenizer(br.readLine());
			arr[i][0] = Integer.parseInt(st.nextToken());
			arr[i][1] = (st.nextToken().charAt(0) == 'R') ? 1 : -1;
			
			set[arr[i][0]].add(i);
		}

		
		int cnt = 0;
		while (T-- > 0) {
			// move
			for(int i = 0; i < N; ++i) {
				int pos = arr[i][0];
				int dir = arr[i][1];
 
				int next = pos + dir;
				if(next == L || next == 0) {
					dir *= -1;
				}
				arr[i][0] = next;
				arr[i][1] = dir;
				set[pos].remove(i);
				set[next].add(i);
				
				
			}
			
			//충돌확인
			for(int i = 1; i < L; ++i) {
				if(set[i].size() == 2) {
					for(int idx : set[i]) {
						arr[idx][1] *= -1;
					}
					++cnt;
				}
			}
			
		}

		System.out.println(cnt);
	}

}