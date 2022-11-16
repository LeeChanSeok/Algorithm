import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		int N = Integer.parseInt(br.readLine());
		
		ArrayDeque<Integer> deque = new ArrayDeque<>(N);
		
		String command;
		int num;
		while(N-- > 0) {
			st = new StringTokenizer(br.readLine());
			command = st.nextToken();
			
			if(command.equals("push_front")) {
				num = Integer.parseInt(st.nextToken());
				deque.addFirst(num);
			}else if(command.equals("push_back")) {
				num = Integer.parseInt(st.nextToken());
				deque.add(num);
			}
			else if(command.equals("pop_front")) {
				if(deque.size()== 0) sb.append("-1");
				else sb.append(deque.pollFirst());
				sb.append("\n");
			}else if(command.equals("pop_back")) {
				if(deque.size()== 0) sb.append("-1");
				else sb.append(deque.pollLast());
				sb.append("\n");
			}
			else if(command.equals("size")) {
				sb.append(deque.size()).append("\n");
			}else if(command.equals("empty")) {
				if(deque.isEmpty()) sb.append("1").append("\n");
				else sb.append("0").append("\n");
			}else if(command.equals("front")) {
				if(deque.size()== 0) sb.append("-1");
				else sb.append(deque.getFirst());
				sb.append("\n");
			}else if(command.equals("back")) {
				if(deque.size() == 0) sb.append("-1");
				else sb.append(deque.getLast());
				sb.append("\n");
			}
		}
		
		bw.write(sb.toString());
		bw.close();
	
	}

}