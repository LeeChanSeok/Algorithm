import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;
import java.util.StringTokenizer;

public class Main {
	
	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int S = Integer.parseInt(st.nextToken());
		
		int[] arr = new int[N + 1];
		st = new StringTokenizer(br.readLine());
		for(int i = 1; i<= N; ++i) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		sb.append(br.readLine()).reverse();
		System.out.println(sb);
		
	}


}