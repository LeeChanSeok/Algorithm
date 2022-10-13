import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Solution {

	static char[][] gear;
	static int[] gearDir;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int T = Integer.parseInt(br.readLine());
		int N = 4, K, score;
		for (int tc = 1; tc <= T; tc++) {

			K = Integer.parseInt(br.readLine());
			
			gear = new char[4][8];
			for(int i = 0; i < 4; ++i) {
				st = new StringTokenizer(br.readLine());
				for(int j = 0; j < 8; ++j) {
					gear[i][j] = st.nextToken().charAt(0);
				}
			}

			gearDir = new int[4];
			int num, d;
			while(K-- > 0) {
				st = new StringTokenizer(br.readLine());
				num = Integer.parseInt(st.nextToken())-1;
				d = (Integer.parseInt(st.nextToken()) > 0 )? 1 : 0;
				
				rotate(num, d, 3);
			}
			
			score = 0;
			score += (gear[0][gearDir[0]] == '1' ? 1 : 0);
			score += (gear[1][gearDir[1]] == '1' ? 2 : 0);
			score += (gear[2][gearDir[2]] == '1' ? 4 : 0);
			score += (gear[3][gearDir[3]] == '1' ? 8 : 0);
			
			System.out.printf("#%d %d\n", tc, score);
			
		} // tc 종료

	}

	private static void rotate(int num, int d, int arrow) {

		int ldir, dir, rdir;
		// 왼쪽
		if(((arrow & 2) != 0)  && num > 0) {
			ldir = (gearDir[num-1]+2)%8;
			dir = (gearDir[num]+6)%8;
			
			if(gear[num-1][ldir] != gear[num][dir]) rotate(num-1, d^1, 2);
		}
		
		// 오른쪽
		if(((arrow & 1) != 0) && num < 3) {
			dir = (gearDir[num]+2) % 8;
			rdir = (gearDir[num+1]+6) % 8;
			
			if(gear[num][dir] != gear[num+1][rdir]) rotate(num+1, d^1, 1);
		}
		
		// rotate
		if(d == 1) 	gearDir[num] = (gearDir[num] + 7) % 8;
		else gearDir[num] = (gearDir[num] + 1) % 8;
	}

}
