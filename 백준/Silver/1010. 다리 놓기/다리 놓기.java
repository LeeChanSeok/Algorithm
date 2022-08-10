import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int T = Integer.parseInt(br.readLine());
		
		List<Integer> up, down;
		for (int tc = 1; tc <= T; tc++) {
			st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			int M = Integer.parseInt(st.nextToken());
			
			up = new ArrayList<>();
			down = new ArrayList<>();
			
			if(N == M) {
				System.out.println(1);
				continue;
			}
			
			if(N > M/2) N = M - N;
			
			
			for(int i = 0; i <N ; i++) {
				up.add(M-i);
				down.add(N-i);
			}
			down.remove(down.size()-1);
			
			
			for(int i = 0; i < down.size(); i++) {				
				for(int j = 0; j < up.size(); j++) {
					if(up.get(j) % down.get(i) == 0)
					{
						up.add(up.get(j)/down.get(i));
						down.remove(i);
						up.remove(j);
						i--;
						break;
					}
					
				}
			}
			
			long res = 1;
			long total_up = 1;
			for(long i : up) {
				total_up *= i;
			}
			if(down.isEmpty())
				res = total_up;
			else {
				long total_down = 1;
				for(long i : down)
					total_down *= i;
				res = total_up/total_down;
			}
			System.out.println(res);
			
		}
	}
}