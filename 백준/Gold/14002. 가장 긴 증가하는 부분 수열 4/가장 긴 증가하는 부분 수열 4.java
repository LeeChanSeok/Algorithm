import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
	
	static int n;
	static int[] arr, D;
	 
	public static void main(String[] args) throws Exception{
		input();
		pro();
	}

	private static void pro() {
		StringBuilder sb = new StringBuilder();
		Stack<Integer> stack = new Stack<>();
		
		int max = 1;
		for(int i = 1; i <= n; ++i) {
			D[i] = 1;
			for(int j = 1; j < i; ++j) {
				if(arr[j] < arr[i]) {
					D[i] = Math.max(D[i], D[j] + 1);
					max = Math.max(max, D[i]);
				}
			}
		}
		
		sb.append(max).append('\n');
		for(int i = n; i > 0; --i) {
			if(D[i] == max) {
				stack.add(arr[i]);
				--max;
			}
		}
		while(!stack.isEmpty()) sb.append(stack.pop()).append(' ');
		
		System.out.println(sb);
		
	}

	private static void input() throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		n = Integer.parseInt(st.nextToken());
		
		D = new int[n+1];
		arr = new int[n+1];
		st = new StringTokenizer(br.readLine());
		for(int i = 1; i <= n; ++i) arr[i] = Integer.parseInt(st.nextToken());
		
	}
	
}