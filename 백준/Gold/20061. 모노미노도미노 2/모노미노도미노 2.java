import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int t, x, y, score = 0, blockCnt = 0;
		int N = Integer.parseInt(br.readLine());
		
		boolean[][] blue = new boolean[6][4];
		boolean[][] red = new boolean[6][4];

		while(N-- > 0) {
			st = new StringTokenizer(br.readLine());
			
			t = Integer.parseInt(st.nextToken());
			x = Integer.parseInt(st.nextToken());
			y = Integer.parseInt(st.nextToken());

			score += putBlock(t, x, y, blue, red);
		}
		
		for(int i = 0; i < 6; ++i) {
			for(int j = 0; j < 4; ++j) {
				if(blue[i][j]) ++ blockCnt;
				if(red[i][j]) ++ blockCnt;
			}
			
		}
		
		System.out.println(score);
		System.out.println(blockCnt);
	}

	private static int putBlock(int t, int x, int y, boolean[][] blue, boolean[][] red) {
		int score;
		if(t == 1) {
			type1(x, y, blue, red);
		}else if(t == 2) {
			type2(x, y, blue, red);
		}if(t == 3) {
			type3(x, y, blue, red);
		}
		
		score = fillCheck(blue, red);
		outBound(blue, red);
		
		return score;
	}

	private static void outBound(boolean[][] blue, boolean[][] red) {
		// blue
		int out = 0;
		if(blue[4][0] || blue[4][1] || blue[4][2] || blue[4][3]) ++out;
		if(blue[5][0] || blue[5][1] || blue[5][2] || blue[5][3]) ++out;
		
		if(out != 0) {
			for(int j = 0; j < 4; ++j)
				blue[j] = blue[j+out].clone();
			Arrays.fill(blue[4], false);
			Arrays.fill(blue[5], false);
		}
		
		// red
		out = 0;
		if(red[4][0] || red[4][1] || red[4][2] || red[4][3]) ++out;
		if(red[5][0] || red[5][1] || red[5][2] || red[5][3]) ++out;
		
		if(out != 0) {
			for(int j = 0; j < 4; ++j)
				red[j] = red[j+out].clone();
			Arrays.fill(red[4], false);
			Arrays.fill(red[5], false);
		}
	}

	private static int fillCheck(boolean[][] blue, boolean[][] red) {
		int score = 0;
		
		// 블록 제거
		for(int j = 0; j < 4; ++j) {
			if(blue[j][0] && blue[j][1] && blue[j][2] && blue[j][3]) {
				
				// 블록이동
				for(int k = j; k < 5; ++k)
					blue[k] = blue[k+1].clone();
				Arrays.fill(blue[5], false);
				
				++score;
				--j;
			}

		}
		
		// 블록 제거
		for(int j = 0; j < 4; ++j) {
			if(red[j][0] && red[j][1] && red[j][2] && red[j][3]) {
				
				// 블록이동
				for(int k = j; k < 5; ++k)
					red[k] = red[k+1].clone();
				Arrays.fill(red[5], false);
				
				++score;
				--j;
			}

		}
		
		return score;
	}

	private static void type3(int x, int y, boolean[][] blue, boolean[][] red) {
		// blue
		int j = 3;
		while(j >= 0 && !blue[j][x] && !blue[j][x+1]) --j;
		++j;
		blue[j][x] = blue[j][x+1] = true;
		
		// red
		j = 3;
		while(j >= 0 && !red[j][y]) --j;
		++j;
		red[j][y] = red[j+1][y] =  true;
	}

	private static void type2(int x, int y, boolean[][] blue, boolean[][] red) {
		// blue
		int j = 3;
		while(j >= 0 && !blue[j][x]) --j;
		++j;
		blue[j][x] = blue[j+1][x] = true;
		
		// red
		j = 3;
		while(j >= 0 && !red[j][y] && !red[j][y+1]) --j;
		++j;
		red[j][y] = red[j][y+1] = true;
		
	}

	private static void type1(int x, int y, boolean[][] blue, boolean[][] red) {
		// blue
		int j = 3;
		while(j >= 0 && !blue[j][x]) --j;
		++j;
		blue[j][x] = true;

		// red
		j = 3;
		while(j >= 0 && !red[j][y]) --j;
		++j;
		red[j][y] = true;
	}

}