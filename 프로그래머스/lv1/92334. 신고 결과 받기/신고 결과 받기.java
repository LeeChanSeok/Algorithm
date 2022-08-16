import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

class Solution {
	    public int[] solution(String[] id_list, String[] report, int k) {
	        int[] answer;
	        
	        int user_cnt = id_list.length;
	        answer = new int[user_cnt];
	        
	        // user name과 id 매핑
	        Map<String, Integer> user_id = new HashMap<>();
	        for(int i = 0; i < user_cnt; i++)
	        	user_id.put(id_list[i], i);
	        
	        // user별 신고 리스트
	        List<Set<String>> report_list = new ArrayList<>(user_cnt);
	        for(int i = 0; i < user_cnt; i++) {
	        	report_list.add(new HashSet<String>());
	        }
	        
	        int[] report_cnt = new int[user_cnt];
	        String[] rep;
	        
	        for(int i = 0; i < report.length; i++) {
	        	rep = report[i].split(" ");
	        	if(!report_list.get(user_id.get(rep[0])).contains(rep[1])) {
	        		report_list.get(user_id.get(rep[0])).add(rep[1]);
	        		report_cnt[user_id.get(rep[1])]++;
	        	}
	        }
	        
	        for(String name : id_list) {
	        	int id = user_id.get(name);
	        	if(report_cnt[id] >= k) {
	        		for(int i = 0; i < user_cnt; i++) {
	        			if(report_list.get(i).contains(name)) answer[i]++;
	        		}
	        	}
	        }
	        
	        
	        return answer;
	    }
}