import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		
		int T = Integer.parseInt(br.readLine());
		for(int i = 1; i <= T; ++i) {
			st = new StringTokenizer(br.readLine());
			
			int a = Integer.parseInt(st.nextToken()) % 10;
			int b = Integer.parseInt(st.nextToken());
			
			int res = 10;
			if(a != 0) {
				
				boolean[] digit = new boolean[10];
				List<Integer> list = new LinkedList<>();
				
				int num = a;
				while(!digit[num]) {
					digit[num] = true;
					list.add(num);
					num = (num *a) % 10;
				}
				
				int size = list.size();
				int idx = ((b % size) + (size-1)) % size;
				res = list.get(idx);
				
			}
			
			sb.append(res).append('\n');
		}
				
		System.out.println(sb);
	}

}