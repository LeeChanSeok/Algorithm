import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
				
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		
		LinkedList<Integer> list = new LinkedList<>();
		List<Integer> arrlist = new ArrayList<>(N);
		
		for(int i = 1; i <= N; ++i)
			list.add(i);
		
		Iterator<Integer> iter;
		int size = N;
		int cnt = 0;
		int num;
		cnt = 0;			
		while(size != 0) {
			iter = list.iterator();
			while(iter.hasNext()) {
				num = iter.next();
				if(++cnt == K) {
					cnt = 0;
					--size;					
					arrlist.add(num);
					iter.remove();
				}

			}
			
		}
		
		sb.append("<");
		for(int i = 0; i < N - 1; ++i) sb.append(arrlist.get(i) + ", ");
		sb.append(arrlist.get(N-1) + ">");
        
		bw.write(sb.toString());
		bw.close();
	}

}