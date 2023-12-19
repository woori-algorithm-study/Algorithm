import java.util.*;
class Solution {
    public int solution(String A, String B) {
        int answer = -1;
        ArrayList<Integer> answers = new ArrayList<>();
        if(A.equals(B))
            answer = 0;
        else{
            for(int i = 0; i < A.length()-1; i++){
                String C = "";
                C += A.charAt(A.length()-1);
                System.out.println("A: " + A);
                for(int j = 0; j < A.length()-1; j++){
                    C += A.charAt(j);
                }
                if(C.equals(B)) answers.add(i+1);
                A = C;
            }
            int min = 101;
            for(Integer a : answers){
                if(a < min) min = a;
            }
        
            if(answers.size()==0)
                answer = -1;
            else
                answer = min;
        }
        
        return answer;
    }
}
