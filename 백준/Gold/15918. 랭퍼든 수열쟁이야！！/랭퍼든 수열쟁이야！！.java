import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	static int n, x, y;
	static boolean[] used;
	static int[] arr;
	static int answer;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
	
		n = Integer.parseInt(st.nextToken());
		x = Integer.parseInt(st.nextToken());
		y = Integer.parseInt(st.nextToken());
		
		used = new boolean[n+1];
		arr = new int[n*2 + 1];
		
		int diff = y - x - 1;
		arr[x] = arr[y] = diff;
		used[diff] = true;
		
		recursive(1);
		System.out.println(answer);
	}

	private static void recursive(int idx) {
		
		if(idx == 2*n + 1) {
			++answer;
			return;
		}
		
		if(arr[idx] != 0) {
			recursive(idx+1);
		}else {
			
			for(int i = 1; i <= n; ++i) {
				if(used[i]) continue;
				
				int next = idx + i + 1;
				if(next > 2*n  || arr[next] != 0) continue;
				
				arr[idx] = arr[next] = i;
				used[i] = true;
				recursive(idx+1);
				arr[idx] = arr[next] = 0;
				used[i] = false;
			}
			
		}
		
	}	
}
