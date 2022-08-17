import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

	static class CCTV {
		int num;
		int x, y;

		public CCTV(int num, int x, int y) {
			this.num = num;
			this.x = x;
			this.y = y;
		}
	}

	public static int N, M;
	public static int[][] map;
	public static int totalCnt, max;
	public static int[] order;
	public static List<List<List<Integer>>> cctvDir;
	public static List<List<Integer>> cctvNum;
	public static List<Integer> dir;
	public static List<CCTV> cctvs;
	public static int[] dx = {0, 1, 0, -1};
	public static int[] dy = {1, 0, -1, 0};
	public static int[] command = {4, 2, 4, 4, 1};

	public static void arrayinit() {
		// 전체 List
		cctvDir = new ArrayList<>();

		// 1번에 해당하는 list
		cctvNum = new ArrayList<>();

		// 1번 안 List
		dir = new ArrayList<>();
		dir.add(0);
		cctvNum.add(dir);
		dir = new ArrayList<>();
		dir.add(1);
		cctvNum.add(dir);
		dir = new ArrayList<>();
		dir.add(2);
		cctvNum.add(dir);
		dir = new ArrayList<>();
		dir.add(3);
		cctvNum.add(dir);

		cctvDir.add(cctvNum);

		// 2번에 해당하는 list
		cctvNum = new ArrayList<>();

		// 2번 안 List
		dir = new ArrayList<>();
		dir.add(0);
		dir.add(2);
		cctvNum.add(dir);
		dir = new ArrayList<>();
		dir.add(1);
		dir.add(3);
		cctvNum.add(dir);

		cctvDir.add(cctvNum);

		// 3번에 해당하는 list
		cctvNum = new ArrayList<>();

		// 3번 안 List
		dir = new ArrayList<>();
		dir.add(0);	dir.add(1);
		cctvNum.add(dir);
		dir = new ArrayList<>();
		dir.add(1);	dir.add(2);
		cctvNum.add(dir);
		dir = new ArrayList<>();
		dir.add(2);	dir.add(3);
		cctvNum.add(dir);
		dir = new ArrayList<>();
		dir.add(3);	dir.add(0);
		cctvNum.add(dir);
		
		cctvDir.add(cctvNum);
		
		// 4번에 해당하는 list
		cctvNum = new ArrayList<>();

		// 4번 안 List
		dir = new ArrayList<>();
		dir.add(0); dir.add(1);	dir.add(2);
		cctvNum.add(dir);
		dir = new ArrayList<>();
		dir.add(1); dir.add(2);	dir.add(3);
		cctvNum.add(dir);
		dir = new ArrayList<>();
		dir.add(2); dir.add(3);	dir.add(0);
		cctvNum.add(dir);
		dir = new ArrayList<>();
		dir.add(3); dir.add(0);	dir.add(1);			
		cctvNum.add(dir);
		
		cctvDir.add(cctvNum);
		
		// 5번에 해당하는 list
		cctvNum = new ArrayList<>();

		// 5번 안 List
		dir = new ArrayList<>();
		dir.add(0); dir.add(1);	dir.add(2);	dir.add(3);
		cctvNum.add(dir);
		
		cctvDir.add(cctvNum);
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		arrayinit();
		
		cctvs = new ArrayList<>();

		map = new int[N][M];
		int input;
		totalCnt = N*M;
		for (int i = 0; i < N; i++) {

			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				input = Integer.parseInt(st.nextToken());
				map[i][j] = input;
				if (input == 6) totalCnt--;
				else if (input != 0) {
					cctvs.add(new CCTV(input-1, i, j));
					map[i][j] = 0;
				}
			}

		}
		
		//
		max = 0;
		order = new int[cctvs.size()];
		dfs(0);
		System.out.println(totalCnt - max);
		
	}
	
	
	public static int watch() {
		int res = 0;
		int[][] new_map = new int[N][M];
		
		for(int i = 0; i < N; i++)
			new_map[i] = Arrays.copyOf(map[i], map[i].length);
		
		for(int i = 0, cSize = cctvs.size(); i < cSize; i++) {
			CCTV cctv = cctvs.get(i);
			List<Integer> list = cctvDir.get(cctv.num).get(order[i]);
			
			for(int j = 0, lSize = list.size(); j < lSize; j++) {
				int dir = list.get(j);
				
				int nx = cctv.x, ny = cctv.y;
				do{
					
					if(nx < 0 || nx >= N || ny < 0 || ny  >= M || new_map[nx][ny] == 6) break;
					
					if(new_map[nx][ny] == 0) {
						res++;
						new_map[nx][ny] = -1;
					}
					
					nx += dx[dir]; ny += dy[dir];
					
				}while(true);
				
			}
			
		}
		
		return res;
	}
	
	public static void dfs(int cnt) {
		if( cnt == order.length) {
			max = Math.max(max, watch());
			return;
		}
		
		int cctvN = cctvs.get(cnt).num;
		for(int i = 0; i < command[cctvN]; i++) {
			order[cnt] = i;
			dfs(cnt+1);
		}
		
	}

}