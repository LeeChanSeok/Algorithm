import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int N = Integer.parseInt(br.readLine());
		int[] arr = new int[N];
		
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i < N; ++i) {
			arr[i] = Integer.parseInt(st.nextToken());
		}

		long P = 1;
		long Q = arr[N-1];
		
		for(int i = N - 2; i >= 0; --i) {
			int a = arr[i];
			
			long tmp = Q;
			P += a * Q;
			Q = P;
			P = tmp;
			
			
		}
		
		P = Q - P;
		
		System.out.println(P + " " + Q);
		
		
	}

}