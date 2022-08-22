import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {

	static int N, X, K; // 입력받을 데이터의 변수

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); // BufferedReader를 통해 데이터를 입력받는다
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out)); // BufferedWriter를 통해 데이터를 출력한다
		StringTokenizer st;
		StringBuilder sb = new StringBuilder(); // StringBuilder를 통해 출력할 결과를 모두 저장한 후 testcase 종료 후 출력한다.

		// 1. 정보를 입력 받는다.
		st = new StringTokenizer(br.readLine()); // StringTokenizer를 통해 공백 기준으로 입력 데이터를 split한다.
		N = Integer.parseInt(st.nextToken()); // 종이컵의 수 (N)
		X = Integer.parseInt(st.nextToken()); // 사탕의 위치 (X)
		K = Integer.parseInt(st.nextToken()); // 위치 변경 횟수 (K)

		// 2. 위치 변경을 수행한다.
		int pos1, pos2;
		for (int i = 0; i < K; i++) {
			// 바꿀 두 위치를 입력 받는다
			st = new StringTokenizer(br.readLine()); // StringTokenizer를 통해 공백 기준으로 입력 데이터를 split한다.
			pos1 = Integer.parseInt(st.nextToken());
			pos2 = Integer.parseInt(st.nextToken());

			if (X != pos1 && X != pos2)// 사탕의 위치가 바굴 두 위치에 포함되어 있지 않다면 빈 종이컴을 바꾸는 것으로 아무 수행도 하지 않는다
				continue;

			// 사탕의 위치가 바꿀 두 위치 중 하나에 포함되는 경우
			if (X == pos1)
				X = pos2; // X가 pos1이라면 X는 pos2와 위치를 바꾼다.
			else
				X = pos1; // X가 pos2에 위치하면 pos1와 위치를 바꾼다.

		}
		sb.append(X);

		bw.write(sb.toString()); // 결과를 출력한다.
		bw.close(); // 버퍼에 남아있는 데이터를 추력한다.
	}
}