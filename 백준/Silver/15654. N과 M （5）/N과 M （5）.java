import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	public static void permutation(int N, int M, int[] arr, int[] pick, boolean[] flag, int cnt, StringBuffer sb) {
		if (cnt == M) {
			for (int i = 0; i < M; i++) sb.append(pick[i]).append(" ");
			sb.append("\n");
			return;
		}

		for (int i = 0; i < N; i++) {
			if(flag[i]) continue;
			flag[i] = true;
			pick[cnt] = arr[i];
			permutation(N, M, arr, pick, flag, cnt+1, sb);
			flag[i] = false;
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuffer sb = new StringBuffer();

		st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int[] pick = new int[M];
		int[] arr = new int[N];
		boolean[] flag = new boolean[N];
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i < N; i++)
			arr[i] = Integer.parseInt(st.nextToken());
		
		Arrays.sort(arr);
		
		permutation(N, M, arr, pick, flag, 0, sb);
		System.out.println(sb.toString());
	}
}