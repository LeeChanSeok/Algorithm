import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Solution {
	static final int T = 10;
	static int N, M;
	static List<Integer> pw;
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		
		for(int tc = 1; tc <= T; tc++) {
			N = Integer.parseInt(br.readLine());
			st = new StringTokenizer(br.readLine());
			pw = new ArrayList<>(N);
			for(int i = 0; i < N; i++)
				pw.add(Integer.parseInt(st.nextToken()));
			
			M = Integer.parseInt(br.readLine());
			st = new StringTokenizer(br.readLine());
			for(int i = 0; i < M; i++) {
				char command = st.nextToken().charAt(0);
				int x = Integer.parseInt(st.nextToken());
				int y = Integer.parseInt(st.nextToken());
				
				if(command == 'I') {
					List<Integer> Add = new ArrayList<>(y);
					while(y-- > 0) Add.add(Integer.parseInt(st.nextToken()));
					pw.addAll(x, Add);
				}else {
					while(y-- > 0) pw.remove(x);
				}
			}
			
			sb.append("#" + tc);
			for(int i = 0; i < 10; i++) sb.append(" " + pw.get(i));
			sb.append("\n");
				
		}
		bw.write(sb.toString());
		bw.close();
	}

}