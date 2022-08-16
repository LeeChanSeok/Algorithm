import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();

		int M = Integer.parseInt(br.readLine());
		List<Integer> S = new ArrayList<>();
		List<Integer> all = new ArrayList<>();
		for(int i = 1; i <= 20; i++) all.add(i);
		String command;
		int value;
		
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			command = st.nextToken();

			if (command.equals("add")) {
				value = Integer.parseInt(st.nextToken());
				if(!S.contains(value)) S.add(value);
			} else if (command.equals("remove")) {
				value = Integer.parseInt(st.nextToken());
				if(S.contains(value)) S.remove(S.indexOf(value));
			} else if (command.equals("check")) {
				value = Integer.parseInt(st.nextToken());
				if(S.contains(value)) sb.append(1).append("\n");
				else sb.append(0).append("\n");
			} else if (command.equals("toggle")) {
				value = Integer.parseInt(st.nextToken());
				if(!S.contains(value)) S.add(value);
				else S.remove(S.indexOf(value));
			} else if (command.equals("all")) {
				//Collections.copy(all, S);
				S = new ArrayList<>(all);
			} else if (command.equals("empty")) {
				S.clear();
			}
		}
		System.out.println(sb.toString());
	}

}