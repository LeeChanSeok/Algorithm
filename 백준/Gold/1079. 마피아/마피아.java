import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	static int n, x, ans;
	static int[] arr;
	static boolean[] die;
	static int[][] R;
	
	public static void main(String[] args) throws Exception{
		input();
		pro();
	}

	private static void pro() {

		ans = 0;
		dfs(n, 0);
		System.out.println(ans);
		
	}

	private static void dfs(int people, int night) {
		
		ans = Math.max(ans, night);
		
		if(die[x]) return;
		if(people == 1) return;
		
		// 1. 밤인 경우
		if((people & 1) == 0) {
			for(int i = 0; i < n; ++i) {
				if(die[i] || i == x) continue;
				
				die[i] = true;
				for(int j = 0; j < n; ++j) {
					arr[j] += R[i][j];
				}
				dfs(people - 1, night + 1);
				die[i] = false;
				for(int j = 0; j < n; ++j) {
					arr[j] -= R[i][j];
				}
			}
		}
		// 2. 낮인 경우
		else {
			int idx = 0;
			int num = 0;
			for(int i = 0; i < n; ++i) {
				if(!die[i] && arr[i] > num) {
					idx = i;
					num = arr[i];
				}
			}
			die[idx] = true;
			dfs(people - 1, night);
			die[idx] = false;
		}
		
		
	}

	private static void input() throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		n = Integer.parseInt(br.readLine());
		
		arr = new int[n];
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i < n; ++i) arr[i] = Integer.parseInt(st.nextToken());
		
		R = new int[n][n];
		for(int i = 0; i < n; ++i) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < n; ++j) {
				R[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		x = Integer.parseInt(br.readLine());
		
		die = new boolean[n];
	}

}