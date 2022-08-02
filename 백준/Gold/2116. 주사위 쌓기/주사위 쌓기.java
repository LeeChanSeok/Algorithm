import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static int[] dx = {0, 1, 1, 1, 1, 2};
	public static int[] dy = {1, 0, 1, 2, 3, 1};
	public static int[] match = {5, 3, 4, 1, 2, 0};
	public static int[][] dices;
	public static int N;
	
	public static int recursive(int bt_num, int cnt) {
		if (cnt == N) return 0;
		
		int bt_idx = -1;
		int up_idx = -1;
		for(int i = 0; i < 6; i++) {
			if(dices[cnt][i]==bt_num) {
				bt_idx = i;
				up_idx = match[bt_idx];
			}
		}
		
		int area = 0;
		for(int i = 0; i < 6; i++) {
			if(i == bt_idx || i == up_idx) continue;
			area = Math.max(area, dices[cnt][i]);
		}
		
		return area + recursive(dices[cnt][up_idx], cnt+1);		
	}
	
	public static void main(String[] args) throws IOException {		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		N = Integer.parseInt(br.readLine());
		dices = new int[N][6];
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for(int j = 0; j < 6; j++)
				dices[i][j] = Integer.parseInt(st.nextToken());
		}
		
		int max = 0;
		for(int i = 1; i <= 6; i++) {					
			max = Math.max(max, recursive(i, 0));
		}
		System.out.println(max);
	}
}