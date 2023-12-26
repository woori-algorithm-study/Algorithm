import java.util.*;

class Solution {
    public int solution(int k, int m, int[] score) {
        int answer = 0;
        ArrayList<Integer> list = new ArrayList<>();
        
        for(int a : score)
            list.add(a);
      
        Collections.sort(list, Collections.reverseOrder());
        
        
        for(int i = 1; i <=score.length/m; i++){
            answer += list.get(i*m -1) * m;
        }
        return answer;
    }
}
