import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		int N = Integer.parseInt(br.readLine());
		
		Set<String> str = new HashSet<>(N);
		for(int i = 0; i < N; i++)
			str.add(br.readLine());

		Comparator<String> compareStr = new Comparator<String>() {
			@Override
			public int compare(String o1, String o2) {
				if(o1.length() == o2.length()) return o1.compareTo(o2);
				return o1.length() - o2.length();
			}
		};
		List<String> arr = new ArrayList<>(str);
		Collections.sort(arr, compareStr);
		
		for(String s : arr)
			sb.append(s + "\n");
		
		bw.write(sb.toString());
		bw.close();
	}
	
}