import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		int N = Integer.parseInt(br.readLine());
		
		int[][] data = new int[N][2];
		for(int i = 0; i < N; ++i) {
			st = new StringTokenizer(br.readLine());
			data[i][0] = Integer.parseInt(st.nextToken());
			data[i][1] = Integer.parseInt(st.nextToken());
		}
		
		int x, y, cnt;
		for(int i = 0; i < N; ++i) {
			x = data[i][0]; y = data[i][1];
			cnt = 1;
			for(int j = 0; j < N; ++j) {
				if(i == j) continue;
				
				if(data[j][0] > x && data[j][1] > y) ++cnt;
			}
			sb.append(cnt + "\n");
		}

		bw.write(sb.toString());
		bw.close();

	}

}