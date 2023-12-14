import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	static int[] cube;

	public static void main(String[] args) throws Exception {

		input();
		pro();

	}

	private static void pro() {
		if (rotate())
			System.out.println("1");
		else
			System.out.println("0");
	}

	private static boolean rotate() {
		  //(13, 14, 15, 16)면 회전
        leftToUp();		
        if(cubeCheck()) return true;
        leftToDown();

        leftToDown();
        if(cubeCheck()) return true;
        leftToUp();
        
        //(17, 18, 19, 20)면 회전
        rightToUp();
        if(cubeCheck()) return true;
        rightToDown();
        
        rightToDown();
        if(cubeCheck()) return true;
        rightToUp();

        //(1, 2, 3, 4)면 회전
        upToRight();
        if(cubeCheck()) return true;
        upToLeft();

        upToLeft();
        if(cubeCheck()) return true;
        upToRight();

        //(9, 10, 11, 12)면 회전
        downToRight();
        if(cubeCheck()) return true;
        downToLeft();

        downToLeft();
        if(cubeCheck()) return true;
        downToRight();

        //(5, 6, 7, 8)면 회전
        bottomToLeft();
        if(cubeCheck()) return true;
        bottomToRight();

        bottomToRight();
        if(cubeCheck()) return true;
        bottomToLeft();

        //(21, 22, 23, 24)면 회전
        topToLeft();
        if(cubeCheck()) return true;
        topToRight();

        topToRight();
        if(cubeCheck()) return true;
        topToLeft();

        return false;
	}

	
    //큐브 풀었는지 확인하는 함수
    static boolean cubeCheck(){
        for(int i=1;i<25;i+=4){
            if(cube[i] != cube[i+1] || cube[i+1]!=cube[i+2] || cube[i+2] != cube[i+3])
                return false;
        }
        return true;
    }
    
    //(13, 14, 15, 16)면 반시계 회전
    static void leftToUp(){
        int t1 = cube[1];
        int t2 = cube[3];
        cube[3] = cube[22];
        cube[1] = cube[24];
        cube[24] = cube[9];
        cube[22] = cube[11];
        cube[9] = cube[5];
        cube[11] = cube[7];
        cube[5] = t1;
        cube[7] = t2;
    }
    //(13, 14, 15, 16)면 시계 회전
    static void leftToDown(){
        int t1 = cube[1];
        int t2 = cube[3];
        cube[1] = cube[5];
        cube[3] = cube[7];
        cube[5] = cube[9];
        cube[7] = cube[11];
        cube[9] = cube[24];
        cube[11] = cube[22];
        cube[22] = t2;
        cube[24] = t1;
    }
    //(17, 18, 19, 20)면  시계 회전
    static void rightToUp(){
        int t1 = cube[2];
        int t2 = cube[4];
        cube[4] = cube[21];
        cube[2] = cube[23];
        cube[23] = cube[10];
        cube[21] = cube[12];
        cube[10] = cube[6];
        cube[12] = cube[8];
        cube[6] = t1;
        cube[8] = t2;
    }
    //(17, 18, 19, 20)면 반시계 회전
    static void rightToDown(){
        int t1 = cube[2];
        int t2 = cube[4];
        cube[2] = cube[6];
        cube[4] = cube[8];
        cube[6] = cube[10];
        cube[8] = cube[12];
        cube[10] = cube[23];
        cube[12] = cube[21];
        cube[21] = t2;
        cube[23] = t1;
    }
    //(1, 2, 3, 4)면 반시계 회전
    static void upToRight(){
        int t1 = cube[13];
        int t2 = cube[14];
        cube[13] = cube[22];
        cube[14] = cube[21];
        cube[21] = cube[18];
        cube[22] = cube[17];
        cube[17] = cube[5];
        cube[18] = cube[6];
        cube[5] = t1;
        cube[6] = t2;
    }
    //(1, 2, 3, 4)면 시계 회전
    static void upToLeft(){
        int t1 = cube[13];
        int t2 = cube[14];
        cube[13] = cube[5];
        cube[14] = cube[6];
        cube[5] = cube[17];
        cube[6] = cube[18];
        cube[17] = cube[22];
        cube[18] = cube[21];
        cube[21] = t2;
        cube[22] = t1;
    }
    //(9, 10, 11, 12)면 시계 회전
    static void downToRight(){
        int t1 = cube[15];
        int t2 = cube[16];
        cube[15] = cube[24];
        cube[16] = cube[23];
        cube[23] = cube[20];
        cube[24] = cube[19];
        cube[19] = cube[7];
        cube[20] = cube[8];
        cube[7] = t1;
        cube[8] = t2;
    }
    //(9, 10, 11, 12)면 반시계 회전
    static void downToLeft(){
        int t1 = cube[15];
        int t2 = cube[16];
        cube[15] = cube[7];
        cube[16] = cube[8];
        cube[7] = cube[19];
        cube[8] = cube[20];
        cube[19] = cube[24];
        cube[20] = cube[23];
        cube[23] = t2;
        cube[24] = t1;
    }
    //(5, 6, 7, 8)면 반시계 회전
    static void bottomToLeft(){
        int t1 = cube[5];
        int t2 = cube[4];
        cube[5] = cube[6];
        cube[6] = cube[8];
        cube[8] = cube[7];
        cube[7] = t1;
        t1 = cube[3];
        cube[3] = cube[17];
        cube[4] = cube[19];
        cube[17] = cube[10];
        cube[19] = cube[9];
        cube[9] = cube[14];
        cube[10] = cube[16];
        cube[14] = t2;
        cube[16] = t1;
    }
    //(5, 6, 7, 8)면 시계 회전
    static void bottomToRight(){
        int t1 = cube[5];
        int t2 = cube[4];
        cube[5] = cube[7];
        cube[7] = cube[8];
        cube[8] = cube[6];
        cube[6] = t1;
        t1 = cube[3];
        cube[3] = cube[16];
        cube[4] = cube[14];
        cube[14] = cube[9];
        cube[16] = cube[10];
        cube[9] = cube[19];
        cube[10] = cube[17];
        cube[17] = t1;
        cube[19] = t2;
    }
    //(21, 22, 23, 24)면 반시계 회전
    static void topToLeft(){
        int t1 = cube[21];
        int t2 = cube[2];
        cube[21] = cube[22];
        cube[22] = cube[24];
        cube[24] = cube[23];
        cube[23] = t1;
        t1 = cube[1];
        cube[1] = cube[18];
        cube[2] = cube[20];
        cube[18] = cube[12];
        cube[20] = cube[11];
        cube[11] = cube[13];
        cube[12] = cube[15];
        cube[13] = t2;
        cube[15] = t1;
    }
    //(21, 22, 23, 24)면 시계 회전
    static void topToRight(){
        int t1 = cube[21];
        int t2 = cube[2];
        cube[21] = cube[23];
        cube[23] = cube[24];
        cube[24] = cube[22];
        cube[22] = t1;
        t1 = cube[1];
        cube[1] = cube[15];
        cube[2] = cube[13];
        cube[13] = cube[11];
        cube[15] = cube[12];
        cube[11] = cube[20];
        cube[12] = cube[18];
        cube[18] = t1;
        cube[20] = t2;
    }
	
	private static void input() throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		cube = new int[25];
		for(int i = 1; i <= 24; ++i) {
			cube[i] = Integer.parseInt(st.nextToken());
		}

	}

}