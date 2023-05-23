import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {

	static int N, S;
	static int[] cows, subSum;
	
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		int Q = Integer.parseInt(st.nextToken());
		
		cows = new int[N];
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i < N; ++i) cows[i] = Integer.parseInt(st.nextToken());

		subSum = new int[N];
		init(N);
		
		int idx;
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i < Q; ++i) {
			idx = Integer.parseInt(st.nextToken())-1;
			cows[idx] *= -1;
			
			update_S((idx+N-3)%N);
			sb.append(S+"\n");
		}
		
		bw.write(sb.toString());
		bw.flush();
		
		bw.close();
		br.close();
		
	}

	private static void init(int N) {

		int idx = 0;
		int sum = cows[idx]*cows[(idx+1)%N]*cows[(idx+2)%N]*cows[(idx+3)%N];
		subSum[idx] = sum;
		S = sum;
		
		for(int i = 0; i < N-1; ++i) {
			sum /= cows[idx];
			sum *= cows[(idx+4)%N];
			subSum[++idx] = sum;
			S += sum;
		}
		
	}

	private static void update_S(int idx) {
		
		for(int i = 0; i < 4; ++i) {
			int j = (idx+i) % N;
			
			S -= subSum[j];
			subSum[j] *= -1;
			S += subSum[j];
		}
	}

}