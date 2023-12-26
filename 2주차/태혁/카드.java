import java.util.*;
class Solution {
    public String solution(String[] cards1, String[] cards2, String[] goal) {
        String answer = "No";
        int card1 = 0;
        int card2 = 0;
        ArrayList<String> list = new ArrayList<>();
                
        for(int i = 0; i < goal.length; i++){
            if(card1<cards1.length && cards1[card1].equals(goal[i])){
                card1++;
                list.add(goal[i]);
            }
            
            if(card2<cards2.length && cards2[card2].equals(goal[i])){
                card2++;
                list.add(goal[i]);
            }
        }
        
        if(list.size() == goal.length){
            boolean same = true;
            
            for(int i = 0; i <list.size(); i++){
                if(list.get(i)!=goal[i]) same = false;
            }
            
            if(same) answer = "Yes";
        }
        
        return answer;
    }
}
