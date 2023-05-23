import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.List;
import java.util.StringTokenizer;

public class Solution {

	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb;
		
		StringTokenizer st;
		int T = 10;
		for(int tc = 1; tc <= T; ++tc) {
			sb = new StringBuilder();
			sb.append("#" + tc + " ");
			int N = Integer.parseInt(br.readLine());
			
			List<Integer> list = new LinkedList<>();
			
			st = new StringTokenizer(br.readLine());
			for(int i = 0; i < N; ++i) list.add(Integer.parseInt(st.nextToken()));
			
			int M = Integer.parseInt(br.readLine());
			st = new StringTokenizer(br.readLine());
			for(int i = 0; i < M; ++i) {
				char cmd = st.nextToken().charAt(0);
				
				if(cmd == 'I') {
					int x = Integer.parseInt(st.nextToken());
					int y = Integer.parseInt(st.nextToken());
					for(int j = 0, idx = x; j < y; ++j, ++idx) {
						list.add(idx, Integer.parseInt(st.nextToken()));
					}
				}else if(cmd == 'D') {
					int x = Integer.parseInt(st.nextToken());
					int y = Integer.parseInt(st.nextToken());
					for(int j = 0; j < y; ++j) list.remove(x);
				}else if(cmd == 'A') {
					int y = Integer.parseInt(st.nextToken());
					for(int j = 0; j < y; ++j) list.add(Integer.parseInt(st.nextToken()));
				}
			}
			
			int i = 0;
			for(int num : list) {
				sb.append(num + " ");
				if(++i == 10) break;
			}
			sb.append("\n");
			
			bw.write(sb.toString());
		}
		bw.close();

	}

}