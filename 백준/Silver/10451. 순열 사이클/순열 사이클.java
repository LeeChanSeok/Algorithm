import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int T = Integer.parseInt(br.readLine());
		for(int tc = 1; tc <= T; ++tc) {
			int N = Integer.parseInt(br.readLine());
			int[] arr = new int[N+1];
			boolean[] visit = new boolean[N+1];
			
			st = new StringTokenizer(br.readLine());
			for(int i = 1; i <= N; ++i) arr[i] = Integer.parseInt(st.nextToken());
			
			int answer = 0;
			for(int i = 1; i <= N; ++i) {
				int num = i;
				
				if(visit[i]) continue;
				
				do {
					visit[num] = true;
					num = arr[num];
				}while( i != num && !visit[num]);
				
				if(i == num) ++answer;
			}
			System.out.println(answer);
		}

	}

}