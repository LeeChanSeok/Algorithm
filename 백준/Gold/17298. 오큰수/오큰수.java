import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
	
	static class Data{
		int idx;
		int num;
		
		public Data(int idx, int num) {
			super();
			this.idx = idx;
			this.num = num;
		}
		
	}
	
	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		
		int N = Integer.parseInt(br.readLine());
		
		st = new StringTokenizer(br.readLine());
		Data[] datas = new Data[N+1];
		for(int i = 1; i <= N; ++i) datas[i] = new Data(i, Integer.parseInt(st.nextToken()));
		
		
		int[] answer = new int[N+1];
		Arrays.fill(answer, -1);

		Stack<Data> stack = new Stack<>();
		stack.add(new Data(0, 0));
		for(int i = 1; i <= N; ++i) {
			Data data = datas[i];
			
			while(!stack.empty() && stack.peek().num < data.num) {
				answer[stack.pop().idx] = data.num;
			}
			stack.add(data);
		}
		
		for(int i = 1; i <= N; ++i) sb.append(answer[i] + " ");
		
		bw.write(sb.toString());
		bw.flush();
		
		bw.close();
		br.close();
		
	}

}