import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws Exception{
		// 표준 입출력 관련 변수 선언
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb, ans = new StringBuilder();
		
		// N : 동아리의 수 , S : 팀원 3명 능력 합, M : 개인 능력치 조건
		int N, S, M;
		
		N = Integer.parseInt(st.nextToken());
		S = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		

		int count = 0, sum;
		int x;
		boolean isTeam;
		for(int i = 0; i < N; ++i) {
			st = new StringTokenizer(br.readLine());
			
			// 동아리를 신청 할 수 있는지 호가인
			isTeam = true;
			
			// 개인의 능력을 저장할 변수
			sb = new StringBuilder();
			
			// 팀워들의 능력 합
			sum = 0;
			for(int j = 0; j < 3; ++j) {
				x = Integer.parseInt(st.nextToken());
				sb.append(x + " ");
				
				// 개인의 능려깅 M 보다 작으면 스터디를 만들지 못함
				if(x < M) {
					isTeam = false;
					break;
				}
				sum += x;
			}
			
			// 스터디원 능력 합이 S보다 작으면 스터디를 만들지 못함
			if(sum < S) isTeam = false;
			
			// 팀을 이룰 수 있으면 가능한 동아리 수를 증기시킨다.
			// 학생들의 능력치를 저장한다.
			if(isTeam) {
				++count;
				ans.append(sb.toString());
			}
			
		}
		
		// 가입가능한 동아리 수 출력
		System.out.println(count);
		// 가입된 학생들의 능력 출력
		bw.write(ans.toString());
		bw.close();
		
	}

}