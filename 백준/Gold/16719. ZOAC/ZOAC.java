import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.PriorityQueue;

public class Main {
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		String str = br.readLine();
		StringBuilder sb = new StringBuilder();
		
		int Len = str.length();
		
		PriorityQueue<String> pq = new PriorityQueue<>((p1, p2) -> p1.compareTo(p2));
		LinkedList<String> list = new LinkedList<>();
		for(int i = 0; i < Len; ++i) {
			list.addFirst(str);
			pq.clear();
			
			for(int j = 0, len = str.length(); j < len; ++j) {
				StringBuilder temp = new StringBuilder(str);
				pq.offer(temp.deleteCharAt(j).toString());
			}
			
			str = pq.poll();
					
		}
		
		for(String s : list) sb.append(s + "\n");
		bw.write(sb.toString());
		bw.close();
		
	}

}