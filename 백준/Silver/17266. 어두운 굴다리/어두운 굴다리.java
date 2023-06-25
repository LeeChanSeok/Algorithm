import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

	static int N, M;
	static int[] stones;
	
	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		N = Integer.parseInt(br.readLine());
		M = Integer.parseInt(br.readLine());
		
		stones = new int[M];
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i < M; ++i) stones[i] = Integer.parseInt(st.nextToken());
		
		int l = 0, h = N;
		int mid, cand = N;
		Arrays.sort(stones);
		while(l <= h) {
			mid = (l + h) / 2;
			
			if(allLight(mid)) {
				cand = mid;
				h = mid - 1;
			}else {
				l = mid + 1;
			}
		}

		System.out.println(cand);
	}

	private static boolean allLight(int h) {
		
        int last = 0;  // 밝혀진 마지막 위치
        for (int i = 0; i < M; i++) {
            if (stones[i] - last <= h) {
                last = stones[i] + h;
            } else {
                return false;
            }
        }
        return last >= N;
	}

}