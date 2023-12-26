import java.util.*;

class Solution {
    public String solution(String[] cards1, String[] cards2, String[] goal) {
        ArrayList<String> c1List = new ArrayList<>(Arrays.asList(cards1));
        ArrayList<String> c2List = new ArrayList<>(Arrays.asList(cards2));
        
        for(int i=0; i<goal.length; i++) {
            if(c1List.size()>0 && goal[i].equals(c1List.get(0))) { 
                c1List.remove(0);
                if (i==goal.length-1) break;
                
            } else if(c2List.size()>0 && goal[i].equals(c2List.get(0))) { 
                c2List.remove(0);
                if (i==goal.length-1) break;
                
            } else return "No";
        }        
        
        return "Yes";
    }
}
