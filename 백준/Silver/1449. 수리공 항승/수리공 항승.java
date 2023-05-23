import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.TreeSet;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int L = Integer.parseInt(st.nextToken());
	
		TreeSet<Integer> broken = new TreeSet<>();
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i < N; ++i) {
			broken.add(Integer.parseInt(st.nextToken()));
		}
		int tape = 0;
		int idx = 1;
		int max = broken.last();
		while(idx <= max) {
			idx = broken.ceiling(idx);
			++tape;
			idx += L;
		}
		System.out.println(tape);
		
	}

}
