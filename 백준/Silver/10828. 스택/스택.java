import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {

	static class Stack{
		int N, size;
		int[] stack;
		
		public Stack(int N) {
			super();
			this.N = N;
			stack = new int[N];
		}
		
		public void push(int num) {
			stack[size++] = num;
		}
		
		public int pop() {
			if(size == 0) return -1;
			return stack[--size];
		}
		
		public int size() {
			return size;
		}
		
		public int empty() {
			if(size == 0) return 1;
			return 0;
		}
		
		public int top() {
			if(size == 0) return -1;
			return stack[size-1];
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		int N = Integer.parseInt(br.readLine());
		
		Stack stack = new Stack(N);
		String command;
		int num;
		while(N-- > 0) {
			st = new StringTokenizer(br.readLine());
			command = st.nextToken();
			
			if(command.equals("push")) {
				num = Integer.parseInt(st.nextToken());
				stack.push(num);
			}else if(command.equals("pop")) {
				sb.append(stack.pop()).append("\n");
			}else if(command.equals("size")) {
				sb.append(stack.size()).append("\n");
			}else if(command.equals("empty")) {
				sb.append(stack.empty()).append("\n");
			}else if(command.equals("top")) {
				sb.append(stack.top()).append("\n");
			}
		}
		
		bw.write(sb.toString());
		bw.close();
	
	}

}