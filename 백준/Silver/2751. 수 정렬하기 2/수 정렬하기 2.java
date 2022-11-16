import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.PriorityQueue;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		
		int N = Integer.parseInt(br.readLine());
		
		PriorityQueue<Integer> mPQ = new PriorityQueue<>();
		PriorityQueue<Integer> pPQ = new PriorityQueue<>();
		
		int num;
		for(int i = 0; i < N; ++i) {
			num = Integer.parseInt(br.readLine());
			if(num < 0) mPQ.add(num);
			else pPQ.add(num);
		}
		
		while(!mPQ.isEmpty()) sb.append(mPQ.poll()).append("\n");
		while(!pPQ.isEmpty()) sb.append(pPQ.poll()).append("\n");
		
		bw.write(sb.toString());
		bw.close();

	}

}