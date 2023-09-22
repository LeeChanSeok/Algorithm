import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	
	static int n, m, guiter;
	static long[] play;
	static int[] res;
	
	public static void main(String[] args) throws Exception{
		input();
		pro();
	}

	private static void pro() {
		
		if(guiter == 0) System.out.println(-1);
		else {
			res = new int[2];
			res[0] = 0; res[1] = n;
			recursive(0, 0, 0);
			System.out.println(res[1]);
		}
	}

	private static void recursive(int idx, int cnt, long music) {
		
		int music_cnt = get_musicCnt(music);
		if(music_cnt > res [0] || (music_cnt == res[0] && cnt < res[1])) {
			res = new int[] {music_cnt, cnt};
		}
		
		if(idx == guiter) return;
				
		recursive(idx + 1, cnt + 1, music | play[idx]);
		recursive(idx + 1, cnt, music);
		
	}

	private static int get_musicCnt(long music) {
		int cnt = 0;
		while(music != 0) {
			cnt += (music & 1);
			music >>= 1;
		}
		return cnt;
	}

	private static void input() throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		
		play = new long[n];
		for(int i = 0; i < n; ++i) {
			st = new StringTokenizer(br.readLine());
			st.nextToken();
			String str = st.nextToken();
			
			for(int j = 0; j < m; ++j) {
				if(str.charAt(j) == 'Y') play[guiter] |= (1l << j);
			}
			if(play[guiter] != 0) ++guiter;
		}
		
		
	}

}