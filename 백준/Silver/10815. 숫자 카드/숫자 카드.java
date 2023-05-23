import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;

		int N = Integer.parseInt(br.readLine());
		Set<Integer> numbers = new HashSet<>();
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i < N; ++i) numbers.add(Integer.parseInt(st.nextToken()));
		
		int M = Integer.parseInt(br.readLine());
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i < M; ++i) {
			if(numbers.contains(Integer.parseInt(st.nextToken()))) sb.append("1 ");
			else sb.append("0 ");
		}
		
		
		bw.write(sb.toString());
		bw.flush();
		
		bw.close();
		br.close();
	}

}