import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;
import java.util.Map;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		final int delta = 100;
		final int[] dx = {-1, 1, 0, 0};
		final int[] dy = {0, 0, -1, 1};
		
		int ans = 1;
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		Map<Integer, List<Integer>> lightMap = new HashMap<>();
		List<Integer> list = null;
		int x, y, a, b, from, to;
		for(int i = 0; i < M; ++i) {
			st = new StringTokenizer(br.readLine());
			
			x = Integer.parseInt(st.nextToken())-1;
			y = Integer.parseInt(st.nextToken())-1;
			a = Integer.parseInt(st.nextToken())-1;
			b = Integer.parseInt(st.nextToken())-1;
			
			from = x*delta + y;
			to = a*delta + b;
			
			list = lightMap.getOrDefault(from, new LinkedList<Integer>());
			list.add(to);
			lightMap.put(from, list);
			
		}
		
		boolean[][] light = new boolean[N][N];
		boolean[][] move = new boolean[N][N];
		
		light[0][0] = move[0][0] = true;
		
		Queue<Integer> q = new LinkedList<>();
		q.offer(0);
		
		List<Integer> on = new LinkedList<>();
		ListIterator<Integer> iter;
		int qSize, pos;
		boolean isMove;
		while(!q.isEmpty()) {
			qSize = q.size();
			while(qSize-- > 0) {
				from = q.poll();
				list = lightMap.getOrDefault(from, null);
				if(list == null) continue;
				iter = list.listIterator();
				
				while(iter.hasNext()) {
					pos = iter.next();
					a = pos / delta; b = pos % delta;
					
					if(light[a][b]) iter.remove();
					else {
						on.add(a*delta + b);
						light[a][b] = true;
						++ans;
					}
				}
				
			}
			
			isMove = true;
			while(on.size() != 0 && isMove) {
				isMove = false;
				iter = on.listIterator();
				while(iter.hasNext()) {
					pos = iter.next();
					x = pos / delta; y = pos % delta;
					
					for(int d = 0; d < 4; ++d) {
						a = x + dx[d]; b = y + dy[d];
						if(a < 0 || a >= N || b < 0 || b >= N || !move[a][b] || move[x][y]) continue;
						
						iter.remove();
						move[x][y] = true;
						isMove = true;
						q.offer(pos);
						break;
					}
					
				}
			}
			
		}
		
		System.out.println(ans);
	}

}
