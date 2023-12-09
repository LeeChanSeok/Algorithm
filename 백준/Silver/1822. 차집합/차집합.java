import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int na = Integer.parseInt(st.nextToken());
		int nb = Integer.parseInt(st.nextToken());
		
		int[] A = new int[na];
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i < na; ++i) {
			A[i] = Integer.parseInt(st.nextToken());
		}
		
		int[] B = new int[nb];
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i < nb; ++i) {
			B[i] = Integer.parseInt(st.nextToken());
		}

		Arrays.sort(A);
		Arrays.sort(B);
		
		List<Integer> list = new ArrayList<>();
		int i = 0, j = 0;
		
		while(i < na && j < nb) {
			
			if(A[i] == B[j]) {
				list.add(A[i]);
				++i; ++j;
			}else if(A[i] > B[j]) {
				++j;
			}else if(A[i] < B[j]) {
				++i;
			}
		}
		
		if(list.size() == na) System.out.println("0");
		else {
			sb.append(na - list.size()).append('\n');
			
			list.add(Integer.MAX_VALUE);
			int idx = 0;
			for(int k = 0; k < na; ++k) {
				if(A[k] == list.get(idx)) {
					++idx;
				}else {
					sb.append(A[k]).append(" ");
				}
			}
		}
		
		System.out.println(sb);
		
	}

}