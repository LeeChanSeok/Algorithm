public class Main {
	
	public static void main(String[] args) throws Exception{
		StringBuilder sb = new StringBuilder();
		int End = 10000;
		
		boolean[] salfN = new boolean[End];
		
		for(int i = 1; i < End; ++i) {
			
			int num = i;
			int dn;
			while((dn = num + digitSum(num)) < End) {
				salfN[dn] = true;
				num = dn;
			}
			
		}
		
		for(int i = 1; i < End; ++i) {
			if(!salfN[i]) sb.append(i).append('\n');
		}
		
		System.out.println(sb);

	}

	private static int digitSum(int num) {

		int sum = 0;
		while(num != 0) {
			sum += num % 10;
			num /= 10;
		}
		return sum;
	}

}