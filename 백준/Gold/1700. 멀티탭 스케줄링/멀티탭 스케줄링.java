import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int n, k;
	static boolean[] tap;
	static int[] num;
	
	public static void main(String[] args) throws Exception{
		input();
		pro();
	}

	private static void pro() {
		
		int ans = 0;
		int select = 0;
		for(int i = 1; i <= k; ++i) {
			int plug = num[i];
			
			if(tap[plug]) continue;
			else if(select < n) {
				++select;
				tap[plug] = true;
			}
			else {
				int pick = pickPlug(i);
				tap[pick] = false;
				tap[plug] = true;
				++ans;
			}
		}
		System.out.println(ans);
	}

	private static int pickPlug(int idx) {

		int[] order = new int[k+1];
		for(int i = k, x = 1; i > idx; --i, ++x) {
			order[num[i]] = x;
		}
		
		int[] res = {0, 1000};
		for(int i = 1; i<= k; ++i) {
			if(!tap[i]) continue;
			if(order[i] < res[1]) res = new int[] {i, order[i]};
		}
		
		return res[0];
	}

	private static void input() throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
	
		n = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());
		
		tap = new boolean[k + 1];
		num = new int[k + 1];
		
		st = new StringTokenizer(br.readLine());
		for(int i = 1; i <= k; ++i) {
			num[i] = Integer.parseInt(st.nextToken());
		}
		
	}
}