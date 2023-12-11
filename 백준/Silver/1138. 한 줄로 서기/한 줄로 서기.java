import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	
	static int n;
	static int[] arr, order;
	static boolean[] used;
	
	public static void main(String[] args) throws Exception {
		input();
		pro();
	}

	private static void pro() {
		StringBuilder sb = new StringBuilder();
		
		recursive(0);
		
		for(int i = 0; i < n; ++i) sb.append(order[i]).append(" ");
		System.out.println(sb);
		
	}

	private static boolean recursive(int idx) {

		if(idx == n) return true;
		
		for(int i = 1; i <= n; ++i) {
			if(used[i]) continue;

			// 현재 위치(idx)에 i 번째 수를 채울 수 있는 지 확인
			if(isOk(idx, i)) {
				used[i] = true;
				order[idx] = i;
				
				if(recursive(idx+1)) return true;
				
				used[i] = false;	
			}
			
		}
		
		return false;
		
	}

	private static boolean isOk(int idx, int num) {

		int count = 0;
		for(int i = idx - 1; i >= 0; --i) {
			if(order[i] > num) ++count;
		}
		
		return (count == arr[num]);
	}

	private static void input() throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		n = Integer.parseInt(br.readLine());
		arr = new int[n+1];
		order = new int[n];
		used = new boolean[n+1];
		
		st = new StringTokenizer(br.readLine());
		for(int i = 1; i <= n; ++i) arr[i] = Integer.parseInt(st.nextToken());
	}

}