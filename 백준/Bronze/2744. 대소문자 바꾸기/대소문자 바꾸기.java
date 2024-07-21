import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
		
		char[] arr = br.readLine().toCharArray();
		for(int i = 0; i < arr.length; ++i) {
			if(arr[i] >= 'A' && arr[i] <= 'Z') {
				arr[i] =(char)(arr[i] + 32);
			}else {
				arr[i] =(char)(arr[i] - 32);
			}
		}
		
		System.out.println(String.valueOf(arr));

	}

}