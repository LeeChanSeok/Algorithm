import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

	static class Person{
		int age, id;
		String name;
		
		public Person(int id, int age, String name) {
			super();
			this.id = id;
			this.age = age;
			this.name = name;
		}
		
	}
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		
		StringTokenizer st;
		
		int N = Integer.parseInt(br.readLine());
		
		Person[] person = new Person[N];
		int age; String name;
		for(int i = 0; i < N; ++i) {
			st = new StringTokenizer(br.readLine());
			age = Integer.parseInt(st.nextToken());
			name = st.nextToken();
			person[i] = new Person(i, age, name);
		}
		
		Arrays.sort(person, (p1, p2) -> {
			if(p1.age == p2.age) return p1.id - p2.id;
			return p1.age - p2.age;
		});
		
		for(Person p : person)
			sb.append(p.age + " " + p.name + "\n");
		
		bw.write(sb.toString());
		bw.close();
		
	}

}