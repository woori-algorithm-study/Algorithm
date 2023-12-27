import java.util.*;
class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        ArrayList<Integer> list = new ArrayList<>();
        Stack<Integer> num = new Stack<>();
        for(int i = progresses.length-1; i >=0; i--){
            if((100-progresses[i])%speeds[i] != 0)
                num.add((100-progresses[i])/speeds[i] + 1);
            else
                num.add((100-progresses[i])/speeds[i]);
        }
        int now = num.pop();
        int task = 1;
        while(!num.isEmpty()){
            int next = num.pop();
            if(now>=next)
                task++;
            else{
                list.add(task);
                now = next;
                task = 1;
            }
        }
        list.add(task);
        int[] answer = new int[list.size()];
        for(int i = 0; i < answer.length; i++){
            answer[i] = list.get(i);
        }
        
        return answer;
    }
}
