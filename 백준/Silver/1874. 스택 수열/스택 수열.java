import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuffer sb = new StringBuffer();
        int N = Integer.parseInt(br.readLine());

        List<Integer> list = new ArrayList<>(N);

        int num, idx = 1, size = 0;
        boolean isPossible = true;
        for(int i = 0; i < N; ++i){
            num = Integer.parseInt(br.readLine());

            if(num >= idx) {
                while(idx <= num) {
                    list.add(idx++);
                    ++size;
                    sb.append("+\n");
                }
                list.remove(--size);
                sb.append("-\n");
            }else{
                if(list.contains(num)){
                    while(list.get(size-1) != num) {
                        list.remove(--size);
                        sb.append("+\n");
                    }
                    list.remove(--size);
                    sb.append("-\n");
                }
                else{
                    isPossible = false;
                    break;
                }
            }

        }

        if(!isPossible) System.out.println("NO");
        else{
            bw.write(sb.toString());
            bw.close();
        }

    }
}
