import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
	static int answer;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		List<String> commands = new ArrayList<>();

		while(true) {
			String command = br.readLine();
			if (command.compareTo("QUIT") == 0) break;
			
			do{
				commands.add(command);
				if (command.compareTo("END") == 0) break;
				command = br.readLine();
			}while(true);
	
			int T = Integer.parseInt(br.readLine());
	
			for (int tc = 1; tc <= T; tc++) {
				int N = Integer.parseInt(br.readLine());
				
				if(!solution(commands, N)) sb.append("ERROR\n");
				else sb.append(answer + "\n");
			}
			br.readLine();
			sb.append("\n");
			commands.clear();
		}
		bw.write(sb.toString());
		bw.close();
		
	}

	private static boolean solution(List<String> commands, int N) {
		StringTokenizer st;
		final int Limit = (int)Math.pow(10, 9);
		int maxSize = 1000;
		int[] stack = new int[maxSize];
		answer = 0;
		int s = maxSize - 1;
		stack[s] = N;
		for (String command : commands) {
			//1. NUM X: X를 스택의 가장 위에 저장한다. (0 ≤ X ≤ 10^9)
			st = new StringTokenizer(command);
			command = st.nextToken();
			if (command.compareTo("END") == 0) break;
			else if(command.compareTo("NUM") == 0) {
				int X = Integer.parseInt(st.nextToken());
				stack[--s] = X;
			}
			//2. POP: 스택 가장 위의 숫자를 제거한다.
			else if(command.compareTo("POP") == 0) {
				if(s == maxSize) return false; // ERROR
				s++;
			}
			//3. INV: 첫 번째 수의 부호를 바꾼다. (42 -> -42)
			else if(command.compareTo("INV") == 0) {
				stack[s] *= -1;
			}
			
			//4. DUP: 첫 번째 숫자를 하나 더 스택의 가장 위에 저장한다.
			else if(command.compareTo("DUP") == 0) {
				stack[s-1] = stack[s--];
			}
			else {
				if(s == maxSize-1) return false; // ERROR
				
				//5. SWP: 첫 번째 숫자와 두 번째 숫자의 위치를 서로 바꾼다.
				if(command.compareTo("SWP") == 0) {
					int temp = stack[s];
					stack[s] = stack[s+1];
					stack[s+1] = temp;
				}
				//6. ADD: 첫 번째 숫자와 두 번째 숫자를 더한다.
				else if(command.compareTo("ADD") == 0) {
					int res = stack[s+1] + stack[s];
					if (Math.abs(res) > Limit) return false; //ERROR
					stack[s+1] = res; 
					s++;
				}
				//7. SUB: 첫 번째 숫자와 두 번째 숫자를 뺀다. (두 번째 - 첫 번째)
				else if(command.compareTo("SUB") == 0) {
					int res = stack[s+1] - stack[s];
					if (Math.abs(res) > Limit) return false; //ERROR
					stack[s+1] = res;
					s++;
				}
				//8. MUL: 첫 번째 숫자와 두 번째 숫자를 곱한다.
				else if(command.compareTo("MUL") == 0) {
					long res = (long)stack[s+1] * (long)stack[s]; // 오버플로우 처리
					if (Math.abs(res) > Limit) return false; //ERROR
					stack[s+1] = (int)res; 
					s++;
				}
				else {
					if(stack[s] == 0) return false; // ERROR
					
					//9. DIV: 첫 번째 숫자로 두 번째 숫자를 나눈 몫을 저장한다. 두 번째 숫자가 피제수, 첫 번째 숫자가 제수이다.
					if(command.compareTo("DIV") == 0) {
						
						int res = stack[s+1] / stack[s]; // 오버플로우 처리
						if (Math.abs(res) > Limit) return false; //ERROR
						stack[s+1] = res; 
						s++;
					}
					//10. MOD: 첫 번째 숫자로 두 번째 숫자를 나눈 나머지를 저장한다. 두 번째 숫자가 피제수, 첫 번째 숫자가 제수이다.
					else if(command.compareTo("MOD") == 0) {
						int res = stack[s+1] % stack[s]; // 오버플로우 처리
						if (Math.abs(res) > Limit) return false; //ERROR
						stack[s+1] = res; 
						s++;
					}
				}
			}

		}
		
		if(s != maxSize-1) return false;
		else{
			answer = stack[s];
		}
		return true;
		
	}

}