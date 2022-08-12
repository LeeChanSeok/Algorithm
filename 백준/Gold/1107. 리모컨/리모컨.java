import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
	public static int min;

	public static void recursive(char[] N, char[] my, List<Character> button, int cnt, int ud) {
		if (cnt >= min)
			return; // 현재까지 누른 버튼의 수가 최소값 보다 크거나 같으면 종료
		if (cnt == N.length) {
			int cha = Math.abs(Integer.parseInt(new String(N)) - Integer.parseInt(new String(my))); // 입력한 번호에서 이동하려는
																									// 번호까지 이동해야하는 수
			min = Math.min(min, cha + cnt); // 각 버튼을 누른 횟수와 +,-로 이동해야하는 이둥 수를 합한 전체 이동 횟수와 최소값 비교
			return;
		}

		char pivot = N[cnt]; // 현재 위치에서의 번호
		if (ud == 0) {
			if (button.contains(pivot)) { // 해당 위치의 번호와 일치되는 번호가 있는 경우
				my[cnt] = pivot;
				recursive(N, my, button, cnt + 1, 0);
			}
			for (int i = 0; i < button.size(); i++) {
				if (cnt == 0 && button.get(i) == 0)
					continue;
				if (button.get(i) > pivot) {
					my[cnt] = button.get(i);
					recursive(N, my, button, cnt + 1, 1);
					break;
				}
			}

			// 기준 값 보다 작은 값중 가장 큰 값
			for (int i = button.size() - 1; i >= 0; i--) {
				if (cnt == 0 && button.get(i) == 0)
					continue;
				if (button.get(i) < pivot) {
					my[cnt] = button.get(i);
					recursive(N, my, button, cnt + 1, -1);
					break;
				}
			}

		} else if (ud == 1) { // 이동하려는 번호보다 큰 번호를 입력한 경우, 가장 작은 번호로 이동
			my[cnt] = button.get(0);
			recursive(N, my, button, cnt + 1, 1);
		} else if (ud == -1) { // 이동하려는 번호보다 작은 번호를 입력한 경우, 가장 큰 번호로 이동
			my[cnt] = button.get(button.size() - 1);
			recursive(N, my, button, cnt + 1, -1);
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int T = 1;
		for (int tc = 1; tc <= T; tc++) {

			int start = 100; // 현재 체널
			char[] N = br.readLine().toCharArray(); // 이동하려고 하는 체널
			int M = Integer.parseInt(br.readLine()); // 고장난 버튼의 개수
			char[] miss; // 고장난 버튼을 담을 배열
			List<Character> button = new ArrayList<Character>(10 - M); // 고장나지 않은 버튼을 담을 List

			if (M != 0) { // M이 0이면 고장난 버튼에 대한 입력을 받지 않는다.
				miss = new char[M];
				st = new StringTokenizer(br.readLine());
				for (int i = 0; i < M; i++)
					miss[i] = st.nextToken().charAt(0);
					Arrays.sort(miss);
				for (int i = 0, idx = 0; i < 10; i++) { // 고장나지 않은 버튼을 List에 추가한다
					if (idx < M && i == miss[idx] - '0')
						idx++;
					else
						button.add((char) (i + '0'));
				}
			}
			Collections.sort(button); // 오름차순으로 정렬
			min = Math.abs(Integer.parseInt(new String(N)) - start); // 현재 위치에서 +,-버튼만으로 이동할 수 있는 수를 구한다.
			if (M == 10) {
			} // 모든 버튼이 고장났으므로 +, - 버튼으로만 이동이 가능하다.
			else if (M == 0) { // 모든 버튼이 이용 가능하므로 해당 체널을 입력하는 경우와 +,-로 이동하는 경우 중 최소값을 구한다
				min = Math.min(min, N.length);
			} else if (button.size() == 1 && button.get(0) == '0') {
				min = Math.min(min, 1 + Integer.parseInt(new String(N)));
			} else {
				char[] my = new char[N.length]; // 입력한 버튼을 담을 배열
				recursive(N, my, button, 0, 0);

				// 이동하려는 체널보다 한자리 더 큰 수 중 가장 작은 수
				StringBuilder Nplus = new StringBuilder();
				for (int i = 0; i < N.length + 1; i++) {
					if (i == 0 && button.get(0) == '0')
						Nplus.append(button.get(1)); // 첫번째 자리가 0이 되는 것을 방지
					else
						Nplus.append(button.get(0));
				}
				if (Nplus != null) {
					min = Math.min(min, Nplus.length()
							+ Math.abs(Integer.parseInt(Nplus.toString()) - Integer.parseInt(new String(N))));
				}

				// 이동하려는 체널보다 한자리 작은 수 중 가장 큰 수
				StringBuilder Nminus = new StringBuilder();
				for (int i = 0; i < N.length - 1; i++) {
					Nminus.append(button.get(button.size() - 1));
				}
				if (Nminus.length() != 0) {
					min = Math.min(min, Nminus.length()
							+ Math.abs(Integer.parseInt(Nminus.toString()) - Integer.parseInt(new String(N))));
				}

			}
            System.out.println(min);
		}
	}
}