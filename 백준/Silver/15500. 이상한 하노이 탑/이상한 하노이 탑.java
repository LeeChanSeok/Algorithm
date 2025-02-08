import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;

		int N = Integer.parseInt(br.readLine());

		int[] arr = new int[N + 1];
		int target = N;
		
		Stack<Integer>[] stack = new Stack[2];
		stack[0] = new Stack<Integer>();
		stack[1] = new Stack<Integer>();
		
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i < N; ++i) {
			stack[0].push(Integer.parseInt(st.nextToken()));
		}
		
		int ans = 0;
		while(target != 0) {
			int from = arr[target];
			int to = from^1;
			
			while(stack[from].peek() != target) {
				int num = stack[from].pop();
				stack[to].push(num);
				arr[num] = to ;
				
				sb.append((from + 1) + " " + (to + 1) + "\n");
				++ans;
			}
			
			stack[from].pop();
			sb.append((from + 1) + " " + 3 + "\n");
			++ans;
			--target;
		}
		
		
		System.out.println(ans);
		bw.write(sb.toString());
		bw.flush();

	}

}