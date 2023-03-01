import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

    static int N, M;
	static int[] arr, picked;
	static List<int[]> list;
    
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		st = new StringTokenizer(br.readLine());
		arr = new int[N];
		for(int i = 0; i < N; ++i) arr[i] = Integer.parseInt(st.nextToken());
		
		Arrays.sort(arr);
		picked = new int[M];
		list = new ArrayList<>();
		combination(0, 0);
		
		int[] res = new int[M];		
		for(int[] ans : list) {
			if(!isDuplicate(ans, res)){
				for(int num : ans) System.out.print(num + " ");
				System.out.println();
				res = ans;				
			}
		}
	}
    
	private static void combination(int idx, int pick) {

		if(pick == M) {
			list.add(Arrays.copyOf(picked, M));
			return;
		}
		
		Collections.sort(list, (a1, a2) -> {
			for(int i = 0; i < M; ++i) {
				if(a1[i] < a2[i]) return -1;
				else if(a1[i] > a2[i]) return 1;
			}
			return 0;
		});
		for(int i = idx; i < N; ++i) {
			picked[pick] = arr[i];
			combination(i+1, pick+1);
		}
		
	}
	
	private static boolean isDuplicate(int[] picked, int[] res) {
		for(int i = 0; i < M; ++i) if(picked[i] !=res[i]) return false;
		return true;
	}

}