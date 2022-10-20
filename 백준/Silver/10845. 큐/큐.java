import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		
		int N = Integer.parseInt(br.readLine());
		int[] q = new int[10000];
		int front = 0, rear = -1, qSize = 0;
		
		String command;
		for(int i = 0; i < N; ++i) {
			st = new StringTokenizer(br.readLine());
			command = st.nextToken();
			
			if(command.equals("push")) {
				q[++rear] = Integer.parseInt(st.nextToken());
				++qSize;
			}else {
				if(command.charAt(0) == 'p') { // pop
					if(qSize == 0) sb.append("-1\n");
					else {
						sb.append(q[front++]+"\n");
						--qSize;
					}
				}else if(command.charAt(0) == 's') { // size
					sb.append(qSize+"\n");
				}else if(command.charAt(0) == 'e') { // empty
					if(qSize == 0) sb.append("1\n");
					else sb.append("0\n");
				}else if(command.charAt(0) == 'f') { // front
					if(qSize == 0) sb.append("-1\n");
					else sb.append(q[front]+"\n");
				}else if(command.charAt(0) == 'b') { // back
					if(qSize == 0) sb.append("-1\n");
					else sb.append(q[rear]+"\n");
				}				
			}
		}
		
		bw.write(sb.toString());
		bw.close();

	}

}