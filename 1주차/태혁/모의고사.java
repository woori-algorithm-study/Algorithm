
import java.util.*;
class Solution {
    public int[] solution(int[] answers) {
        ArrayList<Integer> answer = new ArrayList<>();
        int[] list1 = {1,2,3,4,5};        
        int[] list2 = {2,1,2,3,2,4,2,5};
        int[] list3 = {3,3,1,1,2,2,4,4,5,5};
        
        int answer1 = 0;
        int answer2 = 0;
        int answer3 = 0;
        
        int max = 0;
        
        for(int i = 0; i < answers.length; i++){
            if(answers[i] == list1[i%list1.length]){
                answer1++;
                if(answer1>max)
                    max = answer1;
            }
            
            if(answers[i] == list2[i%list2.length]){
                answer2++;
                if(answer2>max)
                    max = answer2;
            }
            
            if(answers[i] == list3[i%list3.length]){
                answer3++;
                if(answer3>max)
                    max = answer3;
            }
        }
        
        if(answer1==max) answer.add(1);
        if(answer2==max) answer.add(2);
        if(answer3==max) answer.add(3);
        
        int[] ansArr = new int[answer.size()];
        for(int i = 0; i < ansArr.length; i++){
            ansArr[i] = answer.get(i);
        }
        
        
        return ansArr;
    }
}
