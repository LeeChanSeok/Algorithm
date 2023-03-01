import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {
		
	public static void main(String[] args) throws IOException {

		final int N = 8;
		final int[] dx = {-1, -1, 0, 1, 1, 1, 0, -1};
		final int[] dy = {0, 1, 1, 1, 0, -1, -1, -1};

		Map<String, Integer> dirMap = new HashMap<>();
		dirMap.put("T", 0); dirMap.put("RT", 1); dirMap.put("R", 2); dirMap.put("RB", 3);
		dirMap.put("B", 4); dirMap.put("LB", 5); dirMap.put("L", 6); dirMap.put("LT", 7);
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		String pos = st.nextToken();
		int[] king = new int[] {8 - (int)(pos.charAt(1) - '0'), pos.charAt(0) - 'A'};
		
		pos = st.nextToken();
		int[] stone = new int[] {8 - (int)(pos.charAt(1) - '0'), pos.charAt(0) - 'A'};
		
		int M = Integer.parseInt(st.nextToken());

		
		for(int i = 0; i < M; ++i) {
			st = new StringTokenizer(br.readLine());
			int d = dirMap.get(st.nextToken());
			
			int knx = king[0] + dx[d];
			int kny = king[1] + dy[d];
			
			if(!inRange(knx, kny)) continue;
			
			if(knx == stone[0] && kny == stone[1]) {
				int snx = stone[0] + dx[d];
				int sny = stone[1] + dy[d];
				if(!inRange(snx, sny)) continue;
				
				king[0] = knx;
				king[1] = kny;
				stone[0] = snx;
				stone[1] = sny;
			}else {
				king[0] = knx;
				king[1] = kny;
			}
			
		}
		
		System.out.println(String.valueOf((char)(king[1] + 'A')) + (8 - king[0]));
		System.out.println(String.valueOf((char)(stone[1] + 'A')) + (8 - stone[0]));
	}
	
	static boolean inRange(int x, int y) {
		if(x >= 0 && x < 8 &&  y >= 0 && y < 8) return true;
		return false;
	}

}