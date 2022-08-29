import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int N = 1000;
		int[] score;
		int T = Integer.parseInt(br.readLine());
		for(int tc = 1; tc <= T; tc++) {
		br.readLine();
		score = new int[101];
		
		st = new StringTokenizer(br.readLine());
		for(int i = 0 ; i < N; i++) {
			score[Integer.parseInt(st.nextToken())]++;
		}
		
		int maxScore = 0;
		int maxCount = 0;
		for(int i = 0, sSize = score.length; i < sSize; i++) {
			if(score[i] >= maxCount) {
				maxCount = score[i];
				maxScore = i;
			}
		}
		
		System.out.println("#" + tc + " " + maxScore);
		}// tc 종료

	}

}