import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	
	static class Score{
		int x, y;

		public Score(int x, int y) {
			super();
			this.x = x;
			this.y = y;
		}
		
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
	
		int T = Integer.parseInt(br.readLine());
		for(int tc = 1; tc <= T; ++tc) {
			int N = Integer.parseInt(br.readLine());
			
			Score[] scores = new Score[N];
			for(int i = 0; i < N; ++i) {
				st = new StringTokenizer(br.readLine());
				scores[i] = new Score(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
			}
			
			Arrays.sort(scores, (s1, s2) -> s1.x - s2.x);
			
			int maxScore = scores[0].y;
			int score;
			int count = 1;
			for(int i = 1; i < N; ++i) {
				score = scores[i].y;
				if(score < maxScore) {
					++count;
					maxScore = score;
				}
					
			}
            
			sb.append(count + "\n");
		}
		
		bw.write(sb.toString());
		bw.flush();
		
		bw.close();
		br.close();
	}

}
