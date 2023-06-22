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
		StringBuffer sb = new StringBuffer();
		StringTokenizer st;
		
		int N = Integer.parseInt(br.readLine());
		
		int[] A = new int[N];
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i < N; ++i) A[i] = Integer.parseInt(st.nextToken());
		
		int[] res = new int[N];
		
		int rank = 0;
		int num = 1;
		while(rank < N) {
			for(int i = 0; i < N; ++i) {
				if(A[i] == num) res[i] = rank++; 
			}
			++num;
		}
		
		for(int i = 0; i < N; ++i) {
			sb.append(res[i]).append(' ');
		}

		bw.write(sb.toString());
		bw.flush();
		
		bw.close();
		br.close();
	}

}