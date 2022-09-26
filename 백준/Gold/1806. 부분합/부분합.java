import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		int num;
		int sum = 0;
		int length = 0;
		int min = Integer.MAX_VALUE; 
		st = new StringTokenizer(br.readLine());
		Queue<Integer> q = new LinkedList<>();
		
		for(int i = 0; i < N; i++) {
			num = Integer.parseInt(st.nextToken());
			sum += num;
			q.offer(num);
			++length;
			while(sum >=M) {
				min = Math.min(min, length);
				sum -= q.poll();
				--length;
			}
		}
		if(min == Integer.MAX_VALUE) System.out.println(0);
		else System.out.println(min);

	}

}