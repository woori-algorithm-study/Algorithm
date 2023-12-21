import java.util.ArrayList;
//import java.utill.Math;

class Solution {
    public int[] solution(int[] answers) {
        ArrayList<Integer> answer = new ArrayList<>();
        int[] one = {1,2,3,4,5};
        int[] two = {2,1,2,3,2,4,2,5};
        int[] three = {3,1,2,4,5};
        
        int[] score = new int[3];
        
        for(int i = 0; i<answers.length; i++){
        if(answers[i] == one[i%5]){score[0]++;}  
        if(answers[i] == two[i%two.length]){score[1]++;}

        if(answers[i] == three[i%three.length]){score[2]++;}
        }
        int max =0;
        for(int x : score){
            if(max<=x){max=x;}
       }
        
       for(int k=0; k<score.length; k++){
           if(max == score[k]){
               answer.add(k)
           }
       }
            
            
        return answer.stream().mapToInt(i->i).toArray();
    }
}