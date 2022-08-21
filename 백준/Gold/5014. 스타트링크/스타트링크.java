import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	static int F, S, G, U, D;
	static int min;
	static boolean[] visit;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuffer sb = new StringBuffer();
		
		F = Integer.parseInt(st.nextToken());
		S = Integer.parseInt(st.nextToken());
		G = Integer.parseInt(st.nextToken());
		U = Integer.parseInt(st.nextToken());
		D = Integer.parseInt(st.nextToken());
		
		visit = new boolean[F+1];
		
		min = Integer.MAX_VALUE;
		bfs();
		
		if (min == Integer.MAX_VALUE) sb.append("use the stairs");
		else sb.append(min);
		
		bw.write(sb.toString());
		bw.close();
	}
	private static void bfs() {
		Queue<Integer> q = new ArrayDeque<>();
		q.add(S);
		visit[S] = true;
		int move = 0;
		while(!q.isEmpty())
		{
			if(move >= min) break;			
			int qSize = q.size();			
			for(int i = 0; i < qSize; i++) {				
				int floor = q.poll();
				if(G == floor) {
					min = Math.min(min, move);
					break;
				}
				
				int nextU = floor + U;
				int nextD = floor - D;
				
				if(nextU <= F && !visit[nextU]) {
					visit[nextU] = true;
					q.add(nextU);
				}
				if(nextD > 0 && !visit[nextD]) {
					visit[nextD] = true;
					q.add(nextD);
				}
			}
			move++;
		}
	}

}