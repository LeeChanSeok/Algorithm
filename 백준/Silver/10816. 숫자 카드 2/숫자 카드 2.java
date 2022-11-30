import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw  = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		
		int N = Integer.parseInt(br.readLine());
		Map<Integer, Integer> cards = new HashMap<>();
		
		int num;
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i < N ; ++i) {
			num = Integer.parseInt(st.nextToken());
			cards.put(num, cards.getOrDefault(num, 0)+1);
		}
		
		int M = Integer.parseInt(br.readLine());
		st = new StringTokenizer(br.readLine());
		for(int i = 0 ; i < M; ++i) {
			num = Integer.parseInt(st.nextToken());
			sb.append(cards.getOrDefault(num, 0) + " ");
		}
		
		bw.write(sb.toString());
		bw.close();

	}

}