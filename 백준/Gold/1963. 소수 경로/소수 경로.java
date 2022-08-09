import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

class Prime {
	int prime;
	int cnt;

	public Prime(int prime, int cnt) {
		this.prime = prime;
		this.cnt = cnt;
	}
}

public class Main {
	public static boolean isPrime(int n) {
		for (int i = 2; i < Math.sqrt(n) + 1; i++) {
			if (n % i == 0)
				return false;
		}
		return true;
	}

	public static int bfs(int A, int B, Queue<Prime> q, List<Integer> isUsed) {
		int res = -1;
		int idx;
		int temp, pre, cur;

		q.add(new Prime(A, 0));

		while (!q.isEmpty()) {
			Prime p = q.poll();
			if(p.prime == B) return p.cnt;
			
			idx = 1;
			pre = 0;
			
            // 각 자리의 수를 0부터 1까지 바꾸어가며 소수 판별
			for (int i = 0; i < 4; i++) {
				temp = p.prime;
				cur = temp % (idx * 10);
				temp -= cur - pre; 
				// 한자리 숫자를 바꾸어 소수로 만들 수 있는 모든 경우를 q에 저장
                // List를 이용하여 중복 체크 방지
				for(int j = 0; j < 10; j++, temp += idx) {
					if(i == 3 && j == 0) continue;
					if(isUsed.contains(temp)) continue;
					
					if(isPrime(temp)) {
						isUsed.add(temp);
						q.add(new Prime(temp, p.cnt+1));
					}
				}
				
				idx *= 10;
				pre = cur;
			}
		}
		return res;
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int T = Integer.parseInt(br.readLine());
		List<Integer> isUsed;
		Queue<Prime> q;
		int A, B, ans;
		for (int tc = 1; tc <= T; tc++) {
			st = new StringTokenizer(br.readLine());
			A = Integer.parseInt(st.nextToken());
			B = Integer.parseInt(st.nextToken());

			isUsed = new ArrayList<>();
			q = new LinkedList<>();

			ans = bfs(A, B, q, isUsed);
			if (ans == -1)
				System.out.println("Impossible");
			else
				System.out.println(ans);

		}
	}

}