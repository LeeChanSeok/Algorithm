import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static int N;
	public static int[] perm;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuffer sb = new StringBuffer();
		N = Integer.parseInt(br.readLine());
		
		st = new StringTokenizer(br.readLine());
		perm = new int[N];
		for(int i = 0; i < N; i++) {
			perm[i] = Integer.parseInt(st.nextToken());
		}
		
		if(nextPermutation()) 
			for(int c : perm) sb.append(c).append(" ");
		else
			sb.append(-1);
		System.out.println(sb.toString());
	}

	public static boolean nextPermutation() {
		int i = N - 1;
		while (i > 0 && perm[i-1] >= perm[i]) i--;
		
		if (i == 0) return false;
		
		int j = N - 1;
		while(perm[i-1] >= perm[j]) j--;
		swap(i-1, j);
		
		int k = N - 1;
		while(i < k) swap(i++, k--);
		
		return true;
	}
	
	public static void swap(int i, int j) {
		int temp = perm[i];
		perm[i] = perm[j];
		perm[j] = temp;
	}
	
}