import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;
import java.util.TreeSet;

public class Main {

	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		
		int N = Integer.parseInt(br.readLine());
		
		TreeSet<Integer> treeSet = new TreeSet<>();
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i < N; ++i) treeSet.add(Integer.parseInt(st.nextToken()));

		for(int num : treeSet) sb.append(num + " ");
		
		bw.write(sb.toString());
		bw.flush();
		
		bw.close();
		br.close();
	}

}