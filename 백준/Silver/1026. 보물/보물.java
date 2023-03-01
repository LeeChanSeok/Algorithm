import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Main {
	static int N; 
	static int[] A, B;
	static int min;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		N = Integer.parseInt(br.readLine());
		A = new int[N];
		B = new int[N];
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i < N; ++i) A[i] = Integer.parseInt(st.nextToken());
		
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i < N; ++i) B[i] = Integer.parseInt(st.nextToken());
		
		Arrays.sort(A);
		Arrays.sort(B);
		
		int res = 0;
		for(int i = 0; i < N; ++i) res += A[i] * B[N-1-i];
		
		System.out.println(res);
		
	}

}