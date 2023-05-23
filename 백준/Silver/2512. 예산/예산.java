import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static int MAX = 1000000000;
	static Integer[] request;
	static int N, budget;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		N = Integer.parseInt(br.readLine());
		request = new Integer[N];
		st = new StringTokenizer(br.readLine());
		int total = 0;
		for(int i = 0; i < N; ++i) {
			request[i] = Integer.parseInt(st.nextToken());
			total += request[i];
		}
		Arrays.sort(request);
		
		budget = Integer.parseInt(br.readLine());
		int res = 0;
		if(total <= budget) {
			res = request[N-1];
		}else {
			int l = 0, r = MAX;
			int mid;
			while(l <= r) {
				mid = (l + r) / 2;
				
				if(calc(mid) <= budget) {
					l = mid + 1;
					res = mid;
				}else {
					r = mid - 1;
				}
			}
		}
		
		System.out.println(res);
	}

	private static int calc(int pivot) {
		
		int total = 0;
		
		for(int i = 0; i < N; ++i) {
			if(request[i] < pivot) {
				total += Math.min(request[i], pivot);
			}else {
				total += (pivot) * (N - i);
				break;
			}
		}
		
		return total;
	}

}
