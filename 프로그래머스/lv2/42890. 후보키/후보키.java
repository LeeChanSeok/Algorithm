import java.util.*;

class Solution {

    Set<String> candidate;
    int R, C;
    String[][] relation_;

    public int solution(String[][] relation) {
        candidate = new HashSet<>();;
        relation_ = relation;

        R = relation.length;
        C = relation[0].length;

        for(int c = 1; c <= C; ++c) {
            combination(0, c, 0, "");
        }

        return candidate.size();
    }

    private void combination(int idx, int c, int cnt, String pick) {

        if(isDuplicate(pick, candidate)) return;

        if(c == cnt) {
            if(isCandidate(relation_, pick, R, C)) {
                candidate.add(pick);
            }

            return;
        }

        for(int i = idx; i < C; ++i) {
            combination(i + 1, c, cnt+1, pick+i);
        }


    }

    private boolean isDuplicate(String pick, Set<String> candidate) {

        int same, keyCnt;
        int pickCnt = pick.length();
        for(String key : candidate) {
            same = 0;
            keyCnt = key.length();
            for(int i = 0; i < pickCnt; ++i) {
                for(int j = 0; j < keyCnt; ++j) {
                    if(pick.charAt(i) == key.charAt(j)) ++same;
                }
            }
            if(same == keyCnt) return true;
        }

        return false;
    }

    public boolean isCandidate(String[][] relation, String pick, int R, int C){

        List<String> entities = new LinkedList<>();
        String entity;
        int pickCnt = pick.length();
        for(int i = 0; i < R; ++i){
            entity = "";
            for(int j = 0; j < pickCnt; ++j)
                entity += relation[i][(int)(pick.charAt(j) - '0')];

            if(entities.contains(entity)) return false;
            entities.add(entity);
        }

        return true;   
    }
}