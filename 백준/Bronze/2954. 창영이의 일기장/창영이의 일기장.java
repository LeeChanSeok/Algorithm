import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); // BufferedReader를 통해 데이터를 입력받는다
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out)); // BufferedWriter를 통해 데이터를 출력한다
		StringBuilder sb = new StringBuilder(); // StringBuilder를 통해 출력할 결과를 모두 저장한 후  출력한다.

		String str = br.readLine(); // 문장을 입력받는다.
		char[] vowels = { 'a', 'e', 'i', 'o', 'u' }; // 모음에 대한 배열
		char c; // 문장의 각 자리 알파벳을 나타내기 위한 변수
		boolean isVowel;

		int i = 0;
		int strSize = str.length();
		while (i < strSize) {
			c = str.charAt(i); // 문장의 i번짜 알파벳을 저장한다;
			sb.append(c); // 현재 알파벳을 저장한다.

			isVowel = false; // 알파벳이 모음인지 아닌지 판단하기 위한 변수
			for (int j = 0, vSize = vowels.length; j < vSize; j++) { // 해당 위치의 알파벳이 모음인지 판단한다.
				if (vowels[j] == c) {
					isVowel = true;
					break;
				}
			}

			if (isVowel) // 모음이면 모음 다음에 'p'와 자기 자신을 건너 뛴 위치로 이동한다.
				i += 3;
			else		// 모음이 아니면 다음 위치로 이동한다
				i++; 

		}

		bw.write(sb.toString()); // 결과를 출력한다.
		bw.close();	// 버퍼에 남아있는 데이터를 추력한다.
	}
}
