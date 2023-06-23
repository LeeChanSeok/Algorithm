import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int N = Integer.parseInt(br.readLine());
		
		List<Integer>[] points = new List[N+1];
		for(int i = 1; i <=N; ++i) points[i] = new ArrayList<>();
		
		int x, y;
		for(int i = 0; i < N; ++i) {
			st = new StringTokenizer(br.readLine());
			x = Integer.parseInt(st.nextToken());
			y = Integer.parseInt(st.nextToken());
			points[y].add(x);
			
		}
		
		int len;
		long answer = 0;
		int prev;
		for(int i = 1; i <= N; ++i) {
			Collections.sort(points[i]);
			
			len = points[i].size();
			if(len == 0) continue;
			
			answer += (points[i].get(1) - points[i].get(0)) + (points[i].get(len-1) - points[i].get(len-2));
			prev = (points[i].get(1) - points[i].get(0));
			for(int j = 1; j < len - 1; ++j) {
				answer += Math.min(prev, (points[i].get(j+1) - points[i].get(j)));
				prev = (points[i].get(j+1) - points[i].get(j));
			}

		}
		
		System.out.println(answer);
	}

}
