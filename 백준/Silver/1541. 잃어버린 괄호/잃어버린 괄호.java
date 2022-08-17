import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str = br.readLine();
		
		List<Integer> nums = new ArrayList<>();
		List<Character> ops = new ArrayList<>();
		String temp = "";
		char c;
		for(int i = 0, sSize = str.length() ; i < sSize; i++) {
			c = str.charAt(i);
			if (c == '+' || c == '-') {
				ops.add(str.charAt(i));
				nums.add(Integer.parseInt(temp));
				temp = "";
			}else {
				temp += c;
			}
		}
		nums.add(Integer.parseInt(temp));

		int total_sum = nums.get(0);
		int sum = 0;
		boolean isMinus = false;
		for(int i = 0, opSize = ops.size(); i < opSize; i++) {
			if(!isMinus && ops.get(i) == '+') total_sum += nums.get(i+1);
			else if(ops.get(i) == '-') {
				isMinus = true;
				total_sum += sum * -1;
				sum = nums.get(i+1);
			}else {
				sum += nums.get(i+1);
			}
		}
		if(isMinus) total_sum += sum * -1;
		System.out.println(total_sum);
	}

}