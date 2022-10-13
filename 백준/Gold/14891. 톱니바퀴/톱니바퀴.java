import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	static char[][] gear;
	static int[] gearDir;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		gear = new char[4][8];
		for(int i = 0; i < 4; ++i) {
			gear[i] = br.readLine().toCharArray();
		}

		gearDir = new int[4];
		int K = Integer.parseInt(br.readLine());
		int num, d;
		while(K-- > 0) {
			st = new StringTokenizer(br.readLine());
			num = Integer.parseInt(st.nextToken())-1;
			d = (Integer.parseInt(st.nextToken()) > 0 )? 1 : 0;
			
			rotate(num, d, 3);
		}
		
		int score = (gear[0][gearDir[0]] == '1' ? 1 : 0);
		score += (gear[1][gearDir[1]] == '1' ? 2 : 0);
		score += (gear[2][gearDir[2]] == '1' ? 4 : 0);
		score += (gear[3][gearDir[3]] == '1' ? 8 : 0);
		
		System.out.println(score);
		
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