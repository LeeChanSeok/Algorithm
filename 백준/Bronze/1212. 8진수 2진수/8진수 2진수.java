import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        
        String N = br.readLine();

        String[] binary = {"000", "001", "010", "011", "100", "101", "110", "111"};
        for(int i = 0, len = N.length(); i < len; i++) {
            int octa = N.charAt(i) - '0';
            String bin = binary[octa];

            if(i == 0) {
                if(bin.startsWith("000")) {
                	 sb.append("0");
                }else if(bin.startsWith("00")) {
                    sb.append("1");
                }else if(bin.startsWith("0")) {
                	sb.append(bin.substring(1));
                }else {
                	sb.append(bin);
                }
            }else {
            	sb.append(bin);
            }
        }
        
        bw.write(sb.toString());
        bw.flush();
        
        bw.close();
        br.close();
    }

}
