import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.StringTokenizer;

public class Main {

	static int N, K;
	static Map<Long, Set<Long>> map;
	static long Ex, Ey;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		
		map = new HashMap<>();
		for(int i = 0; i < N; ++i) {
			st = new StringTokenizer(br.readLine());
			long x = Long.parseLong(st.nextToken());
			long y = Long.parseLong(st.nextToken());
			
			if(!map.containsKey(x)) map.put(x, new HashSet<Long>());
			map.get(x).add(y);
		}
		
		st = new StringTokenizer(br.readLine());
		Ex = Long.parseLong(st.nextToken());
		Ey = Long.parseLong(st.nextToken());
		
		long ans = solution();
		System.out.println(ans);

	}

	private static long solution() {
		
		long min = Long.MAX_VALUE;
		
		if(Math.abs(Ex) + Math.abs(Ey) <= K) min = Math.min(min, Math.abs(Ex) + Math.abs(Ey));
		
		if(K == 2) {
			if(map.containsKey(Ex) && map.get(Ex).contains(Ey)) min = Math.min(min, 2);
		} else if(K == 3) {
			if(map.containsKey(Ex) && map.get(Ex).contains(Ey)) min = Math.min(min, 2);
			
			else if(map.containsKey(Ex - 1) && map.get(Ex - 1).contains(Ey)) min = Math.min(min, 3);
			else if(map.containsKey(Ex + 1) && map.get(Ex + 1).contains(Ey)) min = Math.min(min, 3);
			else if(map.containsKey(Ex) && map.get(Ex).contains(Ey - 1)) min = Math.min(min, 3);
			else if(map.containsKey(Ex) && map.get(Ex).contains(Ey + 1)) min = Math.min(min, 3);
			
		}else if(K == 4) {
			if(map.containsKey(Ex) && map.get(Ex).contains(Ey)) min = Math.min(min, 2);
			
			else if(map.containsKey(Ex - 1) && map.get(Ex - 1).contains(Ey)) min = Math.min(min, 3);
			else if(map.containsKey(Ex + 1) && map.get(Ex + 1).contains(Ey)) min = Math.min(min, 3);
			else if(map.containsKey(Ex) && map.get(Ex).contains(Ey - 1)) min = Math.min(min, 3);
			else if(map.containsKey(Ex) && map.get(Ex).contains(Ey + 1)) min = Math.min(min, 3);
			
			else if(map.containsKey(Ex - 2) && map.get(Ex - 2).contains(Ey)) min = Math.min(min, 4);
			else if(map.containsKey(Ex - 1) && map.get(Ex - 1).contains(Ey - 1)) min = Math.min(min, 4);
			else if(map.containsKey(Ex - 1) && map.get(Ex - 1).contains(Ey + 1)) min = Math.min(min, 4);
			else if(map.containsKey(Ex) && map.get(Ex).contains(Ey - 2)) min = Math.min(min, 4);
			else if(map.containsKey(Ex) && map.get(Ex).contains(Ey + 2)) min = Math.min(min, 4);
			else if(map.containsKey(Ex + 1) && map.get(Ex + 1).contains(Ey - 1)) min = Math.min(min, 4);
			else if(map.containsKey(Ex + 1) && map.get(Ex + 1).contains(Ey + 1)) min = Math.min(min, 4);
			else if(map.containsKey(Ex + 2) && map.get(Ex + 2).contains(Ey)) min = Math.min(min, 4);
			else {
				for(Entry<Long,Set<Long>> entry : map.entrySet()) {
					long x  = entry.getKey();
					Set<Long> ys = entry.getValue();
					
					if(map.containsKey(Ex - x)) {
						for(long target : map.get(Ex - x)) {
							if(ys.contains(Ey - target)) min = Math.min(min, 4);
						}
						
					}
				}
			}
			
		}else if(K == 5) {
			if(map.containsKey(Ex) && map.get(Ex).contains(Ey)) min = Math.min(min, 2);
			
			else if(map.containsKey(Ex - 1) && map.get(Ex - 1).contains(Ey)) min = Math.min(min, 3);
			else if(map.containsKey(Ex + 1) && map.get(Ex + 1).contains(Ey)) min = Math.min(min, 3);
			else if(map.containsKey(Ex) && map.get(Ex).contains(Ey - 1)) min = Math.min(min, 3);
			else if(map.containsKey(Ex) && map.get(Ex).contains(Ey + 1)) min = Math.min(min, 3);
			
			else if(map.containsKey(Ex - 2) && map.get(Ex - 2).contains(Ey)) min = Math.min(min, 4);
			else if(map.containsKey(Ex - 1) && map.get(Ex - 1).contains(Ey - 1)) min = Math.min(min, 4);
			else if(map.containsKey(Ex - 1) && map.get(Ex - 1).contains(Ey + 1)) min = Math.min(min, 4);
			else if(map.containsKey(Ex) && map.get(Ex).contains(Ey - 2)) min = Math.min(min, 4);
			else if(map.containsKey(Ex) && map.get(Ex).contains(Ey + 2)) min = Math.min(min, 4);
			else if(map.containsKey(Ex + 1) && map.get(Ex + 1).contains(Ey - 1)) min = Math.min(min, 4);
			else if(map.containsKey(Ex + 1) && map.get(Ex + 1).contains(Ey + 1)) min = Math.min(min, 4);
			else if(map.containsKey(Ex + 2) && map.get(Ex + 2).contains(Ey)) min = Math.min(min, 4);
			
			else if(map.containsKey(Ex - 3) && map.get(Ex - 3).contains(Ey)) min = Math.min(min, 5);
			else if(map.containsKey(Ex - 2) && map.get(Ex - 2).contains(Ey - 1)) min = Math.min(min, 5);
			else if(map.containsKey(Ex - 2) && map.get(Ex - 2).contains(Ey + 1)) min = Math.min(min, 5);
			else if(map.containsKey(Ex - 1) && map.get(Ex - 1).contains(Ey - 2)) min = Math.min(min, 5);
			else if(map.containsKey(Ex - 1) && map.get(Ex - 1).contains(Ey + 2)) min = Math.min(min, 5);
			else if(map.containsKey(Ex) && map.get(Ex).contains(Ey - 3)) min = Math.min(min, 5);
			else if(map.containsKey(Ex) && map.get(Ex).contains(Ey + 3)) min = Math.min(min, 5);
			else if(map.containsKey(Ex + 1) && map.get(Ex + 1).contains(Ey - 2)) min = Math.min(min, 5);
			else if(map.containsKey(Ex + 1) && map.get(Ex + 1).contains(Ey + 2)) min = Math.min(min, 5);
			else if(map.containsKey(Ex + 2) && map.get(Ex + 2).contains(Ey - 1)) min = Math.min(min, 5);
			else if(map.containsKey(Ex + 2) && map.get(Ex + 2).contains(Ey + 1)) min = Math.min(min, 5);
			else if(map.containsKey(Ex + 3) && map.get(Ex + 3).contains(Ey)) min = Math.min(min, 5);

			for(Entry<Long,Set<Long>> entry : map.entrySet()) {
				long x  = entry.getKey();
				Set<Long> ys = entry.getValue();
				
				if(map.containsKey(Ex - x)) {
					for(long target : map.get(Ex - x)) {
						if(ys.contains(Ey - target)) min = Math.min(min, 4);
						else if(ys.contains(Ey - target - 1)) min = Math.min(min, 5);
						else if(ys.contains(Ey - target + 1)) min = Math.min(min, 5);
					}
				}
				
				if(map.containsKey(Ex - x - 1)) {
					for(long target : map.get(Ex - x - 1)) {
						if(ys.contains(Ey - target)) min = Math.min(min, 5);						
					}
				}
				
				if(map.containsKey(Ex - x + 1)) {
					for(long target : map.get(Ex - x + 1)) {
						if(ys.contains(Ey - target)) min = Math.min(min, 5);
					}
				}
			}
			
		}
		
		
		if(min == Long.MAX_VALUE) min = -1;
		return min;
	}

}