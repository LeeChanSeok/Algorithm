import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		int[] trains = new int[N+1];
		final int DELTA = (1<<20) -1;
		int command, train, idx;
		for(int i = 0; i < M; ++i) {
			st = new StringTokenizer(br.readLine());
		
			command = Integer.parseInt(st.nextToken());
			train = Integer.parseInt(st.nextToken());
			trains[train] &= DELTA;
			
			if(command == 1) {
				idx = Integer.parseInt(st.nextToken());
				trains[train] |= (1 << (idx-1));
			}else if(command == 2) {
				idx = Integer.parseInt(st.nextToken());
				trains[train] &= (Integer.MAX_VALUE ^ ( 1 << (idx -1)));
			}else if(command == 3) {
				trains[train] = trains[train] << 1;
				
			}else if(command == 4) {
				trains[train] = trains[train] >> 1;
			}
			
			
		}
		
		int answer = 0;
		Set<Integer> arrive = new HashSet<>();
		for(int i = 1; i <= N; ++i) {
			train = trains[i] &= DELTA;
			if(!arrive.contains(train)) {
				++answer;
				arrive.add(train);
			}
		}
		
		System.out.println(answer);
	
	}

}
