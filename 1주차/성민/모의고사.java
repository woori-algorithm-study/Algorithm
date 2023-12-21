import java.util.*;
class Solution {
    public int[] solution(int[] answers) {
        List<Integer> list = new ArrayList<>();
        int[] one = {1, 2, 3, 4, 5};
        int[] two = {2, 1, 2, 3, 2, 4, 2, 5};
        int[] three = {3, 3, 1, 1, 2, 2, 4, 4, 5, 5};
        int max = 0;
        
        int oneCnt = 0;
        int twoCnt = 0;
        int threeCnt = 0;
        
        for (int i = 0; i < answers.length; i++) {
            if (answers[i] == one[i % one.length]) {
                oneCnt++;
            }
            if (answers[i] == two[i % two.length]) {
                twoCnt++;
            }
            if (answers[i] == three[i % three.length]) {
                threeCnt++;
            }
        }
        max = Math.max(Math.max(oneCnt, twoCnt),threeCnt);
        
        if (max == oneCnt) list.add(1);
        if (max == twoCnt) list.add(2);
        if (max == threeCnt) list.add(3);
        
        int[] answer = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            answer[i] = list.get(i);
        }
        
        return answer;
    }
}