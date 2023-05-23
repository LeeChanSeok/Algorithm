import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	
	static final int MAX_SIZE = 100000;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuffer sb = new StringBuffer();
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		
		int time, cnt;
		
		if(N >= K) {
			time = N - K;
			sb.append(time + "\n");
			for(int i = N; i >=K; --i) sb.append(i + " ");
		}else {
			int[] paths = new int[MAX_SIZE * 2 + 1];
			int[] answer;
			Arrays.fill(paths, -1);
			paths[N] = N;
			
			cnt = time = solution(N, K, paths);
			sb.append(time+"\n");
			int pos = K;
			answer = new int[time+1];
			while(cnt >= 0) {
				answer[cnt--] = pos;
				pos = paths[pos];
			}

			for(int i = 0; i <= time; ++i) sb.append(answer[i] + " ");

		}
		
		bw.write(sb.toString());
		bw.flush();
		bw.close();
		br.close();
		
	}
	private static int solution(int N, int K, int[] paths) {
		
		int time = 0;
		Queue<Integer> q = new LinkedList<>();
		q.add(N);
		
		while(!q.isEmpty()) {
			
			int qSize = q.size();
			while(qSize-- > 0) {
				int cur = q.poll();
				
				if(cur == K) return time;

				// x2
				int pos = cur * 2;
				if(pos <= 2 * K && paths[pos] == -1) {
					paths[pos] = cur;
					q.offer(pos);
				}
				
				// +1
				pos = cur + 1;
				if(pos <= K && paths[pos] == -1) {
					paths[pos] = cur;
					q.offer(pos);
				}
				
				// -1
				pos = cur -1;
				if(pos >= 0 && paths[pos] == -1) {
					paths[pos] = cur;
					q.offer(pos);
				}
				
			}
			
			++time;
			
		}
		
		return 0;
	}

}
