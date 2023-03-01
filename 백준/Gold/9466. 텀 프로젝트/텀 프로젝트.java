import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		List<Integer> list = new LinkedList<>();
		int num, cnt;
		int T = Integer.parseInt(br.readLine());
		for(int tc = 1; tc <= T; ++tc) {
			int N = Integer.parseInt(br.readLine());
			
			int team = 0;
			int[] want = new int[N+1];
			boolean[] isCheck = new boolean[N+1];
			st = new StringTokenizer(br.readLine());
			for(int i = 1; i <= N; ++i) {
				num = Integer.parseInt(st.nextToken());
				want[i] = num;
				if(i == num) {
					isCheck[i] = true;
					++team;
				}
			}
			
			for(int i = 1; i <= N; ++i) {
				if(isCheck[i]) continue;
				
				num = i;
				list.clear();
				do {
					list.add(num);
					isCheck[num] = true;
					num = want[num];
				}while(num != i && !isCheck[num]);
				
				cnt = 0;
				if(list.contains(num)) {
					for(int n : list) {
						if( n == num ) break;
						++cnt;
					}
					team += (list.size()-cnt);
				}
				
			}
			
			System.out.println(N-team);
		}

	}

}