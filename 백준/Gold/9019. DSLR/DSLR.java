import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;
import java.util.StringTokenizer;

public class Main {

	static class Info{
		int reg;
		String command;
		public Info(int reg, String command) {
			super();
			this.reg = reg;
			this.command = command;
		}
		
	}
	
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		
		int T = Integer.parseInt(br.readLine());
		int start, end, qSize;
		
		while(T-- > 0) {
			
			st = new StringTokenizer(br.readLine());
			start = Integer.parseInt(st.nextToken());
			end = Integer.parseInt(st.nextToken());
			
			sb.append(solution(start, end)).append("\n");
			
		}
		
		bw.write(sb.toString());
		bw.close();

	}

	private static String solution(int start, int end) {

		Set<Integer> visit = new HashSet<>();
		visit.add(start);
		
		Queue<Info> q = new LinkedList<>();
		q.add(new Info(start, ""));
		
		final int maxValue = 10000;
		
		int register, qSize;
		int d1, d4;
		String command;
		Info cur;
		while(!q.isEmpty()) {
			qSize = q.size();
			while(qSize-- > 0) {
				cur = q.poll();
				
				register = cur.reg;
				command = cur.command;
				if(register == end) return cur.command;
				
				// 1. D
				register = (cur.reg<<1) % maxValue;
				if(!visit.contains(register)) {
					q.add(new Info(register, command + "D"));
					visit.add(register);
				}
				
				// 2. S
				register = (cur.reg == 0) ? maxValue - 1 : cur.reg-1;
				if(!visit.contains(register)) {
					q.add(new Info(register, command + "S"));
					visit.add(register);
				}				
				
				// 3. L				
				d1 = (cur.reg / 1000);
				register = (d1 + (cur.reg * 10)) % maxValue;
				if(!visit.contains(register)) {
					q.add(new Info(register, command + "L"));
					visit.add(register);
				}				
				
				// 4. R
				d4 = cur.reg % 10;
				register = (d4 * 1000 + (cur.reg / 10));
				if(!visit.contains(register)) {
					q.add(new Info(register, command + "R"));
					visit.add(register);
				}			
			}
		}
		
		return null;
	}

}