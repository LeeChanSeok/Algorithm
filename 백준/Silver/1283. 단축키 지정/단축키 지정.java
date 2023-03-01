import java.io.*;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class Main {
    static StringBuilder sb = new StringBuilder();
    static Set<Character> Alpa = new HashSet<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine());

        String str;
        String[] words;
        for(int i = 0; i < N; ++i){
            str = br.readLine();
            words = str.split(" ");

            // 1. 각 단어의 첫번째 글자 등록
            if(checkFirstWord(words)) continue;

            // 2. 왼쪽부터 차례대로
            if(checkAllChar(words)) continue;

            // 3. 단축키 지정 x
            sb.append(str).append("\n");

        }
        bw.write(sb.toString());
        bw.close();
    }

    private static boolean checkAllChar(String[] words) {
        boolean regist = false;
        StringBuilder innerSB = new StringBuilder();
        for(String word : words){
            if(!regist) {
                for(int i = 0, len = word.length(); i < len; ++i){
                    char c = word.charAt(i);
                    if(!Alpa.contains(Character.toLowerCase(c))){
                        Alpa.add(Character.toLowerCase(c));
                        String newWord = word.substring(0, i) + "[" + c + "]" + word.substring(i+1);
                        innerSB.append(newWord).append(" ");
                        regist = true;
                        break;
                    }
                }
                if(!regist) innerSB.append(word).append(" ");
            }else innerSB.append(word + " ");
        }

        if(regist) {
            sb.append(innerSB).append("\n");
            return true;
        }
        return false;
    }

    private static boolean checkFirstWord(String[] words) {
        boolean regist = false;
        StringBuilder innerSB = new StringBuilder();
        for(String word : words){
            char first = word.charAt(0);
            if(!regist && !Alpa.contains(Character.toLowerCase(first))){
                Alpa.add(Character.toLowerCase(first));
                String newWord = "[" + first + "]" + word.substring(1);
                innerSB.append(newWord).append(" ");
                regist = true;
                
            }else innerSB.append(word + " ");

        }
        if(regist) {
            sb.append(innerSB).append("\n");
            return true;
        }
        return false;
    }

} 
