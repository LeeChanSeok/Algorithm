import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {
	
	static class Person{
		String name;
		boolean leave;
		
		public Person(String name) {
			this.name = name;
		}
		
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		
		int N = Integer.parseInt(br.readLine());
		Map<String, Person> indexMap = new HashMap<>();
		
		int alphSize = 26*2;
		List<Person>[] alphList = new LinkedList[alphSize];
		for(int i = 0; i < alphSize; ++i) {
			alphList[i] = new LinkedList<>();
		}
		
		String name;
		char EL;
		for(int i = 0; i < N; ++i) {
			st = new StringTokenizer(br.readLine());
			
			name = st.nextToken();
			EL = st.nextToken().charAt(0);
			
			if(EL == 'e') {
				Person person = new Person(name);
				int idx = calcIdx(name.charAt(0));
				alphList[idx].add(person);
				indexMap.put(name, person);
			}
			else {
				indexMap.get(name).leave = true; 
			}
		}
		
		// 떠난 사원들 List에서 제거
		for(int i = 0; i < alphSize; ++i) {
			ListIterator<Person> iter = alphList[i].listIterator();
			while(iter.hasNext()) {
				if(iter.next().leave) iter.remove();
			}
		}
		
		for(int i = 0; i < alphSize; i++) {
			Collections.sort(alphList[i], (p1, p2) -> p2.name.compareTo(p1.name));
		}

		for(int i = alphSize-1; i >= 0; --i) {
			ListIterator<Person> iter = alphList[i].listIterator();
			while(iter.hasNext())
				sb.append(iter.next().name).append("\n");
		}
		
		bw.write(sb.toString());
		bw.close();
	}
	
	public static int calcIdx(char c) {
		if(c >= 'a') return c - 'a' + 26;
		else return c - 'A';
	}
}