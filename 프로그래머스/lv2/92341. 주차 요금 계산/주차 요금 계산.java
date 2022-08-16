import java.util.*;

class Solution {
    public int calc_time(String in, String out) {

		int inH, inM, outH, outM;

		inH = Integer.parseInt(in.split(":")[0]);
		inM = Integer.parseInt(in.split(":")[1]);

		outH = Integer.parseInt(out.split(":")[0]);
		outM = Integer.parseInt(out.split(":")[1]);

		return (outH * 60 + outM) - (inH * 60 + inM);
	}
    
    
    public int[] solution(int[] fees, String[] records) {
        int[] answer = {};

        Map<String, String> park_record = new HashMap<>();
        Map<String, Integer> parking_time = new HashMap<>();
        String[] info;
        int time;
        for (String record : records) {
            info = record.split(" ");

            if (info[2].equals("IN")) {
                park_record.put(info[1], info[0]);
            } else {
                time = calc_time(park_record.get(info[1]), info[0]);
                if (parking_time.containsKey(info[1])) {
                    parking_time.replace(info[1], parking_time.get(info[1]) + time);
                } else {
                    parking_time.put(info[1], time);
                }
                park_record.remove(info[1]);
            }
        }

        for (String carNum : park_record.keySet()) {
            time = calc_time(park_record.get(carNum), "23:59");
            if (parking_time.containsKey(carNum)) {
                parking_time.replace(carNum, parking_time.get(carNum) + time);
            } else {
                parking_time.put(carNum, time);
            }
        }


        int carCnt = parking_time.size();
        answer = new int[carCnt];
        List<String> carNum = new ArrayList<>(parking_time.keySet());
        Collections.sort(carNum);

        for(int i = 0; i < carCnt; i++) {
            time = parking_time.get(carNum.get(i));
            if(time <= fees[0]) answer[i] = fees[1];
            else {
                int temp = (int)Math.ceil((double)(time - fees[0])/fees[2]);
                answer[i] = fees[1] + temp*fees[3];
            }
        }

        return answer;
    }
}