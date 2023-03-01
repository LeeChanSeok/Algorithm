import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

	static int N, M;
	static int[] arr, picked;
	static List<int[]> list;
	static StringBuilder sb = new StringBuilder(); 
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		st = new StringTokenizer(br.readLine());
		arr = new int[N];
		for(int i = 0; i < N; ++i) arr[i] = Integer.parseInt(st.nextToken());
		
		Arrays.sort(arr);
		picked = new int[M];
		permutation(0);
		
		bw.write(sb.toString());
		bw.close();

	}
	
	private static void permutation(int pick) {

		if(pick == M) {
			for(int i = 0; i < M; ++i) sb.append(picked[i] + " ");
			sb.append("\n");
			
			return;
		}
		
		int prev = -1;
		for(int i = 0; i < N; ++i) {
			if(prev != arr[i]) {
				prev = arr[i];
				picked[pick] = prev;
				permutation(pick+1);	
			}
		}
		
	}
	
}