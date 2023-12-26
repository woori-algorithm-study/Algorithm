import java.util.*;

class Solution {
    public String solution(String[] cards1, String[] cards2, String[] goal) {
        String answer = "Yes";
        Queue<String> q1 = new LinkedList<>();
        Queue<String> q2 = new LinkedList<>();
        
        for (int i = 0; i < cards1.length; i++) {
            q1.offer(cards1[i]);
        }
        
        for (int i = 0; i < cards2.length; i++) {
            q2.offer(cards2[i]);
        }
        
        for (int i = 0; i < goal.length; i++) {
            String s = goal[i];
            if (!q1.isEmpty() && q1.peek().equals(s)) {
                q1.poll();
            } else if (!q2.isEmpty() && q2.peek().equals(s)) {
                q2.poll();
            } else {
                answer = "No";
                break;
            }
            
        }
        
        return answer;
    }
}