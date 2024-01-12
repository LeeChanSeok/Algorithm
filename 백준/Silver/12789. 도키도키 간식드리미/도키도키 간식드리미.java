import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {

	static int n;
	static int[] line;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		n = Integer.parseInt(br.readLine());
		line = new int[n];
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i < n; ++i) {
			line[i] = Integer.parseInt(st.nextToken());
		}
		
		if(isOk()) System.out.println("Nice");
		else System.out.println("Sad");

	}
	private static boolean isOk() {

		Stack<Integer> wait = new Stack<>();
		wait.add(10000);
		
		int order = 1;
		int idx = 0;
		while(idx < n) {
			int top = wait.lastElement();
			int num = line[idx];
			
			// 1. wait 검사
			if(top == order) {
				wait.pop();
				order++;
			}
			else if(num == order) {
				++idx;
				order++;
			}
			else if(num < wait.lastElement()){
				wait.add(num);
				idx++;
			}
			else return false;
			
		}
		
		return true;
	}

}