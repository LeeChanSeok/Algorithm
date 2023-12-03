import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	
	static class Student{
		String name;
		int year, month, day;
		public Student(String name, int year, int month, int day) {
			super();
			this.name = name;
			this.year = year;
			this.month = month;
			this.day = day;
		}
		
	}

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int n = Integer.parseInt(br.readLine());
		
		Student[] students = new Student[n];
		for(int i = 0; i < n; ++i) {
			st = new StringTokenizer(br.readLine());
			
			String name = st.nextToken();
			int day = Integer.parseInt(st.nextToken());
			int month = Integer.parseInt(st.nextToken());
			int year = Integer.parseInt(st.nextToken());
			
			students[i] = new Student(name, year, month, day);
		}
		
		Arrays.sort(students, (s1, s2) -> {
			if(s1.year == s2.year) {
				if(s1.month == s2.month) {
					return s1.day - s2.day;
				}
				return s1.month - s2.month;
			}
			return s1.year - s2.year;
		});

		System.out.println(students[n-1].name);
		System.out.println(students[0].name);
		
	}


}