import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int N = Integer.parseInt(br.readLine());
		st = new StringTokenizer(br.readLine(), " ");
		boolean[] on_off = new boolean[N+1];
		
		for(int i = 1; i < on_off.length; i++) {	
			char light = st.nextToken().charAt(0);
			if( light == '1') on_off[i] = true;
		}
		
		
		int stuCnt = Integer.parseInt(br.readLine());
		for(int i = 0; i < stuCnt; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			char gander =  st.nextToken().charAt(0);
			int number = Integer.parseInt(st.nextToken());
			
			if(gander == '1') {
				for(int j = number; j < on_off.length; j+=number) {
					on_off[j] = !on_off[j];
				}
			}else{
				int j = 0;
				while((number - j) > 0 && (number + j) < on_off.length) {
					if(on_off[number - j] == on_off[number + j]) {
						boolean res = !on_off[number-j];
						on_off[number - j] = res;
						on_off[number + j] = res;
					}
					else 
						break;
					j++;					
				}
			}			
		}
		for(int i = 1; i < on_off.length; i++) {
			if(on_off[i]) System.out.print("1 ");
			else System.out.print("0 ");
			if(i %20 ==0) System.out.println();
		}
		System.out.println();
	}

}
